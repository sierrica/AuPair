package com.sierrica.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ExceptionResponse {

	@JsonProperty(value="code", index=0, required=true)
	private int code;

	@JsonProperty(value="message", index=1, required=true)
    private String message;
}