package com.sellingperfume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellingperfume.entity.ProductTypeEntity;

public interface IProductTypeRepositories extends JpaRepository<ProductTypeEntity, Integer>{

}
