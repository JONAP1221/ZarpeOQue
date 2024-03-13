
package ZarpeOQue.demo.controller;

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
@RequestMapping("/menu")
public class registrocontroller {
    
    @GetMapping("/registro")
    public String inicio() {
        return "/menu/registro";
    }
    
}//final de la clase
