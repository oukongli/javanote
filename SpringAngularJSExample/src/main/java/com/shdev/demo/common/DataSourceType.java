package com.shdev.demo.common;

import org.apache.commons.lang.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public enum DataSourceType {
    @DataSourceAlias("oracle")
    ORACLE,

    @DataSourceAlias("mysql")
    MYSQL;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DataSourceAlias {
        String value();
    }

    private static Map<String, DataSourceType> map = getTypeMap();

    private static Map<String, DataSourceType> getTypeMap() {
        try {
            Map<String, DataSourceType> resultMap = new HashMap<String, DataSourceType>(DataSourceType.values().length);
            for (DataSourceType dataSourceType : DataSourceType.values()) {
                DataSourceAlias alias = DataSourceType.class.getField(dataSourceType.name()).getAnnotation(DataSourceAlias.class);
                resultMap.put(alias.value(), dataSourceType);
            }
            return resultMap;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Error found on getting dataSourceMap");
        }
    }

    public static final DataSourceType DEFAULT_DATA_SOURCE = ORACLE;

    public static DataSourceType typeOf(String alias) {
        if (StringUtils.isBlank(alias))
            return DEFAULT_DATA_SOURCE;
        DataSourceType type = map.get(alias.toLowerCase());
        return type == null ? DEFAULT_DATA_SOURCE : type;
    }
}
