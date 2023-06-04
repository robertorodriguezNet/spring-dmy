package net.robertorodriguez.propio.web.web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String contactoPage(Map<String, Object> map) {

        map.put("titulo", "Contacto");
        return "contactoPage";
    }

}
