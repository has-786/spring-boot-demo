package com.example.demo.enums;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum ExcelColumns {
    VENDOR_NAME("Vendor Name"),
    IS_RTV_BY_SALES_INVOICE("Is Rtv By Sales Invoice");

    private String columnName;

    ExcelColumns(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public static ExcelColumns getEnum(String columnName) {
        if (Objects.nonNull(columnName) && !columnName.isEmpty()) {
            Optional<ExcelColumns> ec = Arrays.asList(ExcelColumns.values()).stream()
                    .filter(e -> e.columnName.equalsIgnoreCase(columnName)).findFirst();

            if (ec.isPresent()) {
                return ec.get();
            }
        }
        throw new IllegalArgumentException(
                MessageFormat.format("Provided column name: {0} does not match any enum", columnName));
    }

}
