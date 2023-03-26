package com.example.Ejempllo.web.controller;

import com.example.Ejempllo.domain.Product;
import com.example.Ejempllo.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products") //Recibe el path a donde se envian las peticiones
public class ProductController {
    @Autowired
    private ProductService productService;
@GetMapping("/all") //Se usa porque estamos obteniendo informacion
@ApiOperation("Get all supermarket products")
@ApiResponse(code=200 , message ="OK")
    public ResponseEntity<List<Product>> getAll(){

    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK); //Con la response entity hacemos una mejor respuesta
    //Del estatus de la peticion
    }
@GetMapping("/{id}") //Las llaves son porque necesitamos una id para la busqueda
@ApiOperation("Search a product with an Id")
@ApiResponses({
        @ApiResponse(code= 200, message = "OK"),
        @ApiResponse(code= 404, message = "Product not found")
})
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product",required = true,example = "7")
                                              @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        //Se mapea la respuesta en el caso que si, el response entity en el caso que no el http diciendo que no se encontro
    }
@GetMapping("/category/{categoryId}") //Se añade una diferenciacion debido a que generaria conflicto con el getproduct
    public ResponseEntity<List<Product>> getByCategory( @PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId).map(products -> new ResponseEntity<>(products, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save") //Colocamos request body debido que en el body es donde estara el request
    public ResponseEntity<Product> save(@RequestBody Product product){

    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
    if (productService.delete(productId)){
        return new ResponseEntity(HttpStatus.OK);
    } else{
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    }

}
