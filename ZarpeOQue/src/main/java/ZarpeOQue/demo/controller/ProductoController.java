package ZarpeOQue.demo.controller;

import ZarpeOQue.demo.domain.Categoria;
import ZarpeOQue.demo.domain.Producto;
import ZarpeOQue.demo.service.CategoriaService;
import ZarpeOQue.demo.service.ProductoService;
import ZarpeOQue.demo.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jonathan
 */
@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        model.addAttribute("totalProductos", productos.size());
        return "/producto/listado";
    }

    @GetMapping("/listadoCategoriaX")
    public String listadoCategoriaX(@RequestParam("categoriaId") Long categoria, Model model) {
        List<Producto> productos = productoService.getProductosByCategoria(categoria);

        model.addAttribute("productos", productos);

        return "/producto/listadoCategoriaX";
    }

    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @PostMapping("/guardar2")
    public String productoGuardar2(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        productoService.save(producto); // Guardar el producto en la base de datos
        // Obtener el producto guardado para obtener su ID
        Producto productoGuardado = productoService.getProducto(producto);
        if (productoGuardado != null) {
            // Si se encuentra el producto guardado, obtener su ID y cargar la imagen
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            productoGuardado.getIdProducto()));
        } else {
            // Si no se encuentra el producto guardado, manejar el caso de error
            log.error("Error al guardar el producto. No se pudo obtener el ID del producto guardado.");
            // Podrías lanzar una excepción, mostrar un mensaje de error al usuario, etc.
        }

        List<Categoria> listaCategorias = categoriaService.getCategorias(false);
        for (Categoria categoria : listaCategorias) {
            if (categoria.getIdCategoria().equals(producto.getCategoria())) {
                System.out.println("Categoría encontrada");
                productoService.save(producto);
                return "redirect:/producto/listado";
            }
        }
        // Si llegamos aquí, la categoría no fue encontrada
        System.out.println("Categoría no encontrada");
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/producto/modifica";
    }
}//final de la clase
