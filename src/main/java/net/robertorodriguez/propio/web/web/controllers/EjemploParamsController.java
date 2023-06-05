package net.robertorodriguez.propio.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    /**
     * Buscamos un parámetro en la URL llamado texto
     * 
     * @param texto parámetro recibido en la URL
     * @param model Modelo de datos
     * @return la vista
     */
    @GetMapping("/string")
    public String param(@RequestParam String texto, Model model) {

        model.addAttribute("titulo", "Ejemplo de paso de parámteros");
        model.addAttribute("resultado", "El parámetro recibido es " + texto);

        return "params/ver";
    }

    /**
     * Enviar varios parámetros y de diferentes tipos
     * 
     * @param texto
     * @param model
     * @return
     */
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {

        model.addAttribute("titulo", "Ejemplo de paso de parámteros");
        model.addAttribute("resultado", "El saludo recibido es '" + saludo + "' y número es '" + numero + "'");

        return "params/ver";
    }

    /**
     * Enviar varios parámetros y de diferentes tipos
     * 
     * @param texto
     * @param model
     * @return
     */
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {

        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }

        model.addAttribute("titulo", "Ejemplo de paso de parámteros");
        model.addAttribute("resultado", "El saludo recibido es '" + saludo + "' y número es '" + numero + "'");

        return "params/ver";
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("titulo", "Enviar datos por HTTP GET");

        return "params/index";
    }

}
