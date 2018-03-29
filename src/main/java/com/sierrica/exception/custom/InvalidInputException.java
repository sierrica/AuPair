package com.sierrica.exception.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper=true)
@Getter @Setter
@SuppressWarnings("serial")
public final class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }
}