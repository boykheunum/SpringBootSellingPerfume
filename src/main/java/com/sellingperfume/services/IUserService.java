package com.sellingperfume.services;

import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import com.sellingperfume.entity.UserEntity;

public interface IUserService {
  public List<UserEntity> GetAllUser();

  public UserEntity CreateUser(UserEntity user);

  public UserEntity UpdateUser(UserEntity user);

  public Optional<UserEntity> findUserById(int id);
  
  public UserDetails FindUserByUsername(String userName);
  
  public List<String>RoleName(int userID);
}
