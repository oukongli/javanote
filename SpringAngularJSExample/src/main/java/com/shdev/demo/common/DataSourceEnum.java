package com.shdev.demo.common;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum DataSourceEnum {
    ORACLE("oracle"),
    MYSQL("mysql");

    private String alias;

    DataSourceEnum(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public static Map<String, DataSourceEnum> getMap() {
        return map;
    }

    public static void setMap(Map<String, DataSourceEnum> map) {
        DataSourceEnum.map = map;
    }

    private static Map<String, DataSourceEnum> map = getTypeMap();

    private static Map<String, DataSourceEnum> getTypeMap() {
        Map<String, DataSourceEnum> map = new HashMap<String, DataSourceEnum>(DataSourceEnum.values().length);
        for (DataSourceEnum type : DataSourceEnum.values()) {
            map.put(type.getAlias(), type);
        }
        return map;
    }

    public static final DataSourceEnum DEFAULT_DATA_SOURCE = ORACLE;

    public static DataSourceEnum typeOf(String alias) {
        if (StringUtils.isEmpty(alias))
            return DEFAULT_DATA_SOURCE;
        DataSourceEnum value = map.get(alias.toLowerCase());
        return value != null ? value : DEFAULT_DATA_SOURCE;
    }
}
