/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ZarpeOQue.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UsuarioDetailsService {
     /*
       Este método en la interfaz es responsable de cargar los detalles de un usuario basados en su nombre de usuario. 
       Toma un nombre de usuario como argumento y devuelve un objeto UserDetails. Si el usuario no se encuentra, lanza una excepción UsernameNotFoundException. 
    */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
     // Se obtiene un listado de usuarios en un List
    
}
