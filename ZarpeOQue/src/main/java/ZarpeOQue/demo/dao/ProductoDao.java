
package ZarpeOQue.demo.dao;
import ZarpeOQue.demo.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Jonathan
 */
public interface ProductoDao extends JpaRepository<Producto, Long>{
    
}//final de la interface
