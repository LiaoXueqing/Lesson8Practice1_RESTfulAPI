package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //在此处完成Employee API
    //1.获取employee列表
    @GetMapping
    public List<Employee> getEmployees(){
        return null;
    }
    //2.获取某个具体employee
    @GetMapping(value="/{id}")
    public Employee getEmployeeById(int id){
        return null;
    }
    //3.分页查询，page等于1，pageSize等于5
    @GetMapping(value="page/1/pageSize/5")
    public List<Employee> getEmployeeByPage(){
        return null;
    }

    //4.筛选出所有男性Employee
    @GetMapping(value="/male")
    public List<Employee> getMaleEmployees(){
        return null;
    }

    //5.增加一个employee
    @RequestMapping(value="",method= RequestMethod.POST)
    public String addEmployee(Employee employee){
        return "success";
    }
    //6.更新某个employee
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public String updateEmployeeById(@PathVariable int id){
        return "success";
    }
    //7.删除某个employee
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public String deleteEmployeeById(@PathVariable int id){
        return "success";
    }
}
