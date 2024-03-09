package ZarpeOQue.demo.service;

import ZarpeOQue.demo.domain.Producto;
import java.util.List;
/**
 *
 * @author Jonathan
 */
public interface ProductoService {
    // Se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);
    
   // Se obtiene un Producto, a partir del id de un producto
    public Producto getProductos(Producto producto);
    
    // Se inserta un nuevo producto si el id del categoria esta vacío
    // Se actualiza un producto si el id del categoria NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
}//final de la interface
