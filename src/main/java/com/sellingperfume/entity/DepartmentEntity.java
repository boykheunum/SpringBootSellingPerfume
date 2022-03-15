package com.sellingperfume.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity extends AbtractEntity {
  @Column(name = "DepartmentName")
  private String departmentName;

  @OneToMany(mappedBy = "department")
  private List<EmployeesEntity> listEmployee = new ArrayList<EmployeesEntity>();

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public List<EmployeesEntity> getListEmployee() {
    return listEmployee;
  }

  public void setListEmployee(List<EmployeesEntity> listEmployee) {
    this.listEmployee = listEmployee;
  }


}
