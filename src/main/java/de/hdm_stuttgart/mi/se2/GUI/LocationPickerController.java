package de.hdm_stuttgart.mi.se2.GUI;

import de.hdm_stuttgart.mi.se2.Navigation;
import de.hdm_stuttgart.mi.se2.Restaurant;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Stage to pick the desired restaurant and its location
 */
public class LocationPickerController implements Initializable {

    private static Logger log = LogManager.getLogger(LocationPickerController.class);

    public ChoiceBox<String> restaurantChooser = new ChoiceBox<>();
    public ChoiceBox<String> locationChooser = new ChoiceBox<>();
    public Label logoutButton;

    String chosenRestaurant = "German Restaurant";
    String chosenLocation = "Stuttgart Mitte";

    /**
     * Method to initialize scene
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        restaurantChooser.getItems().addAll("German Restaurant", "French Restaurant", "Italian Restaurant");
        restaurantChooser.getSelectionModel().select(0);  // Shows by default German Restaurant
        locationChooser.getSelectionModel().select(0); // Shows by default first german location
    }

    /**
     * leads the user back to the login screen
     */
    public void logoutButtonClicked() {
        LoginController.setManager(false);
        Main switchScene = new Main();
        switchScene.setScene("/LoginScreen.fxml", "Login Screen", 300, 200);
    }


    /**
     * saves the input of the user and leads him to the next stage
     */
    public void submitButtonClicked() {
        Restaurant.setCuisine(chosenRestaurant);
        Restaurant.setLocation(locationChooser.getSelectionModel().getSelectedItem());

        log.info(chosenRestaurant + ", " + chosenLocation + " was chosen as location");

        Main newScene = new Main();

        String filePath = "/" + chosenRestaurant.substring(0, chosenRestaurant.indexOf(' ')) + "CustomerMenu.fxml";

        if (LoginController.isManager) {
            newScene.setScene("/InventoryManager.fxml", "Inventory Manager for " + Restaurant.cuisine + ", " + Restaurant.location, 600, 400);
        } else {
            newScene.setScene(filePath, "Menu of " + Restaurant.cuisine + ", " + Restaurant.location, 930, 500);
        }

    }

    /**
     * prepares the ChoiceBox to choose the restaurant location
     */
    public void setLocationChooser() {
        chosenRestaurant = restaurantChooser.getValue();
        Navigation navigation = new Navigation();
        navigation.fillLocationBox(chosenRestaurant, locationChooser);
    }

}
