package net.robertorodriguez.propio.web.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * PropertiesSources indica la colección de archivos de propiedades que tenemos.
 * PropertySource enlaza con cada uno de los archivos en los que buscar las dependencias.
 * Los PropertySource van separados por comas.
 */
@Configuration
@PropertySources({
    @PropertySource("classPath:textos.properties")
})
public class TextosPropertiesConfig {
    
}
