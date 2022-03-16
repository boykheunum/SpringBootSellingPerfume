package com.sellingperfume.services;

import java.util.List;
import com.sellingperfume.entity.UserEntity;

public interface IUserService {
  public List<UserEntity> GetAllUser();
  public UserEntity CreateUser(UserEntity user);
}
