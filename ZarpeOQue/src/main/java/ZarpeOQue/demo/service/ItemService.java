/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ZarpeOQue.demo.service;

import ZarpeOQue.demo.domain.Item;
import java.util.ArrayList;
import java.util.List;


public interface ItemService {
    
    
    List<Item> listaItems = new ArrayList<>();

    public List<Item> gets();

    //Se recupera el registro que tiene el idItem pasado por parametro

    //si no existe en la tabla se retorna null
    public Item get(Item item);

    //Se elimina el registro que tiene el idItem pasado por parámetro

    public void delete(Item item);

    //Si el objeto item tiene un idItem que existe en la tabla item

    //El registro de actualiza con la nueva informacióncon esa información

    public void save(Item item);

    public void actualiza(Item item);

    public void facturar();

}
