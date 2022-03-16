package com.sellingperfume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sellingperfume.entity.UserEntity;

public interface IRepositories extends JpaRepository<UserEntity, Integer> {

}
