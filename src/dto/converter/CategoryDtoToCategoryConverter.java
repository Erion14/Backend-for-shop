package dto.converter;

import dto.CategoryDto;

public class CategoryDtoToCategoryConverter {
	
	
	public CategoryDto convertCategoryNameToCategoryDtoWithOnlyName(String categoryName) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName(categoryName);
		return categoryDto;
	}

}
