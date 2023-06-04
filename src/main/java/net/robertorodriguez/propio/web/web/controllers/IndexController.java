package net.robertorodriguez.propio.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    /**
     * Usamos la interfaz Model para pasar datos a la vista.
     * @param model mapa de datos para pasar a la vista
     * @return la vista.
     */
    @GetMapping({"/index","/","","/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }
    
}
