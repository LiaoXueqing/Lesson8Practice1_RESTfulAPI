package com.example.employee.restfulapi.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;
    private Long companyId;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,
            CascadeType.REMOVE,CascadeType.ALL},optional = false,fetch = FetchType.LAZY)

    //设置在employee表中的关联字段(外键)
    @JoinColumn(name = "companyId")
    private Company company;

    public Employee() {
    }

    public Employee(String name, Integer age, String gender, Integer salary, Long companyId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }


    public String getGender() {
        return gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
