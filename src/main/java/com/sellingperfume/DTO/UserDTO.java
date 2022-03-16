package com.sellingperfume.DTO;

import java.util.Date;


public class UserDTO extends AbtractDTO{
  private Date birthday;
  private String username;
  private String password;
  private String name;
  private String phone;
  private String email;
  private String adress;
  private String avatar;
  private boolean sex;
  private boolean status_user;
  private int luong;

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public boolean isSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public boolean isStatus_user() {
    return status_user;
  }

  public void setStatus_user(boolean status_user) {
    this.status_user = status_user;
  }

  public int getLuong() {
    return luong;
  }

  public void setLuong(int luong) {
    this.luong = luong;
  }

  public UserDTO() {
    super();
    // TODO Auto-generated constructor stub
  }

  public UserDTO(Date birthday, String username, String password, String name, String phone,
      String email, String adress, String avatar, boolean sex, boolean status_user, int luong) {
    super();
    this.birthday = birthday;
    this.username = username;
    this.password = password;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.adress = adress;
    this.avatar = avatar;
    this.sex = sex;
    this.status_user = status_user;
    this.luong = luong;
  }


}
