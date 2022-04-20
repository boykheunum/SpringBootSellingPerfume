package com.sellingperfume.services;

import java.util.List;


import com.sellingperfume.entity.ProductTypeEntity;

public interface IProductTypeServices {
	public ProductTypeEntity CreateProductType(ProductTypeEntity productTypeEntity);
	public List<ProductTypeEntity> ListFindAllTypeProduct();
}
