package com.sellingperfume.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellingperfume.entity.ProductTypeEntity;
import com.sellingperfume.repositories.IProductTypeRepositories;
import com.sellingperfume.services.IProductTypeServices;

@Service
public class ProductTypeServiceImplements implements IProductTypeServices {
	@Autowired
	private IProductTypeRepositories iProductTypeRepositories;

	@Override
	public ProductTypeEntity CreateProductType(ProductTypeEntity productTypeEntity) {
		return iProductTypeRepositories.save(productTypeEntity);
	}

	@Override
	public List<ProductTypeEntity> ListFindAllTypeProduct() {
		// TODO Auto-generated method stub
		List<ProductTypeEntity>listTypeproduct = iProductTypeRepositories.findAll();
		return listTypeproduct;
	}

}
