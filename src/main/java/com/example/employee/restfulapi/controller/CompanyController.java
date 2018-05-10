package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    //在此处完成Company API
    //1.获取company列表
    @GetMapping
    public List<Company> getCompanies(){
        return null;
    }
    //2.获取某个具体company
    @GetMapping(value="/{id}")
    public Company getCompanyById(int id){
        return null;
    }
    //3.获取某个具体company下所有employee列表
    @GetMapping(value="/{id}/employees")
    public List<Employee> getEmployeesByCompanyId(int id){
        return null;
    }
    //4.分页查询，page等于1，pageSize等于5
    @GetMapping(value="/page/1/pageSize/5")
    public List<Company> getCompaniesByPage(){
        return null;
    }
    //5.增加一个company
    @RequestMapping(value="",method= RequestMethod.POST)
    public String addCompany(Company company){
        return "success";
    }
    //6.更新某个company
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public String updateCompanyById(@PathVariable int id){
        return "success";
    }
    //7.删除某个company
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public String deleteCompanyById(@PathVariable int id){
        return "success";
    }
}
