package com.sellingperfume.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeesEntity extends AbtractEntity {
  
  @Column(name = "employee_name")
  private String employeeName;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "adress")
  private String adress;

  @Column(name = "birthday")
  private Date birthdayDay;

  @Column(name = "username")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "salary")
  private int salary;

  @ManyToOne
  private DepartmentEntity department;
  
  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public Date getBirthdayDay() {
    return birthdayDay;
  }

  public void setBirthdayDay(Date birthdayDay) {
    this.birthdayDay = birthdayDay;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

}
