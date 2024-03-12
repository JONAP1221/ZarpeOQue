package ZarpeOQue.demo.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data​
@Entity​
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id​
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precioBruto;
    private double precioNeto;
    private int existencias;
    private String rutaImagen;

    @ManyToOne​
    @JoinColumn(name="id_categoria")
    Categoria categoria;

    public Producto() {        
    }


    public Producto(String descripcion, String detalle, double precioBruto,double precioNeto, int existencias, String imagen, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precioBruto = precioBruto;
        this.precioNeto = precioNeto;
        this.existencias = existencias;
        this.rutaImagen = imagen;
        this.categoria = categoria;
    }
    
    
}//final de la clase
