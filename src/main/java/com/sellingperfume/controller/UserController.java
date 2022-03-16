package com.sellingperfume.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.services.impl.UserServiceImplements;



@RestController
public class UserController {
  public UserEntity userEntity;
  @Autowired
  public UserServiceImplements userServiceImplements;

  @GetMapping(path = "home")
  public ModelAndView homePage(Model model) {
    ModelAndView mView = new ModelAndView("HomePage");
    return mView;
  }

  @GetMapping(name = "viewalluser")
  public ResponseEntity<List<UserEntity>> GetAllUser() {
    List<UserEntity> listUser = userServiceImplements.GetAllUser();
    return new ResponseEntity<List<UserEntity>>(listUser, HttpStatus.OK);
  }

  @PostMapping(name = "/dangky")
  public ResponseEntity<UserEntity> signup(@RequestBody UserEntity dataUser) {
    dataUser.toString();
    UserEntity users = userServiceImplements.CreateUser(dataUser);
    if (users != null) {
      return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }
    return new ResponseEntity<UserEntity>(users, HttpStatus.NOT_FOUND);
  }

  @PutMapping(name="UpdateUser")
  public ResponseEntity<UserEntity>UpdateUser(@RequestBody UserEntity dataUser, @RequestParam(value="id") int id){
    Optional<UserEntity> oUsers = userServiceImplements.findUserById(id);
    UserEntity users = oUsers.get();
    if(users != null && dataUser != null) {
      users.setAdress(dataUser.getAdress());
      users.setAvatar(dataUser.getAvatar());
      users.setBirthday(dataUser.getBirthday());
      users.setEmail(dataUser.getEmail());
      users.setName(dataUser.getName());
      users.setPassword(dataUser.getPassword());
      users.setPhone(dataUser.getPhone());
      users.setSex(dataUser.isSex());
      users.setUsername(dataUser.getUsername());
      userServiceImplements.CreateUser(users);
      return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }else {
      return new ResponseEntity<UserEntity>(users,HttpStatus.NOT_FOUND);
    }
  }
}
