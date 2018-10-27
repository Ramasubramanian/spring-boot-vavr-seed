package in.raam.springbootvavrseed.controllers;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import in.raam.springbootvavrseed.exceptions.ObjectNotFoundException;
import in.raam.springbootvavrseed.exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public class BaseController {
	protected <T> ResponseEntity success(T data) {
		return ResponseEntity.ok(data);
	}

	private Map<String, Object> toErrorMap(Throwable error) {
		return ImmutableMap.of("errorId", UUID.randomUUID().toString(),
				"errorMessages", ImmutableList.of(error.getMessage()));
	}

	protected ResponseEntity failure(Throwable error) {
		if(error instanceof ObjectNotFoundException) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(toErrorMap(error));
		} else if(error instanceof ValidationError) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(ImmutableMap.of("errorId", UUID.randomUUID().toString(),
					"errorMesages", ((ValidationError)error).getMessages()));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(toErrorMap(error));
		}
	}
}
