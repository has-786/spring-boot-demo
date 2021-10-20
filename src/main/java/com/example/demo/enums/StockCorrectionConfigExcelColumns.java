package com.example.demo.enums;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum StockCorrectionConfigExcelColumns {
    BUSINESS_UNIT("Business Unit"),
    BRAND("Brand"),
    COMMERCIAL_TYPE("Commercial Type"),
    SC("SC"),
    ADDITIONAL_SC("Additional SC");

    private String stockCorrectionConfigColumnName;

    StockCorrectionConfigExcelColumns(String columnName) {
        this.stockCorrectionConfigColumnName = columnName;
    }

    public String getColumnName() {
        return this.stockCorrectionConfigColumnName;
    }

    public static StockCorrectionConfigExcelColumns getEnum(String columnName) {
        if (Objects.nonNull(columnName) && !columnName.isEmpty()) {
            Optional<StockCorrectionConfigExcelColumns> ec = Arrays.asList(StockCorrectionConfigExcelColumns.values()).stream()
                    .filter(e -> e.stockCorrectionConfigColumnName.equalsIgnoreCase(columnName)).findFirst();

            if (ec.isPresent()) {
                return ec.get();
            }
        }
        throw new IllegalArgumentException(
                MessageFormat.format("Provided column name: {0} does not match any enum", columnName));
    }

}
