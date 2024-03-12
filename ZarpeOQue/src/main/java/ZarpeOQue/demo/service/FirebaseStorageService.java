/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ZarpeOQue.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "zarpeoque-3da67.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "C:\\Projectos\\ZarpeOQue";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "C:\\Projectos\\ZarpeOQue\\ZarpeOQue\\src\\main\\resources\\firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "zarpeoque-3da67-firebase-adminsdk-go10c-7521ec6b6a.json";
}
