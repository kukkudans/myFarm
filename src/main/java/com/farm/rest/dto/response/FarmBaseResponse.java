package com.farm.rest.dto.response;

public class FarmBaseResponse<T> extends BaseResponse {

	private T data;

	public FarmBaseResponse(T data, String message) {
		super(message);
		this.data = data;
	}

	public FarmBaseResponse(T data) {
		super();
		this.data = data;
	}

	public FarmBaseResponse(String message) {
		super(message);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
