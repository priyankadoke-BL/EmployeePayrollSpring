package com.bridgelabz.employeepayrollspring.Service;


import com.bridgelabz.employeepayrollspring.Exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollspring.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollspring.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
    private EmployeePayrollRepository employeePayrollRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
		return employeePayrollRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + employeeId
                        + " Doesn't Exists...!"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Employee Data: " + empData.toString());
        return employeePayrollRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
		empData.updateEmployeePayollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {
		 EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
	        employeePayrollRepository.delete(empData);
	}

	@Override
    public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}
