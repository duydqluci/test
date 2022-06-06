package com.luci.nl.routing.employee.dao.repository;

import com.luci.nl.routing.employee.dao.orm.EmployeeORM;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeORM,Integer> {


}
