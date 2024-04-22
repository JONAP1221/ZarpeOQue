/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZarpeOQue.demo.controller;

import ZarpeOQue.demo.domain.Rol;
import ZarpeOQue.demo.service.FirebaseStorageService;
import ZarpeOQue.demo.service.RolService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gabriel badilla
 */
@Controller
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private RolService rolService;
    

    @GetMapping("/nuevo")
    public String rolNuevo(Rol rol) {
        return "/rol/modifica";
    }

   @PostMapping("/guardar")
    public String usuarioGuardar(Rol rol) {
        rolService.save(rol);
        return "redirect:/rol/listado";
    }

    @GetMapping("/eliminar")
    public String usuarioEliminar(@RequestParam("nombre") String nombre, @RequestParam("idUsuario") String idUsuario) {
        // Validación de entrada
        if (nombre == null || idUsuario == null) {
            return "redirect:/error"; // Redirecciona a una página de error
        }

        rolService.delete(nombre, idUsuario);
        return "redirect:/usuario/listado";
    }
}
