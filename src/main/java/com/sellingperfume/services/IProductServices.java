package com.sellingperfume.services;

import java.util.List;

import com.sellingperfume.entity.ProductEntity;

public interface IProductServices {
	public ProductEntity CreatePrduct(ProductEntity productEntity);

	public List<ProductEntity> FindAllProduct();
}
