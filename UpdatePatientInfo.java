package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdatePatientInfo {
	
    private String username;
    private GridPane root;
    private Stage primaryStage;
    private TextArea contactTextArea;
    private TextField phoneNumberField;
    private TextArea insuranceField;
    private TextArea pharmacyField;
    private String phoneNumber = "";
    private String insuranceInfo = "";
    private String pharmacyInfo = "";

    public UpdatePatientInfo(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createPatientPortal();
    }

    private void createPatientPortal() {
     
        
        Label titleLabel = new Label("Update Patient\n   Information");
        titleLabel.getStyleClass().add("patient-home");
        titleLabel.setStyle("-fx-font-size: 50px");
        titleLabel.setWrapText(true);
        
        Label contactInfoLabel = new Label("Contact Information");
        contactInfoLabel.getStyleClass().add("contact");
        GridPane contact = new GridPane();
        contact.setVgap(0);
        contactTextArea = new TextArea();
        contactTextArea.setPrefColumnCount(20);
        contactTextArea.setPrefRowCount(5);
        contactTextArea.setEditable(false);
        contactTextArea.setMinHeight(200);
        contactTextArea.setWrapText(true);
        contactTextArea.getStyleClass().add("contact-area");
        contact.add(contactInfoLabel, 0, 0);
        contact.add(contactTextArea, 0, 1);

        Label updatePhone = new Label("Change Phone Number:");
        Label updateInsurance = new Label("Update Insurance Information:"); 
        Label updatePharmacy = new Label("Update Pharmacy Information:"); 
        
        // Create TextFields for phone number, insurance, and pharmacy
        phoneNumberField = new TextField();
        phoneNumberField.setPrefWidth(300);
        insuranceField = new TextArea();
        insuranceField.setPrefWidth(300);
        insuranceField.setPrefHeight(100);
        pharmacyField = new TextArea();
        pharmacyField.setPrefWidth(300);
        pharmacyField.setPrefHeight(100);

        // Create update buttons
        Button phoneNumberUpdateButton = new Button("Update");
        phoneNumberUpdateButton.getStyleClass().add("light-button");
        Button insuranceUpdateButton = new Button("Update");
        insuranceUpdateButton.getStyleClass().add("light-button");
        Button pharmacyUpdateButton = new Button("Update");
        pharmacyUpdateButton.getStyleClass().add("light-button");

        // Set action listeners for update buttons
        phoneNumberUpdateButton.setOnAction(event -> updatePhoneNumber());
        insuranceUpdateButton.setOnAction(event -> updateInsurance());
        pharmacyUpdateButton.setOnAction(event -> updatePharmacy());

        GridPane rightPane = new GridPane();
        rightPane.setHgap(10);
        rightPane.setVgap(5);
        
        rightPane.add(updatePhone, 0, 0);
        rightPane.add(phoneNumberField, 0, 1);
        rightPane.add(phoneNumberUpdateButton, 2, 1);
        
        rightPane.add(updateInsurance, 0, 2);
        rightPane.add(insuranceField, 0, 3);
        rightPane.add(insuranceUpdateButton, 2, 3);
        
        rightPane.add(updatePharmacy, 0, 4);
        rightPane.add(pharmacyField, 0, 5);
        rightPane.add(pharmacyUpdateButton, 2, 5);
        rightPane.setMinWidth(300);
        
        
        
        // Create GridPane
        GridPane mainPane = new GridPane();
        mainPane.setHgap(150);
        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(10, 0, 0, 50));
        mainPane.add(contact, 0, 0, 1, 3); 
        mainPane.add(rightPane, 1, 0);

      
        // Create the home button
        Button homeButton = new Button("Home");
        homeButton.getStyleClass().add("dark-button");
        homeButton.setOnAction(e -> {
            // Handle home button click
            // Logic to navigate to home page
        	PatientPortal patientPortal = new PatientPortal(primaryStage, username);
            primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
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
        root.setVgap(30);
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        root.add(topBox, 0, 0);
        root.add(titleLabel, 1, 0);
        root.add(mainPane, 0, 1);
        GridPane.setColumnSpan(mainPane, 2);
        GridPane.setMargin(titleLabel, new Insets(20, 20, 0, 60));

        setContactInformation();

    }
    
    private void updatePhoneNumber() {
        phoneNumber = phoneNumberField.getText();
        setContactInformation();
        
        File file;
        PatientFiles patientFiles = new PatientFiles();
        try  { file = patientFiles.createPatientInfoFile(username);
        }
        catch (IOException ex) { throw new RuntimeException(ex); }

        if (file != null) {
            try {  
            	
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write('\n' + "Phone number Updated: " + phoneNumber);
                fileWriter.flush();
                fileWriter.close();

            }
            catch (IOException ex) { throw new RuntimeException(ex); }
        }
        
    }

    private void updateInsurance() {
        insuranceInfo = insuranceField.getText();
        setContactInformation();
        
        File file;
        PatientFiles patientFiles = new PatientFiles();
        try  { file = patientFiles.createPatientInfoFile(username);
        }
        catch (IOException ex) { throw new RuntimeException(ex); }

        if (file != null) {
            try {  
            	
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write('\n' + "Insurance Information Updated: " + insuranceInfo);
                fileWriter.flush();
                fileWriter.close();

            }
            catch (IOException ex) { throw new RuntimeException(ex); }
        }
    }

    private void updatePharmacy() {
        pharmacyInfo = pharmacyField.getText();
        setContactInformation();
        
        File file;
        PatientFiles patientFiles = new PatientFiles();
        try  { file = patientFiles.createPatientInfoFile(username);
        }
        catch (IOException ex) { throw new RuntimeException(ex); }

        if (file != null) {
            try {  
            	
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write('\n' + "Pharmacy Information Upfated: " + pharmacyInfo);
                fileWriter.flush();
                fileWriter.close();

            }
            catch (IOException ex) { throw new RuntimeException(ex); }
        }
    }
    
    private void setContactInformation() {
    	contactTextArea.setText("Phone Number: " + phoneNumber);
    	contactTextArea.appendText("\n\nInsurance Information: " + insuranceInfo);
    	contactTextArea.appendText("\n\nPharmacy Information: " + pharmacyInfo);
    	
    	phoneNumberField.clear();
    	insuranceField.clear();
    	pharmacyField.clear();
    }

    public GridPane getRoot() {
        return root;
    }
}
