package com.sellingperfume.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class UserEntity extends AbtractEntity {

  @Column(name = "birthday", columnDefinition = "varchar(50)")
  private String birthday;

  @Column(name = "username", columnDefinition = "varchar(50)")
  private String username;

  @Column(name = "password", columnDefinition = "varchar(50)")
  private String password;

  @Column(name = "name", columnDefinition = "varchar(50)")
  private String name;

  @Column(name = "phone", columnDefinition = "varchar(50)")
  private String phone;

  @Column(name = "email", columnDefinition = "varchar(50)")
  private String email;

  @Column(name = "adress", columnDefinition = "varchar(50)")
  private String adress;

  @Column(name = "avatar", columnDefinition = "varchar(50)")
  private String avatar;

  @Column(name = "status_user", columnDefinition = "boolean default true ")
  private boolean status_user;

  @Column(name = "sex", columnDefinition = "boolean default true ")
  private boolean sex;
  
  @Column(name = "role", columnDefinition = "varchar(50) default USER")
  private String role;



  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
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

  public UserEntity() {
    super();
  }


}
