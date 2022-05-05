package com.sellingperfume.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base32;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.sellingperfume.entity.ProductEntity;
import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.services.impl.MediaServiceImplements;
import com.sellingperfume.services.impl.ProductServiceImplements;
import com.sellingperfume.services.impl.UserServiceImplements;

@RestController

public class UserController {

	public UserEntity userEntity;
	@Autowired
	public UserServiceImplements userServiceImplements;
	@Autowired
	public ProductServiceImplements productServiceImplements;
	@Autowired
	public MediaServiceImplements mediaServiceImplements;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Value("${upload.path}")
	private String uploadPath;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView Login(Model model) {
		ModelAndView mView = new ModelAndView("templates/Login");
		return mView;
	}

	@GetMapping(path = "home")
	public ModelAndView homePage(Model model) {
		List<ProductEntity> listProduct = productServiceImplements.FindAllProduct();
		model.addAttribute("listProduct", listProduct);
		ModelAndView mView = new ModelAndView("templates/HomePage");
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
	public ResponseEntity<UserEntity> signup(@ModelAttribute("users") UserEntity dataUser,
			@RequestParam("avatarUser") MultipartFile multipartFile) {
		Base32 convertToBase32 = new Base32();
		
		dataUser.setAvatar(multipartFile.getOriginalFilename());
		dataUser.setPassword(passwordEncoder().encode(dataUser.getPassword()));
		dataUser.setSerect_keyString(convertToBase32.encodeAsString(userServiceImplements.GenarateSerectKey().getBytes()).toString());
		mediaServiceImplements.UploadFile(uploadPath + "/user", multipartFile);
		mediaServiceImplements.GenarateQR(dataUser.getSerect_keyString(), dataUser.getUsername());
		mediaServiceImplements.sendEmail(dataUser.getEmail(), "SellingPerFume", dataUser.getSerect_keyString());
		UserEntity users = userServiceImplements.CreateUser(dataUser);
		if (users != null) {
			return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
		}
		return new ResponseEntity<UserEntity>(users, HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "UpdateUser")
	public ResponseEntity<UserEntity> UpdateUser(@RequestBody UserEntity dataUser, @RequestParam(value = "id") int id) {
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
