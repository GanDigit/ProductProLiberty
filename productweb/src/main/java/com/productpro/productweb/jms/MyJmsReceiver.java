package com.productpro.productweb.jms;

import java.util.List;
import java.util.ArrayList;

import javax.jms.*;

public class MyJmsReceiver implements MessageListener {

    private Connection con;

    private List<String> messageList = new ArrayList();
    
    public void startListener () throws JMSException {
        ConnectionFactory factory = MyJmsProvider.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("example.queue");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(this);
    }

    @Override
    public void onMessage (Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
            	messageList.add(tm.getText());
                System.out.println(tm.getText());
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> getMessageList () {
    	return messageList;
    }

    public void destroy () throws JMSException {
        con.close();
    }
}

    