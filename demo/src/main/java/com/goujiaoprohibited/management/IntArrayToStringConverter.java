package com.goujiaoprohibited.management;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;

@Converter
public class IntArrayToStringConverter implements AttributeConverter<int[], String> {
    @Override
    public String convertToDatabaseColumn(int[] attribute) {
        return attribute != null ? Arrays.toString(attribute).replaceAll("[\\[\\]\\s]", "") : null;
    }

    @Override
    public int[] convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(dbData.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}