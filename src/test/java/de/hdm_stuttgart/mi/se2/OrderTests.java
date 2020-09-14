package de.hdm_stuttgart.mi.se2;

import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit tests for testing the order process
 */
public class OrderTests {

    Order test = new Order();

    /**
     * Testing whether currentOrder is cleared when called
     */
    @Test
    public void clearOrderTest() {
        test.clearCurrentOrder();
        Assert.assertEquals(0, Order.currentOrder.size());
    }

    /**
     * Testing whether currentOrder is cleared when called
     */
    @Test
    public void clearOrderNegative() {
        test.clearCurrentOrder();
        Assert.assertNotEquals(1, Order.currentOrder.size());
    }

    /**
     * Testing the sorting of current order
     */
    @Test
    public void sortCurrentOrderTest() {
        test.clearCurrentOrder();
        Order.currentOrder.add("Apfel");
        Order.currentOrder.add("Apfel");
        Order.currentOrder.add("Kirsche");
        Order.currentOrder.add("Erdbeere");
        Order.currentOrder.add("Erdbeere");
        Order.currentOrder.add("Erdbeere");

        test.displayCurrentOrder();
        Assert.assertEquals("[2x Apfel, 3x Erdbeere, 1x Kirsche]", test.getCurrentOrderSorted().toString());
        Assert.assertNotEquals("[5x Apfel, 1x Erdbeere, 2x Kirsche]", test.getCurrentOrderSorted().toString());
    }

    /**
     * Testing whether items are added to current order
     */
    @Test
    public void addToOrderTest() {
        test.clearCurrentOrder();
        test.addToCurrentOrder("Apfel");

        Assert.assertEquals("[Apfel]", Order.currentOrder.toString());
    }

    /**
     * Testing whether costs of items are added to current order
     */
    @Test
    public void addToOrderPriceTest() {
        Assert.assertEquals(0, Order.orderPrice);
        test.addToOrderPrice(5);
        Assert.assertEquals(5, Order.orderPrice);
        Assert.assertNotEquals(0, Order.orderPrice);
        Assert.assertNotEquals(20000, Order.orderPrice);
        Assert.assertNotEquals(-5, Order.orderPrice);
    }


}
