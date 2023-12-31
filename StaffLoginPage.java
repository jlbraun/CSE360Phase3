package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffLoginPage {

    private GridPane root;
    private Stage primaryStage;

    public StaffLoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createSignInPage();
    }

    private void createSignInPage() {
        // Create the text fields
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setMaxWidth(200);

        // Create the buttons
        Button loginButton = new Button("Login");
        Button createAccountButton = new Button("Create Account");

        // Create an HBox for the buttons
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        buttonBox.getChildren().addAll(loginButton, createAccountButton);
        

        // Create a VBox for the text fields and buttons
        VBox signInBox = new VBox(10);
        signInBox.setAlignment(Pos.CENTER);
        signInBox.setSpacing(20);
        signInBox.getChildren().addAll(usernameTextField, buttonBox);

        // Create the home button
        Button homeButton = new Button("Home");
        homeButton.setOnAction(e -> {
            // Handle home button click
            // Logic to navigate to home page
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        

        loginButton.setOnAction(e -> {
            // Handle login button click
            if (!usernameTextField.equals("")) {
                PatientFiles patientFiles = new PatientFiles();
                if (patientFiles.usernameExists(usernameTextField.getText())) {      
                	File file;
                    PatientFiles patientFilesLogin = new PatientFiles();
                    try  { file = patientFiles.createPatientInfoFile(usernameTextField.getText());
                    }
                    catch (IOException ex) { throw new RuntimeException(ex); }

                    if (file != null) {
                        try {  
                        	
                            FileWriter fileWriter = new FileWriter(file, true);
                            fileWriter.write('\n' + "********************* New Appointment *********************** ");
                            fileWriter.flush();
                            fileWriter.close();

                        }
                        catch (IOException ex) { throw new RuntimeException(ex); }
                    }
                	
                	
                	
                	
                    StaffPortal staffPortal = new StaffPortal(primaryStage, usernameTextField.getText());
                    primaryStage.setScene(new Scene(staffPortal.getRoot(), 900, 600));
                    primaryStage.setResizable(false);
                    primaryStage.setFullScreen(false);
                }
                else
                    usernameTextField.setText("username not found");
                }
            else
                usernameTextField.setText("please enter username");
        });
        
        createAccountButton.setOnAction(e -> {
            // Handle staff login button click
            CreatePatientAccount createPatientAccount = new CreatePatientAccount(primaryStage);
            primaryStage.setScene(new Scene(createPatientAccount.getRoot(), 900, 600));
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
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        root.add(topBox, 0, 0);
        root.add(signInBox, 1, 1);
        GridPane.setMargin(signInBox, new Insets(-50, 0, 0, 30));
        //root.add(logoImageView, 2, 0, 1, 3);
        //GridPane.setMargin(logoImageView, new Insets(-100, 0, 0, 0));
    }

    public GridPane getRoot() {
        return root;
    }
}
