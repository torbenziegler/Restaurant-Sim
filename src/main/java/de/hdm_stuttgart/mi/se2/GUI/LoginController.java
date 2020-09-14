package de.hdm_stuttgart.mi.se2.GUI;

import de.hdm_stuttgart.mi.se2.Navigation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Stage for login process
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;


    static boolean isManager = false;


    /**
     * sets the role of the manager
     *
     * @param manager true if user is a manager, false if not
     */
    public static void setManager(boolean manager) {
        isManager = manager;
    }


    /**
     * Method to initialize scene
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    // Manager-Login: name: manager password: password
    // Customer-Login: name: customer password: password

    /**
     * checks the input of the login and leads the user to the next stage
     */
    @FXML
    private void loginButtonClicked() {
        Main switchScene = new Main();
        Navigation loginProcess = new Navigation();

        if (loginProcess.loginProcess(usernameInput.getText(), passwordInput.getText())) {
            switchScene.setScene("/LocationPicker.fxml", "Location Chooser", 500, 300);
        } else {
            AlertBox.display("Login failed", "Username and/or password wrong. Try again.");
        }
    }

    /**
     * returns whether the user is a manager
     */
    public static boolean isIsManager() {
        return isManager;
    }


}
