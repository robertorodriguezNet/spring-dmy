package net.robertorodriguez.propio.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    /**
     * Buscamos un parámetro en la URL llamado texto
     * @param texto parámetro recibido en la URL
     * @param model Modelo de datos
     * @return la vista
     */
    @GetMapping("/string")
    public String param(@RequestParam String texto, Model model) {

        model.addAttribute("titulo","Ejemplo de paso de parámteros");
        model.addAttribute("resultado", "El parámetro recibido es " + texto );

        return "params/ver";
    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("titulo", "Enviar datos por HTTP GET");

        return "params/index";
    }

}
