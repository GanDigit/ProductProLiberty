package com.productpro.productweb.ejb;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MyEJBClient", urlPatterns = {"/MyEJBClient"})
public class MyEJBClient extends HttpServlet {
	
    @EJB
    private CalculatorSessionBean calculatorSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("add", calculatorSessionBean.add(10,20));
        request.setAttribute("sub", calculatorSessionBean.sub(20,5));
        
        request.getRequestDispatcher("ejb.jsp").forward(request, response);
    }

}