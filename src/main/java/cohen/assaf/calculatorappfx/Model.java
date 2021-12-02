package cohen.assaf.calculatorappfx;

import java.util.ArrayList;
import java.util.Locale;

public class Model {

    private  ArrayList<StringBuilder> currentCalculation = new ArrayList<>();
    private  StringBuilder currentNumber = new StringBuilder();

    //region getters & setters
    public ArrayList<StringBuilder> getCurrentCalculation() {
        return currentCalculation;
    }

    public void setCurrentCalculation(ArrayList<StringBuilder> currentCalculation) {
        this.currentCalculation = currentCalculation;
    }

    public StringBuilder getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(StringBuilder currentNumber) {
        this.currentNumber = currentNumber;
    }

    //endregion

    //region manipulate currentNumber
    public void negateCurrentNumber(){
        if(currentNumber.indexOf("-") == 0){
            currentNumber.deleteCharAt(0);
        }
        else{
            currentNumber.insert(0,"-");
        }

    }


    public void clearCurrentNumber(){
        currentNumber = new StringBuilder("");
    }
    public void clearCurrentCalculation(){
        currentCalculation.clear();
    }

    public void delFromCurrentNumber(){
        if(currentNumber.length() != 0) {
            currentNumber.deleteCharAt(currentNumber.length() - 1);
        }
    }

    public void appendToCurrentNumber(String s){
        currentNumber.append(s);
    }

    //endregion

    public void addToCurrentCalculation(StringBuilder s){
        currentCalculation.add(s);
    }

    public void arithmeticOperation(String s){
        if(!(currentNumber.toString().equals("") && isArithmeticOp(s.toString()) && currentCalculation.isEmpty())) {
            currentCalculation.add(currentNumber);
            currentNumber = new StringBuilder();
            currentCalculation.add(new StringBuilder(s));
            if (currentCalculation.get(currentCalculation.size() - 2).toString().equals("")) {
                currentCalculation.remove(currentCalculation.size() - 2);
                currentCalculation.remove(currentCalculation.size() - 2);
            }
        }
    }


    public void evaluateCurrentCalculation(){

        if(!(isArithmeticOp(currentCalculation.get(currentCalculation.size()-1).toString()) && currentNumber.toString().equals(""))){
            currentCalculation.add(currentNumber);
            Double currentExp = 0.0;
            while(currentCalculation.size() > 2) {
                Double firstExp = Double.parseDouble(currentCalculation.get(0).toString());

                String secondExp = currentCalculation.get(1).toString();

                Double thirdExp = Double.parseDouble(currentCalculation.get(2).toString());


                if (secondExp.equals("+")) {
                    currentExp = firstExp + thirdExp;
                }
                if (secondExp.equals("-")) {
                    currentExp = firstExp - thirdExp;
                }
                if (secondExp.equals("*")) {
                    currentExp = firstExp * thirdExp;
                }
                if (secondExp.equals("/")) {
                    currentExp = firstExp / thirdExp;
                }
                System.out.println(currentCalculation);
                currentCalculation.remove(0);
                currentCalculation.remove(0);
                currentCalculation.remove(0);
                currentCalculation.add(0, new StringBuilder(currentExp.toString()));
            }
            currentNumber = currentCalculation.get(0);
            currentCalculation.clear();
        }



    }


    private boolean isArithmeticOp(String s){
        return s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/");
    }

}

