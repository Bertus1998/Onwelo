package com.example.onwelo.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public boolean isBlankOrNull(String string) {
        return (string == null || string.isBlank());
    }
}
