package study.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Model {
    BigDecimal calculate(BigDecimal number1, BigDecimal number2, String operator){
        switch (operator){
            case "+":
                return number1.add(number2);
            case "-":
                return number1.subtract(number2);
            case "*":
                return number1.multiply(number2);
            case "/":
                if( number2.equals(BigDecimal.ZERO) ){
                    return BigDecimal.ZERO;
                }
                return number1.divide(number2, RoundingMode.HALF_UP);
        }
        System.out.println("Unknown operator - " + operator);
        return BigDecimal.ZERO;
    }
}
