package prototype.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CreatePatientAccount {

    private GridPane root;
    private Stage primaryStage;

    public CreatePatientAccount(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createPatientAccount();
    }

    private void createPatientAccount() {
        // Create the buttons
        Button createAccountButton = new Button("Create Account");
        Button exitButton = new Button("Exit");

        // Create Labels
        Text windowLabel = new Text("Create New Patient Account");
        Text usernameText = new Text("Enter Username: ");
        Text accountCreatedText = new Text("Account Created!");

        // Create username TextField
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(300);


        // Add event handlers for the buttons
        createAccountButton.setOnAction(e -> {
            if (!usernameField.equals("")) {
                File file;
                // Handle button click
                PatientFiles patientFiles = new PatientFiles();
                try {
                    file = patientFiles.createPatientInfoFile(usernameField.getText());
                    boolean result = file.createNewFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                PatientPortal patientPortal = new PatientPortal(primaryStage, usernameField.getText());
                primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
                primaryStage.setResizable(false);
                primaryStage.setFullScreen(false);
            }
        });
        
        exitButton.setOnAction(e -> {
            // Handle patient login button click
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        VBox leftBox = new VBox(10);
        leftBox.setAlignment(Pos.TOP_LEFT);
        leftBox.getChildren().add(usernameText);

        VBox centerBox = new VBox(10);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(windowLabel, usernameField, createAccountButton, exitButton);

        // Create a VBox to hold the buttons
        root = new GridPane();
        root.setHgap(50);
        root.setVgap(100);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_LEFT);
        root.add(leftBox, 1, 1);
        root.add(centerBox, 2, 1);

        VBox.setMargin(usernameText, new Insets(25, 0, 0, 0));
//        root.setPadding(new Insets(20));
        //root.getChildren().addAll(windowLabel, createAccountButton, exitButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        //VBox.setMargin(viewInfoButton, new Insets(10, 0, 0, 0));
    }

    public GridPane getRoot() {
        return root;
    }
}
