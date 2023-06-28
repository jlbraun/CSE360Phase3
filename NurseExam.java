package prototype.demo;

import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class NurseExam {

    private GridPane root;
    private Stage primaryStage;
    private String username;

    public NurseExam(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createNurseExam();
    }

    private void createNurseExam() {
        // Create the buttons
        Button addExamInformation = new Button("Add information to file/nursequestions/");
        Button returnButton = new Button("Return to Patient Portal");

        //Text patientUsernameText = new Text("Patient Username: ");
        Text questionTitle = new Text();
        questionTitle.setText("Nurse Examination:");
        
        Text heightText = new Text();
        heightText.setText("Height: ");
        Text weightText = new Text();
        weightText.setText("Weight: ");
        Text pressureText = new Text();
        pressureText.setText("Blood Pressure: ");
        Text temperatureText = new Text();
        temperatureText.setText("Body Temperature: ");

        //TextField patientUsernameField = new TextField();
        //patientUsernameField.setMaxWidth(400);
        TextField heightField = new TextField();
        heightField.setMaxWidth(400);
        TextField weightField = new TextField();
        weightField.setMaxWidth(400);
        TextField pressureField = new TextField();
        pressureField.setMaxWidth(400);
        TextField temperatureField = new TextField();
        temperatureField.setMaxWidth(400);

        // Add event handlers for the buttons
        addExamInformation.setOnAction( e -> {
            File file;
            PatientFiles patientFiles = new PatientFiles();
            try {
                file = patientFiles.createPatientInfoFile(username);
            } catch (IOException ex) { throw new RuntimeException(ex); }
            if (file != null) {
                try {
                    patientFiles.saveNurseExamInfo(username, heightField.getText(), weightField.getText(), pressureField.getText(), temperatureField.getText());
                } catch (IOException ex) { throw new RuntimeException(ex); }
            }
        });

        returnButton.setOnAction(e -> {
            // Handle patient login button click
        	StaffPortal patientPortal = new StaffPortal(primaryStage, username);
            primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        VBox leftBox = new VBox(10);
        leftBox.setAlignment(Pos.TOP_LEFT);
        leftBox.getChildren().addAll(heightText, weightText, pressureText, temperatureText);


        VBox centerBox = new VBox(10);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(questionTitle, heightField, weightField, pressureField, temperatureField, addExamInformation, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

     // Create a BorderPane to hold the logo, sign-in content, and home button
        root = new GridPane();
        root.setHgap(50);
        root.setVgap(100);
        root.setPadding(new Insets(10));

        root.add(leftBox, 1, 1);
        root.add(centerBox, 2, 1);

        VBox.setMargin(heightText, new Insets(10, 0, 0, 150));
        VBox.setMargin(weightText, new Insets(10, 0, 0, 150));
        VBox.setMargin(pressureText, new Insets(10, 0, 0, 150));
        VBox.setMargin(temperatureText, new Insets(10, 0, 0, 150));

        // Set spacing between the buttons
        //VBox.setMargin(questionTitle, new Insets(50, 0, 0, 0));
    }

    public GridPane getRoot() {
        return root;
    }
}
