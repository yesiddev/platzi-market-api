package com.platzi.market.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.market.domain.dto.ProductDTO;
import com.platzi.market.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public List<ProductDTO> getAll() {
    return productService.getAll();
  }

  @GetMapping("/category/{id}")
  public Optional<List<ProductDTO>> getByCategory(@PathVariable("id") int categoryId) {
    return productService.getByCategory(categoryId);
  }

  @GetMapping("/scarse/{quantity}")
  public Optional<List<ProductDTO>> getScarseProducts(@PathVariable("quantity") int quantity) {
    return productService.getScarseProducts(quantity);
  }

  @GetMapping("/{id}")
  public Optional<ProductDTO> getProduct(@PathVariable("id") int productId) {
    return productService.getProduct(productId);
  }

  @PostMapping("/save")
  public ProductDTO save(ProductDTO product) {
    return productService.save(product);
  }

  @DeleteMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int productId) {
    return productService.delete(productId);
  }

}
