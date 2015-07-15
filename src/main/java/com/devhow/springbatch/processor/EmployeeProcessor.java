package com.devhow.springbatch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.devhow.springbatch.model.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	public Employee process(Employee item) throws Exception {
		// we skip all employees with last name starting with 't'
		if (item.getLast_name() != null && item.getLast_name().startsWith("t")) {
			return null;
		}
		return item;
	}

}
