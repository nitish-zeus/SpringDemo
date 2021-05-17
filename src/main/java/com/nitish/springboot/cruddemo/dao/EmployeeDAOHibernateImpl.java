package com.nitish.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nitish.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		theEntityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);
		System.out.println("theQuery" + theQuery);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}



	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee theEmployee =  session.get(Employee.class, id);
		return theEmployee;
	}



	@Override
	public void save(Employee theEmployee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
