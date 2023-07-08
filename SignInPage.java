package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignInPage {

    private VBox root;
    private Stage primaryStage;

    public SignInPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createSignInPage();
    }

    private void createSignInPage() {
        // Create the buttons
        Button staffLoginButton = new Button("Staff Login");
        Button patientLoginButton = new Button("Patient Login");

        // Add event handlers for the buttons
        staffLoginButton.setOnAction(e -> {
            // Handle staff login button click
            StaffLoginPage staffLoginPage = new StaffLoginPage(primaryStage);
            primaryStage.setScene(new Scene(staffLoginPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        patientLoginButton.setOnAction(e -> {
            // Handle patient login button click
            PatientLoginPage patientLoginPage = new PatientLoginPage(primaryStage);
            primaryStage.setScene(new Scene(patientLoginPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Create a VBox to hold the buttons
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(20));
        root.getChildren().addAll(staffLoginButton, patientLoginButton);
        //root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set spacing between the buttons
        VBox.setMargin(staffLoginButton, new Insets(10, 0, 0, 0));
    }

    public VBox getRoot() {
        return root;
    }
}
