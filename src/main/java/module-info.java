module utng.gtid232.apm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens utng.gtid232.apm to javafx.fxml;
    exports utng.gtid232.apm;
}
