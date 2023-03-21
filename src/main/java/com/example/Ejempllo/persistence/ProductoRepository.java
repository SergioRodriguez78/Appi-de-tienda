package com.example.Ejempllo.persistence;

import com.example.Ejempllo.domain.Product;
import com.example.Ejempllo.domain.repository.ProductRepository;
import com.example.Ejempllo.persistence.crud.ProductoCrudRepository;
import com.example.Ejempllo.persistence.entity.Producto;
import com.example.Ejempllo.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository //Se indica que esta clase esta interactuando con la base de datos(se puede usar component pero es mejor este porque define que componente es)
public class ProductoRepository implements ProductRepository {
    @Autowired //De esta manera Spring se encargara de crear el objeto
    private ProductoCrudRepository productoCrudRepository;
    @Autowired//Los objetos o atributos deben ser un componente de Spring
    private ProductMapper productMapper;
@Override
    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
    return productMapper.toProduct(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
       List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProduct(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
    Optional<List<Producto>> productos= productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(productos1 -> productMapper.toProduct(productos1));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return  productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
    Producto producto= productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
    productoCrudRepository.deleteById(productId);
    }
}
