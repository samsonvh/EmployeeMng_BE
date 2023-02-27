package fpt.swp.dsct_server3.controller;

import fpt.swp.dsct_server3.constant.URLConstant;
import fpt.swp.dsct_server3.entity.Employee;
import fpt.swp.dsct_server3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(URLConstant.EMPLOYEE_FIND_ALL)
    public ResponseEntity<Iterable> findAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
