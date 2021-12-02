package cohen.assaf.calculatorappfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import static java.lang.System.*;

public class CalcController {

    @FXML
    public Button buttonDel;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonDiv;

    @FXML
    private Button buttonEqual;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonMult;

    @FXML
    private Button buttonNegate;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonZero;

    @FXML
    private Button buttonClear;

    @FXML
    private Label calculationWindow;

    @FXML
    private GridPane grid;

    @FXML
    private Button buttonDecimal;


    private Model m = new Model();

    @FXML
    void click_arithm(ActionEvent event) {
        if(event.getSource() == buttonClear){
            m.clearCurrentNumber();
            m.clearCurrentCalculation();
            setDisplay("");
        }
        if(event.getSource() == buttonDel){
            m.delFromCurrentNumber();
            setDisplay(m.getCurrentNumber().toString());
        }
        if(event.getSource() == buttonPlus){
            m.arithmeticOperation("+");
            if(!(m.getCurrentNumber().toString().equals("") && m.getCurrentCalculation().isEmpty())) {
                setDisplay("+");
            }
        }
        if(event.getSource() == buttonMinus){
            m.arithmeticOperation("-");
            if(!(m.getCurrentNumber().toString().equals("") && m.getCurrentCalculation().isEmpty())) {
                setDisplay("-");
            }

        }
        if(event.getSource() == buttonMult){
            m.arithmeticOperation("*");
            if(!(m.getCurrentNumber().toString().equals("") && m.getCurrentCalculation().isEmpty())) {
                setDisplay("*");
            }
        }
        if(event.getSource() == buttonDiv){
            m.arithmeticOperation("/");
            if(!(m.getCurrentNumber().toString().equals("") && m.getCurrentCalculation().isEmpty())) {
                setDisplay("/");
            }
        }
        out.println("current calculation " + m.getCurrentCalculation());
        out.println("current number " + m.getCurrentNumber());
    }

    @FXML
    void click_equal(ActionEvent event) {
        m.evaluateCurrentCalculation();
        setDisplay( "Result: " + m.getCurrentNumber().toString());
        m.clearCurrentNumber();
        m.clearCurrentCalculation();


    }

    @FXML
    void click_negate_action(ActionEvent event) {
        m.negateCurrentNumber();
        setDisplay(m.getCurrentNumber().toString());
    }

    @FXML
    void click_number(ActionEvent event) {
        if(event.getSource() == buttonZero){
            m.appendToCurrentNumber("0");

        }
        if(event.getSource() == button0){
            m.appendToCurrentNumber("1");

        }
        if(event.getSource() == button1){
            m.appendToCurrentNumber("2");


        }
        if(event.getSource() == button2){
            m.appendToCurrentNumber("3");

        }
        if(event.getSource() == button4){
            m.appendToCurrentNumber("4");

        }
        if(event.getSource() == button5){
            m.appendToCurrentNumber("5");

        }
        if(event.getSource() == button6){
            m.appendToCurrentNumber("6");

        }
        if(event.getSource() == button7){
            m.appendToCurrentNumber("7");

        }
        if(event.getSource() == button8){
            m.appendToCurrentNumber("8");

        }
        if(event.getSource() == button9){
            m.appendToCurrentNumber("9");

        }
        out.println("current calculation " + m.getCurrentCalculation());
        out.println("current number " + m.getCurrentNumber());
        setDisplay(m.getCurrentNumber().toString());
    }

    @FXML
    void click_decimal(ActionEvent event) {
        if(!m.getCurrentNumber().toString().contains(".")) {
            m.appendToCurrentNumber(".");
            setDisplay(m.getCurrentNumber().toString());
        }
    }

    private void setDisplay(String s){
        calculationWindow.setText(s);
    }


}
