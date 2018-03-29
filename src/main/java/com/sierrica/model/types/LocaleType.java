package com.sierrica.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LocaleType {

    en, es;

    /**
     * Returns a <tt>Genre<tt> enum based on string matching
     *
     * @param value string stored in database
     * @return a matching <tt>Genre</tt>
     */
    @JsonCreator
    public static LocaleType fromValue(String value) {
        return valueOf(value);
    }

    /**
     * Converts a <tt>Genre</tt> to matching type string
     *
     * @param genre service enum
     * @return matching type string
     */
    @JsonValue
    public static String toValue(LocaleType localeType) {
    	return localeType.name();
    }
}
