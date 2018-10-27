package in.raam.springbootvavrseed.exceptions;

import com.google.common.base.Joiner;

import java.util.List;

public class ValidationError extends Error {
	private final List<String> errorMessages;

	public ValidationError(List<String> errorMessages) {
		super(Joiner.on(",").join(errorMessages));
		this.errorMessages = errorMessages;
	}

	public List<String> getMessages() {
		return errorMessages;
	}
}
