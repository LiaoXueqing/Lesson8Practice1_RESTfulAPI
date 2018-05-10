package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    //1.获取company列表
    List<Company> findAll();

    //2.获取某个具体company
    @Override
    Company getOne(Long aLong);

    //3.获取某个具体company下所有employee列表

    //4.分页查询，page等于1，pageSize等于5
    Page<Company> findAll(Pageable pageable);

    //5.增加一个company
    Company save(Company company);

    //6.更新某个company

    //7.删除某个company
    @Override
    void delete(Long aLong);
}
