
package ZarpeOQue.demo.dao;
import ZarpeOQue.demo.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    List<Producto> findByPrecioNetoBetweenOrderByDescripcionAsc(double precioMin, double precioMax);
     
     List<Producto> findByCategoriaIdCategoria(Long idCategoria);
    
}//final de la interface
