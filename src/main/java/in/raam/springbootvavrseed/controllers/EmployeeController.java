package in.raam.springbootvavrseed.controllers;

import in.raam.springbootvavrseed.models.Employee;
import in.raam.springbootvavrseed.services.EmployeeService;
import in.raam.springbootvavrseed.validations.EmployeeValidations;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static in.raam.springbootvavrseed.validations.DataValidator.applyValidations;

@RestController
public class EmployeeController extends BaseController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity getAllEmployees() {
		return employeeService.getAllEmployees()
				.toEither()
				.fold(this::failure, this::success);
	}

	@GetMapping("/employees/{employee_id}")
	public ResponseEntity getEmployeeById(@PathVariable("employee_id") Long employeeId) {
		return employeeService.getEmployeeById(employeeId)
				.toEither()
				.fold(this::failure, this::success);
	}

	@SuppressWarnings("unchecked")
	private Try<Employee> validateEmployee(Employee employee) {
		return applyValidations(employee,
				EmployeeValidations::validateName,
				EmployeeValidations::validateDesignation);
	}

	@PostMapping("/employees")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		return validateEmployee(employee)
				.flatMap(employeeService::createEmployee)
				.toEither()
				.fold(this::failure, this::success);
	}
}
