package com.sellingperfume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sellingperfume.entity.UserEntity;

public interface IRepositories extends JpaRepository<UserEntity, Integer> {
  @Query("SELECT u FROM user u WHERE u.username = :username")
  UserEntity FindUserByUS(@Param("name") String username);
}
