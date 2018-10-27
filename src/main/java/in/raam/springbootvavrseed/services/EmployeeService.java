package in.raam.springbootvavrseed.services;

import in.raam.springbootvavrseed.models.Employee;
import in.raam.springbootvavrseed.repositories.EmployeeRepository;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static in.raam.springbootvavrseed.exceptions.Exceptions.notFound;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Try<List<Employee>> getAllEmployees() {
		return Try.of(employeeRepository::findAllEmployees);
	}

	public Try<Employee> getEmployeeById(Long employeeId) {
		return employeeRepository.findEmployeeById(employeeId)
				.map(Try::success)
				.orElse(notFound(String.format("Employee with id: %s not found!", employeeId)));
	}

	public Try<Employee> createEmployee(Employee employee) {
		return Try.success(employee)
				.map(employeeRepository::save);
	}
}
