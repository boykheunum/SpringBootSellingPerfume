package com.sellingperfume.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellingperfume.entity.ProductEntity;
import com.sellingperfume.repositories.IProductRepositories;
import com.sellingperfume.services.IProductServices;

@Service
public class ProductServiceImplements implements IProductServices {
	@Autowired
	private IProductRepositories iProductRepositories;

	@Override
	public ProductEntity CreatePrduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub

		return iProductRepositories.save(productEntity);
	}

	@Override
	public List<ProductEntity> FindAllProduct() {
		// TODO Auto-generated method stub
		List<ProductEntity> listProduct = iProductRepositories.findAll();
		return listProduct;
	}

}
