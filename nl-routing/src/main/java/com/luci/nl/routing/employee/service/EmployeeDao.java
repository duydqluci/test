package com.luci.nl.routing.employee.service;

import com.luci.nl.routing.employee.dao.orm.EmployeeORM;

import java.util.List;

public interface EmployeeDao {
    List<Integer> searchEmployee(String term);
    List<EmployeeORM> getEmployeesByIds(List<Integer> ids);
}
