package com.bridgelabz.employeepayrollspring.Service;


import com.bridgelabz.employeepayrollspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int employeeId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int employeeId,EmployeePayrollDTO employeePayrollDTO);

	void deleteEmployeePayrollData(int employeeId);
    List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);

}
