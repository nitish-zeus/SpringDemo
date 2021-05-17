package com.nitish.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nitish.springboot.cruddemo.dao.EmployeeDAO;
import com.nitish.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
		
	}
	
	
	@Transactional
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Transactional
	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}
	@Transactional
	@Override
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}
	@Transactional
	@Override
	public void deleteById(int id) {
		employeeDAO.deleteById(id);

	}

}
