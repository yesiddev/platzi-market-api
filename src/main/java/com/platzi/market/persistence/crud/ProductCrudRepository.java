package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

  List<Product> findByIdCategoryOrderByNameAsc(int idCategory);

  Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);

}
