package prototype.demo;

import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class DoctorExam {

    private VBox root;
    private Stage primaryStage;

    public DoctorExam(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	
    	
        // Create the buttons
        Button sendMessageButton = new Button("Add information to file/nursequestions/");
        Button returnButton = new Button("Return to Patient Portal");
        
        Text examTitle = new Text();
        examTitle.setText("Doctor Examination:");
        Text examLabel = new Text();
        examLabel.setText("Add patient information to file:");
        
        TextField nurseQuestions = new TextField();
        nurseQuestions.setMaxWidth(800);
        

        // Add event handlers for the buttons
        returnButton.setOnAction(e -> {
            // Handle patient login button click
        	StaffPortal patientPortal = new StaffPortal(primaryStage);
            primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(examTitle, examLabel, nurseQuestions, sendMessageButton, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        VBox.setMargin(examLabel, new Insets(50, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
