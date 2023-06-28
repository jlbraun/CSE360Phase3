package prototype.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffPortal {

    private VBox root;
    private Stage primaryStage;
    private String username;

    public StaffPortal(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createStaffPortal();
    }

    private void createStaffPortal() {
    	
    	
        // Create the buttons
        Button nurseExamButton = new Button("Nurse Examination");
        Button nurseQuestionsButton = new Button("Nurse Questionnaire");
        Button doctorExamButton = new Button("Doctor Examination");
        Button messageButton = new Button("Message Portal");
        Button updatePatientInfoButton = new Button("Update Patient Information");
        Button exitButton = new Button("Exit");

        // Add event handlers for the buttons
        nurseExamButton.setOnAction(e -> {
            // Handle staff login button click
            NurseExam nurseExam = new NurseExam(primaryStage, username);
            primaryStage.setScene(new Scene(nurseExam.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
     // Add event handlers for the buttons
        nurseQuestionsButton.setOnAction(e -> {
            // Handle staff login button click
            NurseQuestions nurseQuestions = new NurseQuestions(primaryStage, username);
            primaryStage.setScene(new Scene(nurseQuestions.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
     // Add event handlers for the buttons
        doctorExamButton.setOnAction(e -> {
            // Handle staff login button click
            DoctorExam doctorExam = new DoctorExam(primaryStage, username);
            primaryStage.setScene(new Scene(doctorExam.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        messageButton.setOnAction(e -> {
            // Handle patient login button click
            MessagePortalStaff messagePortalStaff = new MessagePortalStaff(primaryStage, username);
            primaryStage.setScene(new Scene(messagePortalStaff.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        exitButton.setOnAction(e -> {
            // Handle patient login button click
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        updatePatientInfoButton.setOnAction(e -> {
            // Handle patient login button click
        	UpdatePatientInfoStaff updatePatientInfoStaff = new UpdatePatientInfoStaff(primaryStage, username);
            primaryStage.setScene(new Scene(updatePatientInfoStaff.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(20));
        root.getChildren().addAll(nurseExamButton, nurseQuestionsButton, doctorExamButton, messageButton, updatePatientInfoButton, exitButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        //VBox.setMargin(viewInfoButton, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
