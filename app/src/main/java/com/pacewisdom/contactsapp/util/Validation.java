package com.pacewisdom.contactsapp.util;

public class Validation {

    public static boolean isBlank(String input) {
        return (input == null || input.trim().length() == 0);
    }

}
