package de.hdm_stuttgart.mi.se2;

import de.hdm_stuttgart.mi.se2.GUI.LoginController;
import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit tests for testing the navigation class
 */
public class NavigationTests {

    Navigation navTest = new Navigation();

    /**
     * Testing whether a customer can log in
     */
    @Test
    public void loginCustomer() {
        Assert.assertTrue(navTest.loginProcess("customer", "password"));
    }

    /**
     * Testing whether a manager can log in and its role assignment
     */
    @Test
    public void loginManager() {
        Assert.assertTrue(navTest.loginProcess("manager", "password"));
        Assert.assertTrue(LoginController.isIsManager());
    }


    /**
     * Testing whether a non customer would get the manager role
     */
    @Test
    public void notManager() {
        Assert.assertTrue(navTest.loginProcess("customer", "password"));
        Assert.assertFalse(LoginController.isIsManager());

    }


}
