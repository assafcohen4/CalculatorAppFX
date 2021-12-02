module cohen.assaf.calculatorappfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens cohen.assaf.calculatorappfx to javafx.fxml;
    exports cohen.assaf.calculatorappfx;
}