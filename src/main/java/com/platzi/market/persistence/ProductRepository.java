package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.dto.ProductDTO;
import com.platzi.market.domain.repository.ProductRepositoryDTO;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;

@Repository
public class ProductRepository implements ProductRepositoryDTO {

  @Autowired
  private ProductCrudRepository productCrudRepository;

  @Autowired
  private ProductMapper mapper;

  @Override
  public List<ProductDTO> getAll() {
    List<Product> products = (List<Product>) productCrudRepository.findAll();
    return mapper.toProductsDTO(products);
  }

  @Override
  public Optional<List<ProductDTO>> getByCategory(int categoryId) {
    List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
    return Optional.of(mapper.toProductsDTO(products));
  }

  @Override
  public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
    Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
    return products.map(prods -> mapper.toProductsDTO(prods));
  }

  @Override
  public Optional<ProductDTO> getProduct(int productId) {
    Optional<Product> product = productCrudRepository.findById(productId);
    return product.map(prod -> mapper.toProductDTO(prod));
  }

  @Override
  public ProductDTO save(ProductDTO productDTO) {
    Product product = mapper.toProduct(productDTO);
    return mapper.toProductDTO(productCrudRepository.save(product));
  }

  public void delete(int productId) {
    productCrudRepository.deleteById(productId);
  }

}
