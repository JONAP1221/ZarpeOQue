/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZarpeOQue.demo.service.impl;

import ZarpeOQue.demo.dao.RolDao;
import ZarpeOQue.demo.dao.UsuarioDao;
import ZarpeOQue.demo.domain.Rol;
import ZarpeOQue.demo.domain.Usuario;
import ZarpeOQue.demo.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gabriel badilla
 */
@Service
public class RolServiceImpl implements RolService{
        
    @Autowired
    private RolDao rolDao;

    @Override
    public List<Rol> getRol() {
        return rolDao.findAll();    
    }

    @Override
    @Transactional(readOnly = true)
    public Rol getRol(Rol rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);  
    }

    @Override
    @Transactional(readOnly = true)
    public Rol getRolPorNombre(String nombre) {
        return rolDao.findByNombre(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Rol getRolPorIdRol(long idRol) {
        return rolDao.findByIdRol(idRol);
    }

    @Override
    public Rol getRolPorNombreYIdUsuario(String nombre, long idUsuario) {
        return rolDao.findByNombreAndIdUsuario(nombre, idUsuario);
    }

    @Override
    public void save(Rol rol) {
        List<Rol> roles = rolDao.findAll();
        boolean encontrado = false; // Variable para controlar si se encuentra un rol existente con los mismos criterios

        for (Rol r : roles) {
            if (r.getIdUsuario().equals(rol.getIdUsuario()) && r.getNombre().equals(rol.getNombre())) {
                // Si se encuentra un rol existente con el mismo idUsuario y nombre, no se agrega el nuevo rol
                encontrado = true;
                break; // Salir del bucle porque ya se encontró un rol que coincide
            }
        }

        // Si no se encontró un rol existente con los mismos criterios, agregar el nuevo rol
        if (!encontrado) {
            rolDao.save(rol);
            System.out.println("El rol ha sido guardado.");
        } else {
            System.out.println("Ya existe un rol con el mismo idUsuario y nombre.");
        }
    }
    
    @Override
    public void delete(String idrol, String idUsuario) {
        // Buscar el rol por su nombre y ID de usuario
        Long id = Long.parseLong(idrol);
        rolDao.delete(rolDao.findByIdRol(id));
    }   
}
