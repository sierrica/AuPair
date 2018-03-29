package com.sierrica.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusType {

    STAGED, ACTIVE;

    /**
     * Returns a <tt>Genre<tt> enum based on string matching
     *
     * @param value string stored in database
     * @return a matching <tt>Genre</tt>
     */
    @JsonCreator
    public static StatusType fromValue(String value) {
        return valueOf(value.toUpperCase());
    }

    /**
     * Converts a <tt>Genre</tt> to matching type string
     *
     * @param genre service enum
     * @return matching type string
     */
    @JsonValue
    public static String toValue(StatusType statusType) {
        //return statusType.name().toLowerCase();
    	return statusType.name();
    }
}
