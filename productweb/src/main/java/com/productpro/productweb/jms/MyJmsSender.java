package com.productpro.productweb.jms;

import java.util.ArrayList;
import java.util.List;

import javax.jms.*;

public class MyJmsSender {

    private final MessageProducer producer;
    private final Session session;
    private final Connection con;

    private List<String> messageList = new ArrayList();
    
    public MyJmsSender () throws JMSException {
        ConnectionFactory factory = MyJmsProvider.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        this.session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("example.queue");
        this.producer = session.createProducer(queue);
    }

    public void sendMessage (String message) throws JMSException {
        TextMessage textMessage = session.createTextMessage(message);
        messageList.add(message);
        producer.send(textMessage);
    }
    public List<String> getMessageList () {
    	return messageList;
    }
    public void destroy () throws JMSException {
        con.close();
    }
}
