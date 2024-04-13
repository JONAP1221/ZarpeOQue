/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZarpeOQue.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Producto {
    
    private int cantidad; //Almacenar la cantidad de items del carrito

    public Item() {
    }
    
    public Item(Producto producto) {
        super.setIdProducto(producto.getIdProducto());
        super.setCategoria(producto.getCategoria());
        super.setDescripcion(producto.getDescripcion());
        super.setDetalle(producto.getDetalle());

        super.setPrecioBruto(producto.getPrecioBruto());
        super.setPrecioNeto(producto.getPrecioNeto());
        super.setExistencias(producto.getExistencias());
        super.setRutaImagen(producto.getRutaImagen());
        this.cantidad = 0;
    }
}