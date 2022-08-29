package com.spring.springboot.spring_course_springboot.dao;

import com.spring.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        //hibernate impl
/*        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Employee", Employee.class).getResultList();*/

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmps = query.getResultList();

        return allEmps;

    }

    @Override
    public void saveEmployee(Employee employee) {

        //Hibernate impl
/*        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);*/

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }

    @Override
    public Employee getEmployee(int id) {

        //Hibernate impl
        /*Session session = entityManager.unwrap(Session.class);
         */
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        //Hibernate impl
/*        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee " + "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();*/

        Query query = entityManager.createQuery("delete from Employee " + "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();


    }

}
