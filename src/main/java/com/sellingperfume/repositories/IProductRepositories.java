package com.sellingperfume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellingperfume.entity.ProductEntity;

public interface IProductRepositories extends JpaRepository<ProductEntity, Integer> {

}
