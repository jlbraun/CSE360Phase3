package prototype.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdatePatientInfoStaff {

    private VBox root;
    private Stage primaryStage;
    private String username;

    public UpdatePatientInfoStaff(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
        createUpdatePatientInfoStaff();
    }

    private void createUpdatePatientInfoStaff() {
    	
    	
        // Create the buttons
        Button updateButtonPhone = new Button("Update Phone Number");
        Button updateButtonInsurance = new Button("Update Insurance Information");
        Button updateButtonPharmacy = new Button("Update Pharmacy Information");
        Button returnButton = new Button("Return to Staff Portal");

        // Add event handlers for the buttons
        //messageButton.setOnAction(e -> {
            // Handle staff login button click
            //StaffLoginPage staffLoginPage = new StaffLoginPage(primaryStage);
            //primaryStage.setScene(new Scene(staffLoginPage.getRoot(), 900, 600));
            //primaryStage.setResizable(false);
            //primaryStage.setFullScreen(false);
        //});
        
        //viewInfo will open text file in first iteration, bonus points for view only
        //viewInfoButton.setOnAction(e -> {
            // Handle patient login button click
        //    PatientLoginPage patientLoginPage = new PatientLoginPage(primaryStage);
        //    primaryStage.setScene(new Scene(patientLoginPage.getRoot(), 900, 600));
        //    primaryStage.setResizable(false);
        //    primaryStage.setFullScreen(false);
        //});
        
        //updateInfoButton.setOnAction(e -> {
            // Handle patient login button click
            //PatientLoginPage patientLoginPage = new PatientLoginPage(primaryStage);
            //primaryStage.setScene(new Scene(patientLoginPage.getRoot(), 900, 600));
            //primaryStage.setResizable(false);
            //primaryStage.setFullScreen(false);
        //});
        
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
        root.getChildren().addAll(updateButtonPhone, updateButtonInsurance, updateButtonPharmacy, returnButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        //VBox.setMargin(updateButtonPhone, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
