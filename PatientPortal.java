package prototype.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientPortal {

    private VBox root;
    private Stage primaryStage;
    private String username;

    public PatientPortal(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	
    	
        // Create the buttons
        Button messageButton = new Button("Message Portal");
        Button viewInfoButton = new Button("View Patient Information");
        Button updateInfoButton = new Button("Update Patient Information");
        Button exitButton = new Button("Exit");

        // Add event handlers for the buttons
        messageButton.setOnAction(e -> {
            // Handle staff login button click
            MessagePortal messagePortal = new MessagePortal(primaryStage, username);
            primaryStage.setScene(new Scene(messagePortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        //viewInfo will open text file in first iteration, bonus points for view only
        //viewInfoButton.setOnAction(e -> {
            // Handle patient login button click
        //    PatientLoginPage patientLoginPage = new PatientLoginPage(primaryStage);
        //    primaryStage.setScene(new Scene(patientLoginPage.getRoot(), 900, 600));
        //    primaryStage.setResizable(false);
        //    primaryStage.setFullScreen(false);
        //});
        
        updateInfoButton.setOnAction(e -> {
            // Handle patient login button click
            UpdatePatientInfo updatePatientInfo = new UpdatePatientInfo(primaryStage, username);
            primaryStage.setScene(new Scene(updatePatientInfo.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        exitButton.setOnAction(e -> {
            // Handle patient login button click
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(20));
        root.getChildren().addAll(messageButton, viewInfoButton, updateInfoButton, exitButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        //VBox.setMargin(viewInfoButton, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
