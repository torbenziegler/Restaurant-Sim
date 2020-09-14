package de.hdm_stuttgart.mi.se2.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Starting point of the application
 */
public class Main extends Application {

    private static Logger log = LogManager.getLogger(Main.class);

    private static Stage stage = null;

    /**
     * Main method to start the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Sets start scene for the application
     */
    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        setScene("/LoginScreen.fxml", "Login Screen", 300, 150);
        log.info("Application started");
        stage.show();
    }

    /**
     * Method to set scenes
     *
     * @param fxml   path to fxml file
     * @param title  title of the new stage
     * @param width  width of new stage
     * @param height height of new stage
     */
    void setScene(String fxml, String title, Integer width, Integer height) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root, width, height);
            log.info("fxml " + fxml + " loaded");
            stage.setOnCloseRequest(e -> {
                log.info("Application closed");
                Platform.exit();
                System.exit(0);
            });
            stage.setScene(scene);
            stage.setTitle(title);
            stage.getIcons().add(new Image("restaurant.png"));
            stage.setResizable(false);
            stage.centerOnScreen();

        } catch (IOException e) {
            log.fatal(e + " Scene wasn't set because fxml file wasn't found");
        }
    }
}

