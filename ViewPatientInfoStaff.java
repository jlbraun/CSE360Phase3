package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPatientInfoStaff {

    private GridPane root;
    private Stage primaryStage;
    private String username;
    private TextArea messageTextArea;

    public ViewPatientInfoStaff(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	Label titleLabel = new Label("Message Portal");
        titleLabel.getStyleClass().add("patient-home");

        messageTextArea = new TextArea();
        messageTextArea.setEditable(false);
        messageTextArea.setPrefHeight(400);
        messageTextArea.setMinWidth(600);
   
        // Create GridPane layout
        GridPane messageBox = new GridPane();
        messageBox.setHgap(70); 
        messageBox.setVgap(30); 
        messageBox.setPadding(new Insets(10, 50, 0, 50));
        
        messageBox.add(messageTextArea, 1, 0); 

      
        // Create the home button
        Button homeButton = new Button("Home");
        homeButton.getStyleClass().add("dark-button");
        homeButton.setOnAction(e -> {
            // Handle home button click
            // Logic to navigate to home page
        	StaffPortal staffPortal = new StaffPortal(primaryStage, username);
            primaryStage.setScene(new Scene(staffPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        Path filePath = Path.of("C:\\Users\\jlbdv\\eclipse-workspace\\javafxtest\\src\\application\\PatientInfoFiles\\" + username +  "_patientInfo.txt");
        try {
        	String content = Files.readString(filePath);
        	messageTextArea.setText(content);
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}
       
        

        // Create a VBox for the home button and sign-in content
        VBox topBox = new VBox(10);
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(50, 0, 0, 50));
        topBox.getChildren().addAll(homeButton);

        // Create a BorderPane to hold the logo, sign-in content, and home button
        root = new GridPane();
        root.setHgap(50);
        root.setVgap(90);
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        root.add(topBox, 0, 0);
        root.add(titleLabel, 1, 0);
        root.add(messageBox, 0, 2);
        GridPane.setMargin(titleLabel, new Insets(20, 20, 0, 50));
        GridPane.setColumnSpan(messageBox, 2);
        GridPane.setMargin(messageBox, new Insets(-150, 0, 0, 0));
    	
        
    }
    
    public GridPane getRoot() {
        return root;
    }
}
