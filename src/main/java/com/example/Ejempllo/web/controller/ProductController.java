package com.example.Ejempllo.web.controller;

import com.example.Ejempllo.domain.Product;
import com.example.Ejempllo.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products") //Recibe el path a donde se envian las peticiones
public class ProductController {
    @Autowired
    private ProductService productService;
@GetMapping("/all") //Se usa porque estamos obteniendo informacion
    public List<Product> getAll(){
       return productService.getAll();
    }
@GetMapping("/{id}") //Las llaves son porque necesitamos una id para la busqueda
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }
@GetMapping("/category/{categoryId}") //Se añade una diferenciacion debido a que generaria conflicto con el getproduct
    public Optional<List<Product>> getByCategory( @PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }
    @PostMapping("/save") //Colocamos request body debido que en el body es donde estara el request
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
@DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }

}
