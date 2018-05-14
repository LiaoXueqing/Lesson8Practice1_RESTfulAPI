package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //1.获取employee列表
    @GetMapping("")
    public ResponseEntity getEmployees() throws Exception {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }
    //2.获取某个具体employee
    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(employeeRepository.findOne(id), HttpStatus.OK);
    }
    //3.分页查询，page等于1，pageSize等于5
    @GetMapping("page/{page}/pageSize/{pageSize}")
    public ResponseEntity getEmployeeByPage(@PathVariable int page, @PathVariable int pageSize) throws Exception {
        Pageable pageable = new PageRequest(page - 1, pageSize);
        return new ResponseEntity<>(employeeRepository.findAll(pageable), HttpStatus.OK);
    }

    //4.筛选出所有男性Employee
    @GetMapping("/male")
    public ResponseEntity getMaleEmployees() throws Exception{
        return new ResponseEntity<>(employeeRepository.findByGender("male"), HttpStatus.OK);
    }

    //5.增加一个employee
    @PostMapping("")
    public ResponseEntity addEmployee(@RequestBody Employee employee) throws Exception{
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //6.更新某个employee
    @PutMapping("/{id}")
    public ResponseEntity updateEmployeeById(@PathVariable Long id, @RequestBody Employee newEmployee) throws Exception{
        Employee employee = employeeRepository.findOne(id);
        employee.setAge(newEmployee.getAge());
        employee.setGender(newEmployee.getGender());
        employee.setName(newEmployee.getName());
        employee.setSalary(newEmployee.getSalary());
        employee.setCompanyId(newEmployee.getCompanyId());
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //7.删除某个employee
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable long id) throws Exception{
        employeeRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
