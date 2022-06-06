package com.luci.nl.routing.employee.dao.impl;

import com.luci.nl.routing.employee.dao.orm.EmployeeORM;
import com.luci.nl.routing.employee.service.EmployeeDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext
    private EntityManager en;

    @Override
    public List<Integer> searchEmployee(String term) {
        CriteriaBuilder builder = en.getCriteriaBuilder();
        CriteriaQuery<EmployeeORM> query = builder.createQuery(EmployeeORM.class);
        Root<EmployeeORM> root = query.from(EmployeeORM.class);
        List<String> words = Arrays.asList(term.split(" "));
        List<Predicate> predicates = new ArrayList<>();
        for (String word :words) {
            Predicate employeeCode = builder.like(root.get("employeeCode").as(String.class), "%" + word + "%");
            Predicate firstName = builder.like(root.get("firstName").as(String.class), "%" + word + "%");
            Predicate lastName = builder.like(root.get("lastName").as(String.class), "%" + word + "%");
            Predicate middleName = builder.like(root.get("middleName").as(String.class), "%" + word + "%");
            Predicate email = builder.like(root.get("email").as(String.class), "%" + word + "%");
            Predicate phone = builder.like(root.get("phoneNumber").as(String.class), "%" + word + "%");
            predicates.add(builder.or(employeeCode, firstName, lastName, middleName, email, phone));
        }
        Predicate con = builder.and(predicates.toArray(new Predicate[0]));
        return en.createQuery(query.select(root).where(con)).getResultList().stream().map(EmployeeORM::getId).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeORM> getEmployeesByIds(List<Integer> ids) {
        return null;
    }
}
