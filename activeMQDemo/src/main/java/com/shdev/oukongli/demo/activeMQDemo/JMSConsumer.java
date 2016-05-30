package com.shdev.oukongli.demo.activeMQDemo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by ou_ko on 2016/5/30.
 */
public class JMSConsumer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;
        connectionFactory = new ActiveMQConnectionFactory(Constants.USERNAME, Constants.PASSWORD, Constants.BROKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(Constants.QUEUENAME);
            messageConsumer = session.createConsumer(destination);
            while (true) {
                TextMessage message = (TextMessage) messageConsumer.receive(100000);
                if (message != null) {
                    System.out.println(message.getText());
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
