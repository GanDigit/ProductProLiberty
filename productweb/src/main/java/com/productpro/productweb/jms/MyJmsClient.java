package com.productpro.productweb.jms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyJmsClient", urlPatterns = {"/MyJmsClient"})
public class MyJmsClient extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> messageListSent = new ArrayList();
        List<String> messageListReceived = new ArrayList();

        
		try {
			MyJmsSender sender = new MyJmsSender();
	        
			final MyJmsReceiver receiver = new MyJmsReceiver();
	        receiver.startListener();

	        for (int i = 1; i <= 5; i++) {
	            String m = "My JMS Message " + i + " ---> " + new Date() ;
	            sender.sendMessage(m);
	            Thread.sleep(300);
	        }

	        messageListSent = sender.getMessageList();
	        messageListReceived = receiver.getMessageList();
	        
	        sender.destroy();
	        receiver.destroy();
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("messagesSent", messageListSent);
        request.setAttribute("messagesReceived", messageListReceived);
        

        request.getRequestDispatcher("jms.jsp").forward(request, response);
    }
    
	 public static void main (String[] args) throws Exception {
	    }
	
}
