package fpt.swp.dsct_server3.service.impl;

import fpt.swp.dsct_server3.entity.Employee;
import fpt.swp.dsct_server3.repository.EmployeeRepository;
import fpt.swp.dsct_server3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            return null;
        }
        return employees;
    }

    @Override
    public List<Employee> findAllByDepartment(Long departmentId) {
        return null;
    }

    @Override
    public List<Employee> findAllByDepartmentAndJobPosition(Long departmentId) {
        return null;
    }

    @Override
    public Employee findById(Long employeeId) {
        return null;
    }
}
