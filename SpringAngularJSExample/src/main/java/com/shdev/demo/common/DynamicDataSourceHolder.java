package com.shdev.demo.common;

public class DynamicDataSourceHolder {
    public static void setDataSourceType(DataSourceType dataSourceType) {
        Universe.current().setDataSourceType(dataSourceType);
    }

    public static DataSourceType getDataSourceType() {
        return Universe.current().getDataSourceType();
    }

    public static void clearDataSourceType() {
        Universe.current().setDataSourceType(null);
    }
}