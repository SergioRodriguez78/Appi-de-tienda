package com.example.Ejempllo.domain.service;

import com.example.Ejempllo.domain.Product;
import com.example.Ejempllo.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//Tambine se puede component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return  productRepository.getProduct(productId);
    }

   public Optional<List<Product>> getByCategory( int categoryId){
        return productRepository.getByCategory(categoryId);
   }

   public Product save(Product product){
        return productRepository.save(product);
   }

   public boolean delete(int productId){
        //Se evalua si entrega un producto, si es asi ejecuta el codigo de eliminar y retorna true, si no ira al else y manda false
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
   }

}
