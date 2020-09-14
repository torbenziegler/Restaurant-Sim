package de.hdm_stuttgart.mi.se2;

import de.hdm_stuttgart.mi.se2.GUI.LoginController;
import javafx.scene.control.ChoiceBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Methods of this class are used to help out in the navigation process through the GUI
 */
public class Navigation {

    private static Logger log = LogManager.getLogger(Navigation.class);

    /**
     * Guides the user through the login process. Checks if username and password matches the "data base".
     * According to the input, customers and managers can log in. Wrong input results in an error alert.
     *
     * @param usernameInput input of the TextField
     * @param passwordInput input of the PasswordField
     */
    public boolean loginProcess(String usernameInput, String passwordInput) {

        if (usernameInput.equals("customer") && passwordInput.equals("password")) {
            log.info("Customer logged in");
            return true;
        } else if (usernameInput.equals("manager") && passwordInput.equals("password")) {
            log.info("Manager logged in");
            LoginController.setManager(true);
            return true;
        } else {
            return false;
        }

    }


    /**
     * Checks input of the chosen restaurant in the LocationPicker class and sets up the ChoiceBox for
     * letting the user choose his desired restaurant location.
     *
     * @param chosenRestaurant input of the ChoiceBox for choosing a restaurant
     * @param locationChooser  targeted ChoiceBox which gets filled with corresponding items
     */
    public void fillLocationBox(String chosenRestaurant, ChoiceBox<String> locationChooser) {
        switch (chosenRestaurant) {
            case "German Restaurant":
                locationChooser.getItems().clear();
                locationChooser.getItems().addAll("Stuttgart Mitte", "Heilbronn Hbf", "Heidelberg Universität");
                break;
            case "French Restaurant":
                locationChooser.getItems().clear();
                locationChooser.getItems().addAll("Stuttgart Süd", "Stuttgart Mitte", "Stuttgart Universität");
                break;
            case "Italian Restaurant":
                locationChooser.getItems().clear();
                locationChooser.getItems().addAll("Stuttgart Vaihingen", "Karlsruhe Schloss", "Heidelberg Altstadt");
                break;
        }
        locationChooser.getSelectionModel().select(0);
    }

}