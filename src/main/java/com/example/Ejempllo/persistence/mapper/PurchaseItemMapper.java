package com.example.Ejempllo.persistence.mapper;

import com.example.Ejempllo.domain.PurchaseItem;
import com.example.Ejempllo.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
            //@Mapping(source = "total",target = "total"),  Ambos nombres son iguales asi que no hay necesidad de esta linea
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);

}
