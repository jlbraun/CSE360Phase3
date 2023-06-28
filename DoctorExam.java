package prototype.demo;

import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class DoctorExam {

    private VBox root;
    private Stage primaryStage;
    private String username;

    public DoctorExam(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createDoctorExam();
    }


    private void createDoctorExam() {
    	
    	
        // Create the buttons
        Button addInformation = new Button("Add information to file/nursequestions/");
        Button returnButton = new Button("Return to Patient Portal");
        
        Text examTitle = new Text();
        examTitle.setText("Doctor Examination:");
        Text examLabel = new Text();
        examLabel.setText("Add patient information to file:");
        
        TextField doctorQuestions = new TextField();
        doctorQuestions.setMaxWidth(800);
        

        // Add event handlers for the buttons
        returnButton.setOnAction(e -> {
            // Handle patient login button click
        	StaffPortal patientPortal = new StaffPortal(primaryStage, username);
            primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(examTitle, examLabel, doctorQuestions, addInformation, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        VBox.setMargin(examLabel, new Insets(50, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
