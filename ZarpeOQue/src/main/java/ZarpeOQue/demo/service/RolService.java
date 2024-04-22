/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ZarpeOQue.demo.service;

import ZarpeOQue.demo.domain.Rol;
import java.util.List;

/**
 *
 * @author gabriel badilla
 */
public interface RolService {
    // Se obtiene un listado de usuarios en un List
    public List<Rol> getRol();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Rol getRol(Rol rol);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Rol getRolPorNombre(String nombre);
    
    public Rol getRolPorIdRol(long id);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Rol getRolPorNombreYIdUsuario(String nombre, long idUsuario);    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Rol rol);
    
    public void delete(String nombre, String idUsuario);
    
}
