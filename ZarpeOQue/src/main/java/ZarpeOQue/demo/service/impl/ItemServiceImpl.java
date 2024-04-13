/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZarpeOQue.demo.service.impl;

import ZarpeOQue.demo.dao.FacturaDao;
import ZarpeOQue.demo.dao.ProductoDao;
import ZarpeOQue.demo.dao.VentaDao;
import ZarpeOQue.demo.domain.Factura;
import ZarpeOQue.demo.domain.Item;
import ZarpeOQue.demo.domain.Producto;
import ZarpeOQue.demo.domain.Usuario;
import ZarpeOQue.demo.domain.Venta;
import ZarpeOQue.demo.service.ItemService;
import ZarpeOQue.demo.service.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class ItemServiceImpl implements ItemService{

    @Override
    public List<Item> gets() {
        return listaItems; 
    }

    @Override
    public Item get(Item item) {
        
        for(Item i : listaItems){
            
            if(Objects.equals(i.getIdProducto(), item.getIdProducto())){
                
                return i;
            }
        }
        return null;
        
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        
        for(Item i : listaItems){
            ++posicion;
            if(Objects.equals(i.getIdProducto(), item.getIdProducto())){
                existe = true;
                break;
            }
            
        }
        if(existe){
            listaItems.remove(posicion);
            
        }
      
    }
    
    @Override
    public void save(Item item) {

        boolean existe = false;
        
        for (Item i : listaItems) {
            
            if(Objects.equals(i.getIdProducto(), item.getIdProducto())){
                
                if(i.getCantidad() < item.getExistencias()){
                    
                    i.setCantidad(i.getCantidad() + 1);
                
                }
                existe = true;
                break;
            }
            
            
        }
        if(!existe){
            
            item.setCantidad(1);
            listaItems.add(item);
        }
      
        
    }

    @Override
    public void actualiza(Item item) {
        
        for(Item i : listaItems){
            
            if(Objects.equals(i.getIdProducto(), item.getIdProducto())){
                
                i.setCantidad(item.getCantidad());
                break;
            }
        }
        
    }
    
    @Autowired
    private UsuarioService uuarioService;
    @Autowired
    private FacturaDao facturaDao;
    @Autowired

    private VentaDao ventaDao;
    @Autowired
    private ProductoDao productoDao;

    @Override
    public void facturar() {
        System.out.println("Facturando... aguarde");
        
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails userDetails) {
            
            username = userDetails.getUsername();
            } else {
            
                username = principal.toString();
            }
            if (username.isBlank()) {
                return;
            }
    
            Usuario uuario = uuarioService.getUsuarioPorUsername(username);
            
            if (uuario == null) {
                
                return;
            }
            
            Factura factura = new Factura(uuario.getIdUsuario());
            
            factura = facturaDao.save(factura);

            double total = 0;
            
            for (Item i : listaItems) {
                
                System.out.println("Producto: " + i.getDescripcion() + " Cantidad: " + i.getCantidad() + " Total: " + (i.getPrecioNeto() * i.getCantidad()));
                
                Venta venta = new Venta(factura.getIdFactura(),i.getIdProducto(), i.getPrecioNeto(), i.getCantidad());
                
                ventaDao.save(venta);
                
                Producto producto = productoDao.getReferenceById(i.getIdProducto());producto.setExistencias(producto.getExistencias()-i.getCantidad());

                productoDao.save(producto);
                
                total += i.getPrecioNeto() * i.getCantidad();

            
            }
            factura.setTotal(total);
            facturaDao.save(factura);
            listaItems.clear();

           
    }
       
    
    
}
