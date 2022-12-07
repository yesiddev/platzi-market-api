package com.platzi.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.domain.dto.ProductDTO;
import com.platzi.market.domain.repository.ProductRepositoryDTO;

@Service
public class ProductService implements ProductRepositoryDTO {

  @Autowired
  private ProductRepositoryDTO productRepositoryDTO;

  public List<ProductDTO> getAll() {
    return productRepositoryDTO.getAll();
  }

  public Optional<List<ProductDTO>> getByCategory(int categoryId) {
    return productRepositoryDTO.getByCategory(categoryId);
  }

  public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
    return productRepositoryDTO.getScarseProducts(quantity);
  }

  public Optional<ProductDTO> getProduct(int productId) {
    return productRepositoryDTO.getProduct(productId);
  }

  public ProductDTO save(ProductDTO product) {
    return productRepositoryDTO.save(product);
  }

  public boolean delete(int productId) {
    return getProduct(productId).map(product -> {
      productRepositoryDTO.delete(productId);
      return true;
    }).orElse(false);
  }

}
