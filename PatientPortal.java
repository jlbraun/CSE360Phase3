package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class PatientPortal {

    private GridPane root;
    private Stage primaryStage;
    private String username;

    public PatientPortal(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createPatientPortal();
    }

    private void createPatientPortal() {

        Label titleLabel = new Label("Patient Home");
        titleLabel.getStyleClass().add("patient-home");
 

        // Create the buttons
        Button messageButton = new Button("Message Portal");
        Button viewPatientButton = new Button("View Patient Information");
        Button updatePatientButton = new Button("Update Patient Information");
        messageButton.getStyleClass().add("dark-button");
        messageButton.getStyleClass().add("patient-button");
        messageButton.setPadding(new Insets(10, 10, 10, 10));
        viewPatientButton.getStyleClass().add("dark-button");
        viewPatientButton.getStyleClass().add("patient-button");
        viewPatientButton.setPadding(new Insets(10, 10, 10, 10));
        updatePatientButton.getStyleClass().add("dark-button");
        updatePatientButton.getStyleClass().add("patient-button");
        updatePatientButton.setPadding(new Insets(10, 10, 10, 10));

        messageButton.setOnAction(e -> {
        	MessagePortal messagePortal = new MessagePortal(primaryStage, username);
        	primaryStage.setScene(new Scene(messagePortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        viewPatientButton.setOnAction(e -> {
        	UpdatePatientInfo update = new UpdatePatientInfo(primaryStage, username);
        	primaryStage.setScene(new Scene(update.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        updatePatientButton.setOnAction(e -> {
        	UpdatePatientInfo update = new UpdatePatientInfo(primaryStage, username);
        	primaryStage.setScene(new Scene(update.getRoot(), 900, 600));
        	primaryStage.setResizable(false);
        	primaryStage.setFullScreen(false);
        });
        
        // Create an HBox for the buttons
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        buttonBox.getChildren().addAll(messageButton, viewPatientButton, updatePatientButton);
      

        // Create the home button
        Button homeButton = new Button("Home");
        homeButton.getStyleClass().add("dark-button");
        homeButton.setOnAction(e -> {
            // Handle home button click
            // Logic to navigate to home page
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
      
        Button logoutButton = new Button("Logout");
        logoutButton.getStyleClass().add("light-button");
        logoutButton.setStyle("-fx-pref-width: 120px;");
        logoutButton.setOnAction(e -> {
            // Handle home button click
            // Logic to navigate to home page
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox for the home button and sign-in content
        VBox topBox = new VBox(10);
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(50, 0, 0, 50));
        topBox.getChildren().addAll(homeButton);

        // Create a BorderPane to hold the logo, sign-in content, and home button
        root = new GridPane();
        root.setHgap(50);
        root.setVgap(100);
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        root.add(topBox, 0, 0);
        root.add(titleLabel, 1, 0);
        root.add(buttonBox, 1, 1);
        root.add(logoutButton, 2, 0);
        
        GridPane.setMargin(buttonBox, new Insets(0, 20, 0, 50));
        GridPane.setMargin(titleLabel, new Insets(20, 20, 0, 50));
        
        GridPane.setMargin(logoutButton, new Insets(30, 0, 0, 50));
    }

    public GridPane getRoot() {
        return root;
    }
}
