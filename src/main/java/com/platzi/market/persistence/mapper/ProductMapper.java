package com.platzi.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.dto.ProductDTO;
import com.platzi.market.persistence.entity.Product;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

  @Mappings({
      @Mapping(source = "idProduct", target = "productId"),
      @Mapping(source = "name", target = "name"),
      @Mapping(source = "idCategory", target = "categoryId"),
      @Mapping(source = "salePrice", target = "price"),
      @Mapping(source = "stockQuantity", target = "stock"),
      @Mapping(source = "state", target = "active"),
      @Mapping(source = "category", target = "category")
  })
  ProductDTO toProductDTO(Product product);
  List<ProductDTO> toProductsDTO(List<Product> products);

  @InheritInverseConfiguration
  @Mapping(target = "barcode", ignore = true)
  Product toProduct(ProductDTO productDTO);

}
