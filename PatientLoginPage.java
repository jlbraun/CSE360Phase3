package prototype.demo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PatientLoginPage {

    private GridPane root;
    private Stage primaryStage;

    public PatientLoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createSignInPage();
    }

    private void createSignInPage() {
//        // Create the logo image view
//        Image logoImage = new Image("logo.jpg");
//        ImageView logoImageView = new ImageView(logoImage);
//        logoImageView.setFitWidth(220);
//        logoImageView.setFitHeight(220);
//
//        Label titleLabel = new Label("Patient Login");
//        titleLabel.getStyleClass().add("title-label");
        
        // Create the text fields
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setMaxWidth(200);
        //usernameTextField.getStyleClass().add("username-text-field");

        // Create the buttons
        Button loginButton = new Button("Login");
        Button createAccountButton = new Button("Create Account");
        //loginButton.getStyleClass().add("dark-button");
        //createAccountButton.getStyleClass().add("light-button");

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

                if (patientFiles.getPatientInfoFile(usernameTextField.getText()) != null) {
                    PatientPortal patientPortal = new PatientPortal(primaryStage, usernameTextField.getText());
                    primaryStage.setScene(new Scene(patientPortal.getRoot(), 900, 600));
                    primaryStage.setResizable(false);
                    primaryStage.setFullScreen(false);
                }

            }

        });
        
        createAccountButton.setOnAction(e -> {
            // Handle create account button click
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
