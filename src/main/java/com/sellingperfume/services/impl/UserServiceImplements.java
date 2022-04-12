package com.sellingperfume.services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
    File avatarRootPathFile = new File(path);
    if (!avatarRootPathFile.exists()) {
      avatarRootPathFile.mkdir();
    }
    List<File> uploadedFiles = new ArrayList<File>();
    // ten file goc tai client
    String fileName = file.getOriginalFilename();
    // tao file tai server
    File fileSever = new File(avatarRootPathFile.getAbsoluteFile() + File.separator + fileName);
    try {
      BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileSever));
      stream.write(file.getBytes());
      stream.close();
      uploadedFiles.add(fileSever);
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

  @Override
  public UserDetails FindUserByUsername(String userName) {
    // TODO Auto-generated method stub
    UserEntity uEntity = iRepositories.FindUserByUS(userName);
   
    UserDetails userDetails = (UserDetails) new User(uEntity.getUsername(), uEntity.getPassword(), null);
    return userDetails;
  }

  @Override
  public List<String> RoleName(int userID) {
    // TODO Auto-generated method stub
    return null;
  }
}
