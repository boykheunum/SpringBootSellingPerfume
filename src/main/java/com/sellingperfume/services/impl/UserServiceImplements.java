package com.sellingperfume.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.repositories.IRepositories;
import com.sellingperfume.services.IUserService;

@Service
public class UserServiceImplements implements IUserService {
  @Autowired
  private IRepositories iRepositories;

  @Override
  public List<UserEntity> GetAllUser() {
    // TODO Auto-generated method stub
    List<UserEntity> listUser = iRepositories.findAll();
    return listUser;
  }

  @Override
  public UserEntity CreateUser(UserEntity user) {
    return iRepositories.save(user);
  }
}
