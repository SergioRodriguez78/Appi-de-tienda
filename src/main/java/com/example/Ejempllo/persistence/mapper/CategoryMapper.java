package com.example.Ejempllo.persistence.mapper;

import com.example.Ejempllo.domain.Category;
import com.example.Ejempllo.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel ="spring" )
public interface CategoryMapper {
    //De esta manera, se transportan los valores de una clase a otra en el dominio
@Mappings({//Se pone los nombres de los atributos, cada mapping se separa por comas
        @Mapping(source = "idCategoria",target = "categoryId"),
        @Mapping(source = "descripcion",target = "category"),
        @Mapping(source = "estado",target = "active")
})
    Category toCategory(Categoria categoria);
@InheritInverseConfiguration //Esta anotacion interpreta que es un mapeo inverso
@Mapping(target = "productos", ignore = true) //De esta manera hacemos que se ignore este atributo
Categoria toCategoria(Category category);
}
