package net.robertorodriguez.propio.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.robertorodriguez.propio.web.web.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

    /**
     * Usamos la interfaz Model para pasar datos a la vista.
     * La vista siempre se busca en resources/templates. Si la vista está en
     * algún subdirectorio, se indica al retornar.
     * 
     * @param model mapa de datos para pasar a la vista
     * @return la vista.
     */
    @GetMapping({ "/index", "/", "", "/home" })
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }

    /**
     * Handler para mostrar un usuario
     * Si no se especifica el método en RequestMapping, es GET.
     */
    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Andrés");
        usuario.setApellidos("Montes Pinto");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario " + usuario.getNombre( ));

        return "perfil";

    }
}
