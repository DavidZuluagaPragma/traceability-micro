package com.pragma.trazabilidad.aplication.utils;

public class Utils {
    public static <T> T isNull(T object1, T object2) {
        if (object2 == null) {
            return object1;
        }
        return object2;
    }
}
