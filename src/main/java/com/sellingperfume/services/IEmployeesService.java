package com.sellingperfume.services;

import java.util.List;
import com.sellingperfume.entity.EmployeesEntity;


public interface IEmployeesService  {
  public List<EmployeesEntity> GetAllUser();
  public EmployeesEntity CreateEmployee(EmployeesEntity employeesEntity);
}
