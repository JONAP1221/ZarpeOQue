
package ZarpeOQue.demo.dao;
import ZarpeOQue.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gabriel badilla
 */
public interface CategoriaDao extends JpaRepository <Categoria,Long>{
    
}//final de la interface
