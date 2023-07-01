package application;

import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class DoctorExam {

    private VBox root;
    private Stage primaryStage;
    private String username;

    public DoctorExam(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createNurseQuestions();
    }

    private void createNurseQuestions() {
        // Create the buttons
        Button addInformation = new Button("Add information to file/nursequestions/");
        Button returnButton = new Button("Return to Staff Portal");
        
        Text questionTitle = new Text();
        questionTitle.setText("Nurse questionnaire:");
        Text questionLabel = new Text();
        questionLabel.setText("Add patient information to file:");

        TextField nurseQuestions = new TextField();
        nurseQuestions.setMaxWidth(800);

        

        // Add event handlers for the buttons
        addInformation.setOnAction(e -> {
            File file;
            PatientFiles patientFiles = new PatientFiles();
            try  { file = patientFiles.createPatientInfoFile(username);
            }
            catch (IOException ex) { throw new RuntimeException(ex); }

            if (file != null) {
                try { patientFiles.saveQuestionInfo(username, nurseQuestions.getText());
                }
                catch (IOException ex) { throw new RuntimeException(ex); }
            }
        });
        
        returnButton.setOnAction(e -> {
            // Handle patient login button click
        	StaffPortal staffPortal = new StaffPortal(primaryStage, username);
            primaryStage.setScene(new Scene(staffPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(20));
        root.getChildren().addAll(questionTitle, questionLabel, nurseQuestions, addInformation, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        VBox.setMargin(questionLabel, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
