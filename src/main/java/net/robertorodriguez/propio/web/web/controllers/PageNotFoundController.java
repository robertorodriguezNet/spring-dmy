package net.robertorodriguez.propio.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageNotFoundController {

    /**
     * El método pasa datos a la vista usando la interfaz ModelMap.
     * @param model Map que contiene los datos que se pasan a la vista.
     * @return la vista
     */
    @GetMapping("/404")
    public String pageNotFoundPage(ModelMap model){

        model.addAttribute("titulo", "Recurso no encontrado");
        return "pageNotFoundPage";

    }
    
}
