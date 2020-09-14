package de.hdm_stuttgart.mi.se2.restaurant.italian;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;

/**
 * Creates dish Pizza Schinken
 */
public class PizzaSchinken implements IDish {

    String description = "Pizza Schinken";
    int costs = 6;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {

        if (Inventory.ingredients.get("water") >= 250 && Inventory.ingredients.get("oil") >= 3 && Inventory.ingredients.get("flour") >= 500 && Inventory.ingredients.get("cheese") >= 100 && Inventory.ingredients.get("ham") >= 50) {
            Inventory.ingredients.put("water", Inventory.ingredients.get("water") - 250);
            Inventory.ingredients.put("oil", Inventory.ingredients.get("oil") - 3);
            Inventory.ingredients.put("flour", Inventory.ingredients.get("flour") - 500);
            Inventory.ingredients.put("cheese", Inventory.ingredients.get("cheese") - 100);
            Inventory.ingredients.put("ham", Inventory.ingredients.get("ham") - 50);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
