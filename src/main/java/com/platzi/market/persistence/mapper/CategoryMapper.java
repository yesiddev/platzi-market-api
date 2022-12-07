package com.platzi.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.dto.CategoryDTO;
import com.platzi.market.persistence.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mappings({
      @Mapping(source = "idCategory", target = "categoryId"),
      @Mapping(source = "description", target = "category"),
      @Mapping(source = "state", target = "active")
  })
  CategoryDTO toCategoryDTO(Category category);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  Category toCategory(CategoryDTO categoryDTO);

}
