package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessagePortal {

    private VBox root;
    private Stage primaryStage;

    public MessagePortal(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	
    	
        // Create the buttons
        Button sendMessageButton = new Button("Send Message");
        Button returnButton = new Button("Return to Patient Portal");

        // Add event handlers for the buttons
        //sendMessageButton.setOnAction(e -> {
            // Handle staff login button click
        //    StaffLoginPage staffLoginPage = new StaffLoginPage(primaryStage);
        //    primaryStage.setScene(new Scene(staffLoginPage.getRoot(), 900, 600));
        //    primaryStage.setResizable(false);
        //    primaryStage.setFullScreen(false);
        //});
        
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
//        root.setPadding(new Insets(20));
        root.getChildren().addAll(sendMessageButton, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        //VBox.setMargin(viewInfoButton, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
