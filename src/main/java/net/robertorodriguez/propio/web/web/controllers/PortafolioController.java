package net.robertorodriguez.propio.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PortafolioController {

    @GetMapping("/portafolio")
    public ModelAndView portafolio(ModelAndView mv) {
        mv.setViewName("portafolioPage");
        mv.addObject("titulo", "Portafolio");
        return mv;
    }

}
