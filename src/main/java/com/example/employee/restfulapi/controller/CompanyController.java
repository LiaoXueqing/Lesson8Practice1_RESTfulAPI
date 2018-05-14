package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    //1.获取company列表
    @GetMapping("")
    public ResponseEntity  getCompanies() throws Exception{
        return new ResponseEntity(companyRepository.findAll(), HttpStatus.OK);
    }
    //2.获取某个具体company
    @GetMapping("/{id}")
    public ResponseEntity  getCompanyById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(companyRepository.findOne(id), HttpStatus.OK);
    }
    //3.获取某个具体company下所有employee列表
    @GetMapping("/{id}/employees")
    public ResponseEntity  getEmployeesByCompanyId(@PathVariable Long id) throws Exception{
        Company company = companyRepository.getOne(id);
        if(Objects.isNull(company)){
            return new ResponseEntity("company is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(company.getEmployees(),HttpStatus.OK);
    }
    //4.分页查询，page等于1，pageSize等于5
    @GetMapping("/page/{page}/pageSize/{pageSize}")
    public ResponseEntity  getCompaniesByPage(@PathVariable int page,@PathVariable int pageSize) throws Exception {
        Pageable pageable = new PageRequest(page - 1, pageSize);
        return new ResponseEntity<>(companyRepository.findAll(pageable), HttpStatus.OK);
    }
    //5.增加一个company
    @PostMapping("")
    public ResponseEntity  addCompany(@RequestBody Company company) throws Exception {
        companyRepository.save(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //6.更新某个company
    @PutMapping("/{id}")
    public ResponseEntity  updateCompanyById(@PathVariable Long id,@RequestBody Company newCompany) throws Exception{
        Company company = companyRepository.findOne(id);
        company.setCompanyName(newCompany.getCompanyName());
        company.setEmployeesNumber(newCompany.getEmployeesNumber());
        companyRepository.save(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //7.删除某个company
    @DeleteMapping("/{id}")
    public ResponseEntity  deleteCompanyById(@PathVariable Long id) throws Exception {
        companyRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
