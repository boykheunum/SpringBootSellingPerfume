package com.sellingperfume.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sellingperfume.entity.EmployeesEntity;
import com.sellingperfume.repositories.IEmployeeRepositories;
import com.sellingperfume.repositories.IRepositories;
import com.sellingperfume.services.IEmployeesService;

@Service
public class EmployServiceImplements implements IEmployeesService {
  @Autowired
  private IEmployeeRepositories employeeRepositories;

  @Override
  public List<EmployeesEntity> GetAllUser() {
    // TODO Auto-generated method stub
    List<EmployeesEntity> listEmployees = employeeRepositories.findAll();
    return listEmployees;
  }

  @Override
  public EmployeesEntity CreateEmployee(EmployeesEntity employeesEntity) {
    // TODO Auto-generated method stub
    return employeeRepositories.save(employeesEntity);
  }

}
