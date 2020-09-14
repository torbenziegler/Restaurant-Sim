package de.hdm_stuttgart.mi.se2.GUI;

import de.hdm_stuttgart.mi.se2.*;
import de.hdm_stuttgart.mi.se2.restaurant.french.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import de.hdm_stuttgart.mi.se2.restaurant.beverages.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Stage for french customer menu
 */
public class FrenchCustomerMenuController implements Initializable {

    private static Logger log = LogManager.getLogger(FrenchCustomerMenuController.class);

    public Button buttonClear;
    public Button buttonOrder;

    public ListView<String> listView;

    public MenuBar menuBar;
    public MenuItem menuSwitch;
    public MenuItem menuLogOut;

    public Button addCremeBruleeButton;
    public Button addFranzoesischerKartoffelsalatButton;
    public Button addLammlachseButton;
    public Button addZwiebelsuppeButton;
    public Button addFrenchToastButton;
    public Button addKraueterbaguetteButton;
    public Button addMadeleinesButton;
    public Button addWater;
    public Button addCola;
    public Button addFanta;
    public Button addSprite;
    public Button addTea;
    public Label orderPrice;

    private Sound music;

    /**
     * Method to initialize scene
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FileHandler loadFiles = new FileHandler();
        try {
            loadFiles.loadFile(Restaurant.cuisine, Restaurant.location, Inventory.ingredients);
            log.info("Restaurant info successfully imported");
        } catch (IOException e) {
            log.fatal(e + ": Inventory wasn't loaded");
        }
        orderPrice.setText("0€");
        listView.setItems(Order.currentOrder);

        this.music = new Sound("Musik/Taste Of Garrett.wav", "french");

    }


    /**
     * adds Crème brûlée to the order and deletes its ingredients from the inventory
     */
    public void addCremeBruleeClicked() {
        CremeBrulee cremeBrulee = new CremeBrulee();
        if (cremeBrulee.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }


    }


    /**
     * adds französischer Kartoffelsalat to the order and deletes its ingredients from the inventory
     */
    public void addFranzoesischerKartoffelsalatClicked() {
        FranzoesischerKartoffelSalat franzoesischerKartoffelSalat = new FranzoesischerKartoffelSalat();
        if (franzoesischerKartoffelSalat.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }


    /**
     * adds Lammlachse to the order and deletes its ingredients from the inventory
     */
    public void addLammlachseClicked() {
        Lammlachse lammlachse = new Lammlachse();
        if (lammlachse.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }

    /**
     * adds Zwiebelsuppe to the order and deletes its ingredients from the inventory
     */

    public void addZwiebelsuppeClicked() {
        Zwiebelsuppe zwiebelsuppe = new Zwiebelsuppe();
        if (zwiebelsuppe.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }

    /**
     * adds French Toast to the order and deletes its ingredients from the inventory
     */
    public void addFrenchToastClicked() {
        FrenchToast frenchToast = new FrenchToast();
        if (frenchToast.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }

    /**
     * adds Kräuterbaguette to the order and deletes its ingredients from the inventory
     */
    public void addKraeuterbaguetteClicked() {
        Kraeuterbaguette baguette = new Kraeuterbaguette();
        if (baguette.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }

    /**
     * adds Madeleines to the order and deletes its ingredients from the inventory
     */
    public void addMadeleinesClicked() {
        Madeleines madeleines = new Madeleines();
        if (madeleines.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }


    /**
     * adds water to the order and deletes its ingredients from the inventory
     */
    public void addWaterClicked() {
        Water water = new Water();
        if (water.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }


    /**
     * adds coca cola to the order and deletes its ingredients from the inventory
     */
    public void addColaClicked() {
        CocaCola cocaCola = new CocaCola();
        if (cocaCola.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }


    /**
     * adds fanta to the order and deletes its ingredients from the inventory
     */
    public void addFantaClicked() {
        Fanta fanta = new Fanta();
        if (fanta.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }


    /**
     * adds sprite to the order and deletes its ingredients from the inventory
     */
    public void addSpriteClicked() {
        Sprite sprite = new Sprite();
        if (sprite.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }


    /**
     * adds tea to the order and deletes its ingredients from the inventory
     */
    public void addTeaClicked() {
        Tea tea = new Tea();
        if (tea.removeFromInventory()) {
            Order show = new Order();
            listView.setItems(show.displayCurrentOrder());
            orderPrice.setText("" + Order.orderPrice + "€");
        } else {
            AlertBox.display("Not available", "Sorry, we don't have any ingredients left to make this dish!");
        }
    }

    /**
     * clears the draft of the order
     */
    public void buttonClearClicked() {
        Order order = new Order();
        order.clearCurrentOrder();
        listView.getItems().clear();
        Order.orderPrice = 0;
        orderPrice.setText("" + Order.orderPrice + "€");
    }


    /**
     * saves the order in log and assigns an order id to the user
     */
    public void buttonOrderClicked() {
        Order.orderId++;
        AlertBox.display("Ordered!", "Your ORDER ID is #" + Order.orderId);
        log.info(Restaurant.cuisine + ", " + Restaurant.location + " - New order #" + Order.orderId + ": " + listView.getItems().toString() + " for " + Order.orderPrice + "€");
        buttonClearClicked();
    }

    /**
     * leads the user back to the location picker
     */
    public void menuSwitchClicked() {
        buttonClearClicked();
        music.terminate();
        Main switchScene = new Main();
        switchScene.setScene("/LocationPicker.fxml", "Location Chooser", 500, 300);
    }


    /**
     * leads the user back to the login screen
     */
    public void menuLogOutClicked() {
        buttonClearClicked();
        music.terminate();
        Main switchScene = new Main();
        switchScene.setScene("/LoginScreen.fxml", "Login Screen", 300, 200);
    }


}

