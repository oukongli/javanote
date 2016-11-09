package com.shdev.demo.common;


import org.apache.log4j.Logger;

public final class Universe {
    private static Logger logger = Logger.getLogger(Universe.class);

    private static ThreadLocal<Universe> current = new ThreadLocal<Universe>();
    private DataSourceType dataSourceType;

    private Universe() {
//        dataSourceType = DataSourceType.DEFAULT_DATA_SOURCE;
    }

    public static Universe current() {
        Universe universe = current.get();
        if (universe == null) {
            universe = new Universe();
            current.set(universe);
        }
        return universe;
    }

    public static void clear() {
        current.set(null);
    }

    public DataSourceType getDataSourceType() {
        logger.info("current dataSource:" + dataSourceType);
        return dataSourceType;
    }

    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }
}
