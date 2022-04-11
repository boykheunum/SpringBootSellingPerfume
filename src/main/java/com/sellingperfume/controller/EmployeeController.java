package com.sellingperfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.sellingperfume.entity.EmployeesEntity;
import com.sellingperfume.services.impl.EmployServiceImplements;

@RestController
public class EmployeeController {
  @Autowired
  public EmployServiceImplements employServiceImplements;

  @GetMapping(path = "employees")
  public List<?> EmployeesChart() {
    List<EmployeesEntity> listEmployees = employServiceImplements.GetAllUser();
    return listEmployees;
  }
  @GetMapping(path = "chart")
  public ModelAndView charts(Model model) {
    ModelAndView mView = new ModelAndView("templates/chart");
    List<EmployeesEntity> listEmployees = employServiceImplements.GetAllUser();
    model.addAttribute("listEmployees", listEmployees);
    return mView;
  }
}
