package ZarpeOQue.demo.dao;

import ZarpeOQue.demo.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentaDao extends JpaRepository <Venta,Long>{
    
}
