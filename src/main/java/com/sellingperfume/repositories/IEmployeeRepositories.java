package com.sellingperfume.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sellingperfume.entity.EmployeesEntity;

public interface IEmployeeRepositories extends JpaRepository<EmployeesEntity, Integer> {

}
