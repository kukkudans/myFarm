package com.farm.rest.dto.response;

public class BaseResponse {

	private boolean notFound = false;
	private boolean hasConflict = false;
	private boolean hasValidationErrors = false;
	private String message;

	public BaseResponse() {
		super();
	}

	public BaseResponse(String message) {
		super();
		this.message = message;
	}

	public boolean isNotFound() {
		return notFound;
	}

	public void setNotFound(boolean notFound) {
		this.notFound = notFound;
	}

	public boolean isHasConflict() {
		return hasConflict;
	}

	public void setHasConflict(boolean hasConflict) {
		this.hasConflict = hasConflict;
	}

	public boolean isHasValidationErrors() {
		return hasValidationErrors;
	}

	public void setHasValidationErrors(boolean hasValidationErrors) {
		this.hasValidationErrors = hasValidationErrors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean hasError() {
		return notFound || hasConflict || hasValidationErrors;
	}
}
