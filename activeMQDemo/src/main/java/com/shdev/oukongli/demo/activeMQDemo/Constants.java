package com.shdev.oukongli.demo.activeMQDemo;

import org.apache.activemq.ActiveMQConnection;

/**
 * Created by ou_ko on 2016/5/30.
 */
public class Constants {
    public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    public static final String BROKEURL = "failover://tcp://192.168.3.6:61616";//Active MQ Server
    public static final String QUEUENAME = "test";
}
