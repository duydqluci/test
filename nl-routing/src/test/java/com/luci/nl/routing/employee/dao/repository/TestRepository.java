package com.luci.nl.routing.employee.dao.repository;

import com.luci.nl.routing.employee.ServiceConfig;
import com.luci.nl.routing.employee.dao.impl.EmployeeDaoImpl;
import com.luci.nl.routing.employee.dao.orm.EmployeeORM;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.util.*;

@DataJpaTest
@Rollback(value = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ServiceConfig.class)
public class TestRepository {
    @Autowired
    private EmployeeRepository employeeRepository;
@Autowired
private EmployeeDaoImpl employeeDao;
    @Test
    void testConnect() {
        Iterable<EmployeeORM> employees = employeeRepository.findAll();
        employees.forEach(e -> System.out.println(e));
    }

    @Test
    void search() {
        String list="duy huy";
        System.out.println(employeeDao.searchEmployee(list));
    }


}