package in.raam.springbootvavrseed.validations;

import com.google.common.base.Strings;
import in.raam.springbootvavrseed.models.Employee;
import io.vavr.control.Validation;

import static io.vavr.control.Validation.invalid;
import static io.vavr.control.Validation.valid;

public class EmployeeValidations {
	public static Validation<String, Employee> validateName(Employee employee) {
		String name = employee.getName();
		if(Strings.isNullOrEmpty(name)) {
			return invalid("Invalid employee name");
		}
		if(name.length() < 5) {
			return invalid("Employee name should be minimum of 5 characters");
		}
		return valid(employee);
	}

	public static Validation<String, Employee> validateDesignation(Employee employee) {
		String designation = employee.getDesignation();
		if("MANAGER".equals(designation) || "DEVELOPER".equals(designation)) {
			return valid(employee);
		} else {
			return invalid(String.format("Designation value: %s is not supported, allowed values are ['DEVELOPER', 'MANAGER']", designation));
		}
	}
}
