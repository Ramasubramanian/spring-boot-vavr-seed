package in.raam.springbootvavrseed.repositories;

import com.google.common.collect.ImmutableList;
import in.raam.springbootvavrseed.models.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepository {

	private List<Employee> employees = new ArrayList<>();

	public EmployeeRepository() {
		Employee employee1 = new Employee();
		employee1.setDateOfJoining(new Date());
		employee1.setDesignation("DEVELOPER");
		employee1.setId(1L);
		employee1.setName("RAM");
		employee1.setSalary(0.0);
		Employee employee2 = new Employee();
		employee2.setDateOfJoining(new Date());
		employee2.setDesignation("MANAGER");
		employee2.setId(2L);
		employee2.setName("RAJ");
		employee2.setSalary(10.0);
		this.employees.add(employee1);
		this.employees.add(employee2);
	}

	public List<Employee> findAllEmployees() {
		return employees;
	}

	public Optional<Employee> findEmployeeById(Long employeeId) {
		return employees.stream()
				.filter(employee -> employeeId.equals(employee.getId()))
				.findFirst();
	}

	public Employee save(Employee employee) {
		long maxEmployeeId = employees.stream()
				.mapToLong(Employee::getId)
				.max().orElse(0L);
		employee.setId(maxEmployeeId + 1);
		employees.add(employee);
		return employee;
	}
}
