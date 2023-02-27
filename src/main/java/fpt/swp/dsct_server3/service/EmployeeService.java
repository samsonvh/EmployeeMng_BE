package fpt.swp.dsct_server3.service;

import fpt.swp.dsct_server3.entity.Account;
import fpt.swp.dsct_server3.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    List<Employee> findAllByDepartment(Long departmentId);
    List<Employee> findAllByDepartmentAndJobPosition(Long departmentId);
    Employee findById(Long employeeId);
}
