package com.sellingperfume.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends AbtractEntity {

  @Column(name = "birthday")
  private Date birthday;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "name")
  private String name;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;
  @Column(name = "adress")
  private String adress;
  @Column(name = "avatar")
  private String avatar;
  @Column(name = "sex")
  private boolean sex;
  @Column(name = "status_user")
  private boolean status_user;
  @Column(name = "luong")
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

  public int getLuong() {
    return luong;
  }

  public void setLuong(int luong) {
    this.luong = luong;
  }

  public String getPassWord() {
    return password;
  }

  public void setPassWord(String password) {
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
}
