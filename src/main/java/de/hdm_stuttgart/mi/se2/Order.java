package de.hdm_stuttgart.mi.se2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Manages the order process
 */
public class Order {

    public static int orderId = 1;
    public static ObservableList<String> currentOrder = FXCollections.observableArrayList();
    public static int orderPrice = 0;
    public ObservableList<String> currentOrderSorted = FXCollections.observableArrayList();

    /**
     * empties the current order to reset it
     */
    public void clearCurrentOrder() {
        currentOrder.clear();
    }

    /**
     * sorts the current order with amounts
     */
    public ObservableList<String> displayCurrentOrder() {

        Map<String, Long> result = currentOrder.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        currentOrderSorted = result.entrySet()
                .stream()
                .map(entry -> entry.getValue() + "x " + entry.getKey())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        return currentOrderSorted;

    }

    /**
     * adds item to current order
     * @param item item to be added to order
     */
    public void addToCurrentOrder(String item) {
        currentOrder.add(item);
    }


    /**
     * adds price to current order
     *
     * @param costs costs of item
     */
    public void addToOrderPrice(int costs) {
        orderPrice += costs;
    }


    /**
     * returns currentOrderSorted ObservableList
     */
    public ObservableList<String> getCurrentOrderSorted() {
        return currentOrderSorted;
    }

}
