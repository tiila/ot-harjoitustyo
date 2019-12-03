/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.ui;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

/**
 *
 * @author dell
 */
public class SettingsBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);

        Button deleteButton = new Button("Delete user account");
        Button cancelButton = new Button("Cancel");

        deleteButton.setOnAction(e -> {
            boolean result = ConfirmationBox.display("Delete user account", "Are you certain you want to delete your account? If you delete your account you will not be able to access your information later.");
            System.out.println(result); //tee jotain arvolla
        });

        cancelButton.setOnAction(e -> window.close());
        Button okButton = new Button("OK");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(deleteButton, cancelButton, okButton); // + Label?  //Label label = new Label() //label.setText(message);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
