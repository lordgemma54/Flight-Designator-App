module module2.module3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens module3 to javafx.fxml;
    exports module3;
}