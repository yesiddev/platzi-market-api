package com.platzi.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.dto.ProductDTO;

public interface ProductRepositoryDTO {

  List<ProductDTO> getAll();

  Optional<List<ProductDTO>> getByCategory(int categoryId);

  Optional<List<ProductDTO>> getScarseProducts(int quantity);

  Optional<ProductDTO> getProduct(int productId);

  ProductDTO save(ProductDTO product);

  ProductDTO delete(int productId);
 
}
