package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //1.获取employee列表
    List<Employee> findAll();

    //2.获取某个具体employee
    @Override
    Employee getOne(Long id);

    //3.分页查询，page等于1，pageSize等于5
    @Override
    Page<Employee> findAll(Pageable pageable);

    //4.筛选出所有男性Employee
//    @Query(value = "select * from Employee e where e.gender = male",nativeQuery = true)
//    String findEmployeeByGender(String gender);

    //5.增加一个employee
    @Override
    Employee save(Employee employee);

    // 6.更新某个employee
    @Modifying
    Employee updateEmployee(Employee employee);

    //7.删除某个employee
    @Override
    void delete(Long aLong);

}
