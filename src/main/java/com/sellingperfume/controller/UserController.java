package com.sellingperfume.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.sellingperfume.entity.UserEntity;

import com.sellingperfume.services.impl.UserServiceImplements;



@RestController
public class UserController {
  public UserEntity userEntity;
  @Autowired
  public UserServiceImplements userServiceImplements;
  
  @RequestMapping(path="/login", method = RequestMethod.GET)
  public ModelAndView Login(Model model) {
    ModelAndView mView = new ModelAndView("templates/Login");
    return mView;
  }
  @GetMapping(path = "home")
  public ModelAndView homePage(Model model) {
    ModelAndView mView = new ModelAndView("HomePage");
    return mView;
  }

  @GetMapping(path = "getalldatauser")
  public String GetAllDataUsers() {
    List<UserEntity> listUser = userServiceImplements.GetAllUser();
    return new Gson().toJson(listUser);
  }

  @GetMapping(path = "viewdangky")
  public ModelAndView ViewDangKy(Model model) {
    ModelAndView mView = new ModelAndView("/templates/ViewDangKy");
    UserEntity users = new UserEntity();
    model.addAttribute("users", users);
    return mView;
  }

  @PostMapping(path = "/dangky")
  public ResponseEntity<UserEntity> signup(@ModelAttribute("users") UserEntity dataUser, @RequestParam("avatarUser") MultipartFile multipartFile) {
    dataUser.setAvatar(multipartFile.getOriginalFilename());
    userServiceImplements.UploadFile("C:\\Users\\tiend\\eclipse-workspace\\SpringBootSellingPerfume\\src\\main\\resources\\uploadfile", multipartFile);
    UserEntity users = userServiceImplements.CreateUser(dataUser);
    if (users != null) {
      return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }
    return new ResponseEntity<UserEntity>(users, HttpStatus.NOT_FOUND);
  }

  @PutMapping(path = "UpdateUser")
  public ResponseEntity<UserEntity> UpdateUser(@RequestBody UserEntity dataUser,
      @RequestParam(value = "id") int id) {
    Optional<UserEntity> oUsers = userServiceImplements.findUserById(id);
    UserEntity users = oUsers.get();
    if (users != null && dataUser != null) {
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
    } else {
      return new ResponseEntity<UserEntity>(users, HttpStatus.NOT_FOUND);
    }
  }


}
