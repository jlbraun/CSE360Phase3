package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessagePortalStaff {

    private GridPane root;
    private Stage primaryStage;
    private String username;
    private TextArea inputTextArea;
    private TextArea messageTextArea;

    public MessagePortalStaff(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	Label titleLabel = new Label("Message Portal");
        titleLabel.getStyleClass().add("patient-home");
        
        inputTextArea = new TextArea();
        inputTextArea.setPrefHeight(150);
        inputTextArea.setMinWidth(350);

        messageTextArea = new TextArea();
        messageTextArea.setEditable(false);
        messageTextArea.setPrefHeight(150);
        messageTextArea.setMinWidth(350);

        // Create send button
        Button sendButton = new Button("Send");
        sendButton.getStyleClass().add("dark-button");
        sendButton.setOnAction(event -> sendMessage());
        
        Label sendMessage = new Label("New Message");
        Button returnButton = new Button("Return to Patient Portal");
        returnButton.getStyleClass().add("dark-button");
        returnButton.setStyle("-fx-pref-width: 200;");
        
        returnButton.setOnAction(e -> {
            // Handle patient login button click
        	PatientPortal patientPortal = new PatientPortal(primaryStage, username);
            primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        // Create GridPane layout
        GridPane messageBox = new GridPane();
        messageBox.setHgap(70); 
        messageBox.setVgap(30); 
        messageBox.setPadding(new Insets(10, 50, 0, 50));
        
        messageBox.add(inputTextArea, 0, 0);
        messageBox.add(sendButton, 0, 1); 
        messageBox.add(returnButton, 0, 2);
        messageBox.add(messageTextArea, 1, 0); 
//        GridPane.setMargin(sendButton, new Insets(0, 0, 0, 350));
      
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
      //FIX WHERE IT SENDS YOU
        Button logoutButton = new Button("Logout");
        logoutButton.getStyleClass().add("light-button");
        logoutButton.setStyle("-fx-pref-width: 80px;");
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
        root.setVgap(90);
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        root.add(topBox, 0, 0);
        root.add(titleLabel, 1, 0);
        root.add(logoutButton, 2, 0);
        root.add(sendMessage, 0, 1);
        root.add(messageBox, 0, 2);
        GridPane.setMargin(titleLabel, new Insets(20, 20, 0, 50));
        GridPane.setMargin(logoutButton, new Insets(30, 60, 0, 50));
        GridPane.setColumnSpan(messageBox, 2);
        GridPane.setMargin(messageBox, new Insets(-150, 0, 0, 0));
        GridPane.setMargin(sendMessage, new Insets(-150, 0, 0, 50));
    	
        
    }

    private void sendMessage() {
        String message = inputTextArea.getText();
        if(!message.isEmpty())
        	messageTextArea.appendText(message + "\n");
        inputTextArea.clear();
    }
    
    public GridPane getRoot() {
        return root;
    }
}
