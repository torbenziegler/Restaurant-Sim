package de.hdm_stuttgart.mi.se2.GUI;

import de.hdm_stuttgart.mi.se2.FileHandler;
import de.hdm_stuttgart.mi.se2.Ingredient;
import de.hdm_stuttgart.mi.se2.Restaurant;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

/**
 * Stage for inventory manager
 */
public class InventoryManagerController implements Initializable {

    private static final Logger log = LogManager.getLogger(InventoryManagerController.class);
    public MenuItem switchLocation;
    public MenuItem logOut;


    @FXML
    public TableView<Ingredient> tableView;
    @FXML
    public TableColumn<Ingredient, String> columnIngredient = new TableColumn<>();
    @FXML
    public TableColumn<Ingredient, Integer> columnAmount = new TableColumn<>();
    @FXML
    public TextField textFieldIngredient;
    @FXML
    public TextField textFieldAmount;
    @FXML
    public Button buttonAdd;
    @FXML
    public Button buttonDelete;

    /**
     * Method to initialize scene
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnIngredient.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        FileHandler load = new FileHandler();

        try {
            tableView.setItems(load.loadInventory(Restaurant.cuisine, Restaurant.location));
            log.info("Inventory was successfully loaded for " + Restaurant.cuisine + ", " + Restaurant.location);
        } catch (IOException e) {
            log.fatal(e + ": Inventory wasn't loaded");
        }


        tableView.setEditable(true);


    }


    /**
     * Adds a new ingredient to the inventory using user input
     */
    @FXML
    public void buttonAddClicked() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(textFieldIngredient.getText());
        ingredient.setAmount(Integer.parseInt(textFieldAmount.getText()));
        tableView.getItems().add(ingredient);
        log.info(ingredient + " added to inventory");
        textFieldIngredient.clear();
        textFieldAmount.clear();
    }


    /**
     * Deletes an selected item from the inventory
     */
    @FXML
    public void buttonDeleteClicked() {
        try {
            ObservableList<Ingredient> ingredientSelected, allIngredients;
            allIngredients = tableView.getItems();
            ingredientSelected = tableView.getSelectionModel().getSelectedItems();

            ingredientSelected.forEach(allIngredients::remove);
        } catch (NoSuchElementException e) {
            log.error(e + ": Inventory was emptied completely");
        }
    }

    /**
     * leads the user back to the location picker
     */
    public void switchLocationClicked() {
        Main switchScene = new Main();
        switchScene.setScene("/LocationPicker.fxml", "Location Chooser", 500, 300);


    }

    /**
     * leads the user back to the login screen
     */
    public void logOutClicked() {
        LoginController.setManager(false);
        Main switchScene = new Main();
        switchScene.setScene("/LoginScreen.fxml", "Login Screen", 300, 200);

    }

}
