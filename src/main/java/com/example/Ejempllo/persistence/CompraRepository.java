package com.example.Ejempllo.persistence;

import com.example.Ejempllo.domain.Purchase;
import com.example.Ejempllo.domain.repository.PurchaseRepository;
import com.example.Ejempllo.persistence.crud.CompraCrudRepository;
import com.example.Ejempllo.persistence.entity.Compra;
import com.example.Ejempllo.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return    mapper.toPurchases((List<Compra>) compraCrudRepository.findAll()) ;
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        //Como no hay uno definido, hacemos query method en crud repository
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));

    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra) );

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
