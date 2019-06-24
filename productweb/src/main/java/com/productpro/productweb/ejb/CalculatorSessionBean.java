package com.productpro.productweb.ejb;

import javax.ejb.Stateless;

@Stateless
public class CalculatorSessionBean {

    public int add(int operand1, int operand2) {
      return operand1 + operand2;
    }

    public int sub(int operand1, int operand2) {
      return operand1 - operand2;
    }
}
