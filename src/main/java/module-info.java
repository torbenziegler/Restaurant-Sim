module de.hdm_stuttgart.mi.se2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires java.desktop;

    opens de.hdm_stuttgart.mi.se2.GUI to javafx.fxml;
    opens de.hdm_stuttgart.mi.se2 to javafx.base;
    exports de.hdm_stuttgart.mi.se2.GUI;
}