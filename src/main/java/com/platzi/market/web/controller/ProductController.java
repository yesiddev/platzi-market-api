package com.platzi.market.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.market.domain.dto.ProductDTO;
import com.platzi.market.domain.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  @ApiOperation("Get all supermarket products")
  public ResponseEntity<List<ProductDTO>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ApiOperation("Search a product with an ID")
  public ResponseEntity<ProductDTO> getProduct(
      @ApiParam(value = "The Product's Id", required = true, example = "7") @PathVariable("id") int productId) {
    return productService.getProduct(productId)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/category/{id}")
  @ApiOperation("Get products by category")
  public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") int categoryId) {
    return productService.getByCategory(categoryId)
        .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  @ApiOperation("Save a new product")
  public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product) {
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  @ApiOperation("Delete a product")
  public ResponseEntity<Boolean> delete(@PathVariable("id") int productId) {

    if (productService.delete(productId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
