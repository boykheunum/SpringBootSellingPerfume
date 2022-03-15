package com.sellingperfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.service.IUserSevice;
import com.sellingperfume.service.impl.UserService;


@RestController
public class UserController {
  public UserEntity userEntity;
  @Autowired
  private UserService UserSevice;
  
  @GetMapping(name = "home")
  public ModelAndView homePage() {
    ModelAndView mView = new ModelAndView("HomePage");
    return mView;
  }
  
  @GetMapping(path = "viewdangky")
  public ModelAndView viewDangKy(Model model) {
    ModelAndView mView = new ModelAndView("ViewDangKy");
    
    model.addAttribute("userEntity", userEntity);
    return mView;
  }

  @PostMapping(name = "/dangky")
  public String signup(Model model) {
    
    return "";
  }
}
