package com.example.Ejempllo.persistence.mapper;

import com.example.Ejempllo.domain.Product;
import com.example.Ejempllo.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})//Con uses ya sabae que transformara categoria en category
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock",target = "stock"),
            @Mapping(source = "estado",target = "active"),
            @Mapping(source = "categoria",target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProduct(List<Producto> productos);

    @InheritInverseConfiguration()
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
