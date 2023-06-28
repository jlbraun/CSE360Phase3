package prototype.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdatePatientInfo {

    private VBox root;
    private Stage primaryStage;

    public UpdatePatientInfo(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	
    	
        // Create the buttons
        Button updateButtonPhone = new Button("Update Phone Number");
        Button updateButtonInsurance = new Button("Update Insurance Information");
        Button updateButtonPharmacy = new Button("Update Pharmacy Information");
        Button returnButton = new Button("Return to Patient Portal");

        // Add event handlers for the buttons
        returnButton.setOnAction(e -> {
            // Handle patient login button click
        	PatientPortal patientPortal = new PatientPortal(primaryStage);
            primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(updateButtonPhone, updateButtonInsurance, updateButtonPharmacy, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        //VBox.setMargin(updateButtonPhone, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
