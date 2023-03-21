package com.example.Ejempllo.persistence.crud;

import com.example.Ejempllo.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
//Se debe hacer que extienda de crudrepository, para poder realizar las funciones
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
//@Query(value="SELECT * FROM productos WHERE id_categoria=?", nativeQuery = true)//Si se llega a usar el query nativo, se puede llamar el metodo de cualqier forma
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);//Query method para devolver los productos de cierta categoria
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
