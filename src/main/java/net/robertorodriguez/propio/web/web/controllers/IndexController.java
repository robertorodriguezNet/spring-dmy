package net.robertorodriguez.propio.web.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.robertorodriguez.propio.web.web.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

    // Valores globales definidos en aplication.properties
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

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
        model.addAttribute("titulo", textoIndex);
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
        model.addAttribute("titulo", textoPerfil + " " + usuario.getNombre());

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

        model.addAttribute("titulo", textoListar);

        return "lista";
    }

    /**
     * Pasa la lista de usuarios a la vista, con el nombre "usuarios".
     * @return la colección de usuarios
     */
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){

        // List<Usuario> usuarios = new ArrayList<>();
        // usuarios.add( new Usuario("Andrés","Montes Pinto","andres@correo.con"));
        // usuarios.add( new Usuario("Juana","Pérez Martín","juana@correo.con"));
        // usuarios.add( new Usuario("Luisa","López Lorenzo","luisa@correo.con"));

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Andrés", "Montes Pinto", "andres@correo.con"),
                new Usuario("Juana", "Pérez Martín", "juana@correo.con"),
                new Usuario("Luisa", "López Lorenzo", "luisa@correo.con"),
                new Usuario("Benito", "Hernandez Pancha", "benito@correo.con"));

                return usuarios;

    }

}
