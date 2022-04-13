package com.sellingperfume.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sellingperfume.entity.UserEntity;

public interface IRepositories extends JpaRepository<UserEntity, Integer> {
  @Query(value = "SELECT * FROM user u WHERE u.username = :username", nativeQuery = true)
  UserEntity FindUserByUS(@Param("username") String username);

  @Query(value = "SELECT u.role FROM user u WHERE id = :id", nativeQuery = true)
  List<String> GetRoleName(@Param("id") int id);
}
