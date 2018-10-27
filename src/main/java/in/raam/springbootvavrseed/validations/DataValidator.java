package in.raam.springbootvavrseed.validations;

import in.raam.springbootvavrseed.exceptions.ValidationError;
import io.vavr.control.Try;
import io.vavr.control.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataValidator {
	public static <T> Try<T> applyValidations(T data, Function<T, Validation<String, T>> ... validations) {
		List<String> errors = Arrays.stream(validations)
				.map(validationFn -> validationFn.apply(data))
				.filter(Validation::isInvalid)
				.map(Validation::getError)
				.collect(Collectors.toList());
		return errors.isEmpty() ? Try.success(data) : Try.failure(new ValidationError(errors));
	}
}
