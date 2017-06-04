package study.calc;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class Controller {

    @FXML
    private Text output;

    private String operator = "";
    private BigDecimal number1 = BigDecimal.valueOf(0);
    private MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);
    private Model model = new Model();

    private boolean acceptNewNumber = true;

    @FXML
    void processNumber(ActionEvent event) {
        if (acceptNewNumber) {
            output.setText("");
            acceptNewNumber = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if (!"=".equals(value)){
            operator = value;
            number1 = new BigDecimal(output.getText(), mathContext);
            acceptNewNumber = true;
        } else {
            if(operator.isEmpty()){
                return;
            }
            output.setText(model.calculate(number1, new BigDecimal(output.getText(), mathContext), operator).toString());
            acceptNewNumber = true;
        }
    }

    @FXML
    void clear(ActionEvent event){
        operator = "";
        output.setText("0");
        acceptNewNumber = true;
    }

    @FXML
    void clearEnd(ActionEvent event){
        output.setText("0");
        acceptNewNumber = true;
    }

    @FXML
    void backSpace(ActionEvent event){
        String currentText = output.getText();
        output.setText(currentText.substring(0, currentText.length()-1));
    }
}