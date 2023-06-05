<em># Ejercicios Spring</em>

PASAR LOS DATOS DEL CONTROLADOR A LA VISTA

* Usando la interfaz Model, inyectándola en el controlador a través del método index.
    * Model es un mapa de datos clave-valor (java.util.Map)
  * Para llamar a los datos, hay que hacer referencia al espacio de nombres de thymeleaf (motor de plantillas usado):
    * xmls:th="http://www.thymeleaf.org"
    * th es una referencia dada de forma arbitraria para ser usada, pero puede ser cualquiera.
    * Desde la plantilla se llama a la referencia del espacio de nombres y al atributo: <h1 th:text="&{titulo}"></h1>
    * El atributo sustituye al texto del elemento que contiene la referencia.

* Usando la interfaz ModelMap (java.util.LinkedHashMap).
  * Hereda igualmente de Map, por lo que apenas hay diferencias.

* Con ModelAndView
  * Además de llever un Map por debajo, se le puede asignar el nombre de la vista que tiene que cargar.
  
    public ModelAndView portafolio(ModelAndView mv) {
        mv.setViewName("portafolioPage");
        mv.addObject("titulo", "Portafolio");
        return mv;
    }

* Se puede usar directamente un objeto Map indicando los tipos de la pareja clave valor:
  
    public String miMetodo( Map<String,Object> map ){
        map.put( "clave", "valor" );
        ...
    }


MAPEAR EL CONTROLADOR CON REQUEST MAPPING
* Indica una ruta de primer nivel, obligatoria para acceder a la vista.


PASAR DATOS CON ModelAttribute
Se crea un método con el decorador @ModelAttribute(nombreDelAtributo) y este atributo estará listos en todos los métodos del controlador.

PASAR DATOS CON @RequestParam
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        ...
        return "params/ver";
    }

PASAR DATOS CON HttpServletRequest
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

PASAR DATOS EN EL PATH CON @PathVariable
public class EjemploVariablesPathController {

//    @GetMapping("/string/{texto}")
    @GetMapping("/string/{texto}/{numero}")
    // public String variables(@PathVariable(name=texto) String textoDiferente){
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: '" + texto + "' " + numero);

        return "variables/ver";
    }
}

    @GetMapping("/string/{texto}/{numero}")
    // public String variables(@PathVariable(name=texto) String textoDiferente){
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: '" + texto + "' (" + numero + ")");

        return "variables/ver";
    }