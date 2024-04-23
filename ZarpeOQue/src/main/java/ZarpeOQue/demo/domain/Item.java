package ZarpeOQue.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Jonathan
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Producto {

    private int cantidad; //Almacenar la cantidad de items de un producto

    public Item() {
    }

    public Item(Producto producto) {
        super.setIdProducto(producto.getIdProducto());
        super.setCategoria(producto.getCategoria());
        super.setDescripcion(producto.getDescripcion());
        super.setDetalle(producto.getDetalle());
        super.setPrecioNeto(producto.getPrecioNeto());
        super.setPrecioBruto(producto.getPrecioBruto());
        super.setExistencias(producto.getExistencias());
        super.setRutaImagen(producto.getRutaImagen());
        this.cantidad = 0;
    }
}
