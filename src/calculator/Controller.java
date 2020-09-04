package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller<i, indexOperation> {
    @FXML
    public TextField textField;
    public TextField textFieldHidden;
    @FXML
    private TextArea textArea;
    static int i;
    static int o;
    static int indexOperation;
    static int result = 0;


    public void figure1(ActionEvent actionEvent) {
        textFieldHidden.appendText("1");
        textField.appendText("1");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void figure2(ActionEvent actionEvent) {
        textFieldHidden.appendText("2");
        textField.appendText("2");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void figure3(ActionEvent actionEvent) {
        textFieldHidden.appendText("3");
        textField.appendText("3");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void multiplication(ActionEvent actionEvent) {
        textField.appendText("*");
        indexOperation = 3;
        o = i;
        i=0;
        textFieldHidden.clear();
    }

    public void figure4(ActionEvent actionEvent) {
        textFieldHidden.appendText("4");
        textField.appendText("4");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void figure5(ActionEvent actionEvent) {
        textFieldHidden.appendText("5");
        textField.appendText("5");
        i = Integer.parseInt (textFieldHidden.getText());
    }


    public void figure6(ActionEvent actionEvent) {
        textFieldHidden.appendText("6");
        textField.appendText("6");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void division(ActionEvent actionEvent) {
        textField.appendText("/");
        indexOperation = 4;
        o = i;
        i=0;
        textFieldHidden.clear();
    }


    public void figure7(ActionEvent actionEvent) {
        textFieldHidden.appendText("7");
        textField.appendText("7");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void figure8(ActionEvent actionEvent) {
        textFieldHidden.appendText("8");
        textField.appendText("8");
        i = Integer.parseInt (textFieldHidden.getText());
    }


    public void figure9(ActionEvent actionEvent) {
        textFieldHidden.appendText("9");
        textField.appendText("9");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void subtraction(ActionEvent actionEvent) {
        textField.appendText("-");
        indexOperation = 2;
        o = i;
        i=0;
        textFieldHidden.clear();
    }

    public void figure0(ActionEvent actionEvent) {
        textFieldHidden.appendText("0");
        textField.appendText("0");
        i = Integer.parseInt (textFieldHidden.getText());
    }

    public void clear(ActionEvent actionEvent) {
        textField.clear();
        textFieldHidden.clear();
    }

    public void summation(ActionEvent actionEvent) {
        textField.appendText("+");
        indexOperation = 1;
        o = i;
        i=0;
        textFieldHidden.clear();
    }
    public int action(int x){
        if(x == 1){
            return result = o+i;
        } else if(x==2){
            return result = o-i;
        } else if (x==3){
            return result= o*i;
        } else {
            return result=o/i;
        }
    }
    public void result() {
        textField.clear();
        action(indexOperation);
        textFieldHidden.clear();
       i =  action(indexOperation);
        textField.appendText(result+"");
    }
}
