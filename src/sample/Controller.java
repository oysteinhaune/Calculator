package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private long number1 = 0;
    private long number2 = 0;
    private long storedValue = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();

    @FXML
    public void processNumbers(ActionEvent event) {

        if (start) {
            result.setText("");
            start = false;
        }
            String value = ((Button)event.getSource()).getText();
            result.setText(result.getText() + value);
    }

    @FXML
    public void processOperators(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if (start) {
            return;
        }

        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;

            number2 = Long.parseLong(result.getText());
            System.out.println();
            float output = model.Calculate(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }
    }

}
