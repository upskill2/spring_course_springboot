package com.spring.springboot.spring_course_springboot.controller;


import com.spring.springboot.spring_course_springboot.entity.Employee;
import com.spring.springboot.spring_course_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmps() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmp(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

/*        if (employee == null) {
            throw new EmployeeException("There is no emp with id: " + id + " in the DB");
        } else */
            return employee;
    }


    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable int id) {

/*        if(employeeService.getEmployee(id)==null){
            throw new EmployeeException("No such emp with Id=" + id + " in the DB");
        }*/

        employeeService.deleteEmployee(id);

        return "Emp with Id=" + id + " was deleted";

    }

}
