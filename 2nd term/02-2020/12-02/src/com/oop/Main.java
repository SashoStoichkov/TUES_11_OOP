package com.oop;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
    public static String eval(String expr, Character operator){
        if (!expr.contains(operator.toString())){
            return expr;
        }

        int[] indexes = new int[expr.length()];
        int index = 0;

        for (int i = 0; i < expr.length(); i++){
            if (expr.charAt(i) == operator){
                indexes[index++] = i;
            }
        }

        for (int i = 0; i < index+1; i++){
            if (!expr.contains(operator.toString())){
                return expr;
            }

            String num1b = "";
            String num2 = "";
            StringBuilder num1 = new StringBuilder();

            for (int j = indexes[i]-1; ; j--) {
                if (j >= 0) {
                    Character ch = expr.charAt(j);

                    if (!ch.equals('+') && !ch.equals('-') && !ch.equals('*') && !ch.equals('/')) {
                        num1b += ch;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            num1.append(num1b);
            num1 = num1.reverse();

            for (int j = indexes[i]+1; ; j++){
                if (j < expr.length()) {
                    Character ch = expr.charAt(j);

                    if (!ch.equals('+') && !ch.equals('-') && !ch.equals('*') && !ch.equals('/')){
                        num2 += ch;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            String old_string;
            int ans;

            if (operator == '*') {
                ans = Integer.parseInt(String.valueOf(num1)) * Integer.parseInt(num2);
                old_string = num1.toString() + "*" + num2;
            } else if (operator == '/') {
                ans = Integer.parseInt(num1.toString()) / Integer.parseInt(num2);
                old_string = num1.toString() + "/" + num2;
            } else if (operator == '+') {
                ans = Integer.parseInt(num1.toString()) + Integer.parseInt(num2);
                old_string = num1.toString() + "+" + num2;
            } else {
                ans = Integer.parseInt(num1.toString()) - Integer.parseInt(num2);
                old_string = num1.toString() + "-" + num2;
            }

            expr = expr.replace(old_string, (""+ans));
            try {
                Integer.parseInt(expr);
                return expr;
            } catch (NumberFormatException e) {
                if (expr.contains(operator.toString())) {
                    expr = eval(expr, operator);
                } else {
                    return expr;
                }
            }
        }

        return expr;
    }

    public static void main(String[] args) /*throws ScriptException*/ {
        // js_eval(args);
        String expr = "";

        for (String arg : args) {
            expr += arg;
        }

        Character plus = '+';
        Character minus = '-';
        Character mul = '*';
        Character div = '/';

        System.out.print(expr + " = ");

        expr = eval(expr, '*');
        expr = eval(expr, '/');
        expr = eval(expr, '+');
        expr = eval(expr, '-');
        System.out.println(expr);
    }

    public static void js_eval(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        String expr = "";

        for (String arg : args) {
            expr += arg;
            System.out.print(arg + " ");
        }

        System.out.print(" = ");
        System.out.println(engine.eval(expr));
    }
}
