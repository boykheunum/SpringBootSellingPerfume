package com.sellingperfume.services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.repositories.IRepositories;
import com.sellingperfume.services.IUploadFile;
import com.sellingperfume.services.IUserService;


@Service
public class UserServiceImplements implements IUserService, IUploadFile {
  @Autowired
  private IRepositories iRepositories;
  @Autowired
  private ServletContext applicationContext;

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

  @Override
  public UserEntity UpdateUser(UserEntity user) {
    // TODO Auto-generated method stub
    return iRepositories.save(user);
  }

  @Override
  public Optional<UserEntity> findUserById(int id) {
    // TODO Auto-generated method stub
    Optional<UserEntity> user = iRepositories.findById(id);
    
    return user;
  }

  @Override
  public int UploadFile(String path, MultipartFile file) {
    // TODO Auto-generated method stub
    path = applicationContext.getRealPath("UserAvatar");
    File avatarRootPathFile = new File(path);
    if (!avatarRootPathFile.exists()) {
      avatarRootPathFile.mkdir();
    }
    String fileName = file.getOriginalFilename();
    File fileSever = new File(avatarRootPathFile.getAbsoluteFile() + File.separator + fileName);
    try {
      BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileSever));
      stream.write(file.getBytes());
      stream.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return -1;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return -2;
    }
    return 1;
  }
}
