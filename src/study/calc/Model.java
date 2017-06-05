package study.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

class Model {
    Optional<BigDecimal> lastValue = Optional.empty();
    Optional<BigDecimal> process(BigDecimal number, String operator){

    }
    private Optional<BigDecimal> calculate(Optional<BigDecimal> lvalue, BigDecimal rvalue, String operator){
        switch (operator){
            case "+":
                lastValue = lvalue.map(l -> l.add(rvalue));
                return lastValue
            case "-":
                lastValue = lvalue.map(l -> l.subtract(rvalue))
                return lastValue;
            case "*":
                lastValue = lvalue.map(l -> l.multiply(rvalue))
                return lastValue;
            case "/":
                if( rvalue.equals(BigDecimal.ZERO) ){
                    return Optional.empty();
                }
                return lvalue.map(l -> l.divide(rvalue, RoundingMode.HALF_UP));
            case "":
                return Optional.empty();
        }
        System.out.println("Unknown operator - " + operator);
        return Optional.of(BigDecimal.ZERO);
    }
}
