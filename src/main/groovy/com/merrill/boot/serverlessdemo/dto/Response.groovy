package com.merrill.boot.serverlessdemo.dto

import com.fasterxml.jackson.annotation.JsonProperty

class Response {
	@JsonProperty("success")
	private boolean success

	@JsonProperty("message")
	private String message

	public Response(boolean success, String message) {
		this.success = success
		this.message = message
	}
}
