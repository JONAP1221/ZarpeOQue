
package ZarpeOQue.demo.service.impl;

import ZarpeOQue.demo.dao.ProductoDao;
import ZarpeOQue.demo.domain.Producto;
import ZarpeOQue.demo.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Jonathan
 */

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        return productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProductos(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
}//Final de la clase
