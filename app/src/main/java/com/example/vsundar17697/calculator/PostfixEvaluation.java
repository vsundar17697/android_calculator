package com.example.vsundar17697.calculator;

/**
 * Created by vsundar17697 on 02/01/18.
 */

import android.util.Log;

import java.util.Stack;

public class PostfixEvaluation
{
    final double pi = 3.14;

    public static String toDegree(String exp){
        return Double.toString(Double.parseDouble(exp) * Math.PI / 180.0);
    }

    public static String evaluate(String expression)
    {
//        try {
//            char[] tokens = expression.toCharArray();

//            System.out.println(tokens);
            expression = "( " + expression + " )";
            String[] split = expression.split("\\s+");


            // Stack for numbers: 'values'
            Stack<Double> values = new Stack<Double>();

            // Stack for Operators: 'ops'
            Stack<String> ops = new Stack<String>();

            for (int i = 0; i < split.length; i++) {
                // Current token is a whitespace, skip it
                if (split[i].equals(" "))
                    continue;

                // Current token is an opening brace, push it to 'ops'
                else if (split[i].equals("(")) {
                    ops.push(split[i]);
                    System.out.println("open para");
                }
                // Closing brace encountered, solve entire brace
                else if (split[i].equals(")")) {
                    while (!ops.peek().equals("("))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.pop();
                    System.out.println("close para");
                }

                // Current token is an operator.
                else if (split[i].equals("+") || split[i].equals("*")||
                        split[i].equals("-") || split[i].equals("/")) {
                    // While top of 'ops' has same or greater precedence to current
                    // token, which is an operator. Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && hasPrecedence(split[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                    // Push current token to 'ops'.
                    ops.push(split[i]);
                    System.out.println("operation");
                }

//                 Current token is a number, push it to stack for numbers
                else {

                    Double num = 0.0;
                    try{
                        num = Double.parseDouble(split[i]);
                    }

                    catch(Exception ex) {

                        if (split[i].contains("sin")) {
                            String eval = PostfixEvaluation.evaluate(split[i].substring(3));
                            eval = toDegree(eval);
                            num = (Math.sin(Double.parseDouble(eval)));
                        }

                        else if(split[i].contains("cos")){
                            String eval = PostfixEvaluation.evaluate(split[i].substring(3));
                            eval = toDegree(eval);
                            num = (Math.cos(Double.parseDouble(eval)));
                        }

                        else if(split[i].contains("tan")){
                            String eval = PostfixEvaluation.evaluate(split[i].substring(3));
                            eval = toDegree(eval);
                            num = (Math.tan(Double.parseDouble(eval)));
                        }

                        else if(split[i].contains("log")){
                            String eval = PostfixEvaluation.evaluate(split[i].substring(3));
                            eval = toDegree(eval);
                            num = (Math.log(Double.parseDouble(eval)));
                        }
                    }

                    System.out.println("number : " + split[i]);
                    values.push(num);
                }
            }

            // Entire expression has been parsed at this point, apply remaining
            // ops to remaining values

            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            // Top of 'values' contains result, return it
            return Double.toString(values.pop());
//        }
//        catch (Exception ex){
//                return "Parse Error";
//        }
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(String op1, String op2)
    {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-")))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static Double applyOp(String op, Double b, Double a)
    {
        switch (op)
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0.0;
    }


//    }


}