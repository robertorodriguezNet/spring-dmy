package net.robertorodriguez.propio.web.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        usuario.setEmail("andres@correo.con");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario " + usuario.getNombre());

        return "perfil";

    }

    /**
     * Carga la lista de usuarios.
     * 
     * @param model Model
     * @return la vista
     */
    @RequestMapping("/lista")
    public String listar(Model model) {

        // List<Usuario> usuarios = new ArrayList<>();
        // usuarios.add( new Usuario("Andrés","Montes Pinto","andres@correo.con"));
        // usuarios.add( new Usuario("Juana","Pérez Martín","juana@correo.con"));
        // usuarios.add( new Usuario("Luisa","López Lorenzo","luisa@correo.con"));

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Andrés", "Montes Pinto", "andres@correo.con"),
                new Usuario("Juana", "Pérez Martín", "juana@correo.con"),
                new Usuario("Luisa", "López Lorenzo", "luisa@correo.con"),
                new Usuario("Benito", "Hernandez Pancha", "benito@correo.con"));

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "lista";
    }

}
