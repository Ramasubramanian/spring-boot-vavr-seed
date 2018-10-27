package in.raam.springbootvavrseed.exceptions;

import io.vavr.control.Try;

public class Exceptions {
	public static ObjectNotFoundException notFoundException(String message) {
		return new ObjectNotFoundException(message);
	}

	public static <T> Try<T> notFound(String message) {
		return Try.failure(notFoundException(message));
	}
}
