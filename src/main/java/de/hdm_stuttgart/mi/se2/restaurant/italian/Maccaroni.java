package de.hdm_stuttgart.mi.se2.restaurant.italian;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;

/**
 * Creates dish Maccaroni
 */
public class Maccaroni implements IDish {

    String description = "Maccaroni";
    int costs = 7;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("water") >= 350 && Inventory.ingredients.get("noodles") >= 300 && Inventory.ingredients.get("tomatoes") >= 4 && Inventory.ingredients.get("cheese") >= 100) {
            Inventory.ingredients.put("water", Inventory.ingredients.get("water") - 350);
            Inventory.ingredients.put("noodles", Inventory.ingredients.get("noodles") - 300);
            Inventory.ingredients.put("tomatoes", Inventory.ingredients.get("tomatoes") - 4);
            Inventory.ingredients.put("cheese", Inventory.ingredients.get("cheese") - 100);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }


    }

}
// }
