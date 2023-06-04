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