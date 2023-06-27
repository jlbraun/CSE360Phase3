//THIS IS NOT A USED FILE IT IS PROTOTYPE ONLY YOU DO NOT NEED IT
package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignIn extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the logo image view
        Image signInImage = new Image("signin.jpg"); // Replace "path_to_logo_image.png" with the actual path to your logo image
        ImageView signInImageView = new ImageView(signInImage);
        signInImageView.setFitWidth(250); // Adjust the desired width
        signInImageView.setFitHeight(250); // Adjust the desired height
        signInImageView.setStyle("-fx-background-color: red;");


        // Create the buttons
        Button staffLoginButton = new Button("Staff Login");
        Button patientLoginButton = new Button("Patient Login");
        
        staffLoginButton.getStyleClass().add("custom-button");
        patientLoginButton.getStyleClass().add("custom-button");
        

        // Add event handlers for the buttons
        staffLoginButton.setOnAction(e -> {
            // Handle staff login button click
        	navigateToLoginPage("Staff");
        });

        patientLoginButton.setOnAction(e -> {
            // Handle admin login button click
        });

        // Create the layout
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(signInImageView, staffLoginButton, patientLoginButton);
//        VBox.setMargin(staffLoginButton, new Insets(10, 0, 0, 0));

        // Create the scene
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Set the stage properties
        primaryStage.setTitle("Sign In");
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void navigateToLoginPage(String userType) {
        // Logic to navigate to the login page based on the user type
        Stage loginStage = new Stage();
        loginStage.setTitle(userType + " Login");
        
        // Create the login page content
        // You can customize this section based on your requirements
        VBox loginRoot = new VBox(20);
        loginRoot.setAlignment(Pos.CENTER);
        loginRoot.setPadding(new Insets(20));
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> loginStage.close()); // Close the login page and go back to the main page
        
        loginRoot.getChildren().addAll(backButton);
        
        Scene loginScene = new Scene(loginRoot, 400, 300);
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
