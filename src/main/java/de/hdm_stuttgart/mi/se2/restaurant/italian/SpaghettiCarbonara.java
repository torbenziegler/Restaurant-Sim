package de.hdm_stuttgart.mi.se2.restaurant.italian;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;

/**
 * Creates dish Spaghetti Carbonara
 */
public class SpaghettiCarbonara implements IDish {

    String description = "Spaghetti Carbonara";
    int costs = 10;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {

        if (Inventory.ingredients.get("water") >= 150 && Inventory.ingredients.get("ham") >= 150 && Inventory.ingredients.get("eggs") >= 3 && Inventory.ingredients.get("cheese") >= 50
                && Inventory.ingredients.get("noodles") >= 200) {
            Inventory.ingredients.put("water", Inventory.ingredients.get("water") - 150);
            Inventory.ingredients.put("ham", Inventory.ingredients.get("ham") - 150);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 3);
            Inventory.ingredients.put("cheese", Inventory.ingredients.get("cheese") - 50);
            Inventory.ingredients.put("noodles", Inventory.ingredients.get("noodles") - 200);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
