package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;

@Repository
public class ProductRepository {

  private ProductCrudRepository productCrudRepository;

  public List<Product> getAll() {
    return (List<Product>) productCrudRepository.findAll();
  }

  public List<Product> getByCategory(int categoryId) {
    return productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
  }

  public Optional<List<Product>> getScarseProducts(int quantity) {
    return productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
  }

  public Optional<Product> getProduct(int productId) {
    return productCrudRepository.findById(productId);
  }

  public Product save(Product product) {
    return productCrudRepository.save(product);
  }

  public void delete(int productId) {
    productCrudRepository.deleteById(productId);
  }

}
