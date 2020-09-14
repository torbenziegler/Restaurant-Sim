package de.hdm_stuttgart.mi.se2.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Stage for alert boxes (pop ups)
 */
public class AlertBox {


    /**
     * generates a dialog menu
     *
     * @param title   title of the stage
     * @param message message of the dialog
     */

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // Blocks all other windows until this one is getting care of
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        label.setPadding(new Insets(20, 20, 20, 20));
        Button closeButton = new Button("Okay");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        VBox.setMargin(closeButton, new Insets(0, 0, 20, 0));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Style.css");
        window.setScene(scene);
        window.showAndWait();


    }
}

