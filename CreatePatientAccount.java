package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreatePatientAccount {

    private GridPane root;
    private Stage primaryStage;

    public CreatePatientAccount(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createPatientPortal();
    }

    private void createPatientPortal() {
    	
        Image logoImage = new Image("logo.jpg"); 
        ImageView logoImageView = new ImageView(logoImage); 
        logoImageView.setFitWidth(220);
        logoImageView.setFitHeight(220);
    	
        // Create the buttons
        Button exitButton = new Button("Exit");
        
        Button homeButton = new Button("Home");
        homeButton.getStyleClass().add("dark-button");
        homeButton.setOnAction(e -> {
            // Handle home button click
            // Logic to navigate to home page
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });

        // Add event handlers for the buttons
        //CreateAccountButton.setOnAction(e -> {
            // Handle staff login button click
        //    StaffLoginPage staffLoginPage = new StaffLoginPage(primaryStage);
        //    primaryStage.setScene(new Scene(staffLoginPage.getRoot(), 900, 600));
        //    primaryStage.setResizable(false);
        //    primaryStage.setFullScreen(false);
        //});
        
        VBox topBox = new VBox(10);
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(50, 0, 0, 50));
        topBox.getChildren().addAll(homeButton);
        
        exitButton.setOnAction(e -> {
            // Handle patient login button click
        	SignInPage signInPage = new SignInPage(primaryStage);
            primaryStage.setScene(new Scene(signInPage.getRoot(), 900, 600));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);
        });
        
        Label titleLabel = new Label("Create Patient \n     Account");
        titleLabel.setWrapText(true);
        titleLabel.getStyleClass().add("create-patient-label");
        
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label dobLabel = new Label("Date of Birth:");

        // Create text fields
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();

        
        // Create date picker
        DatePicker dobDatePicker = new DatePicker();
        
        Button createAccountButton = new Button("Create Account");
        createAccountButton.getStyleClass().add("create-account-button");
//        createAccountButton.getStyleClass().add("dark-button");

        GridPane inputBox = new GridPane();
        inputBox.setHgap(10); 
        inputBox.setVgap(10); 
        inputBox.setPadding(new Insets(10));

        inputBox.add(firstNameLabel, 0, 0); // Column 0, Row 0
        inputBox.add(firstNameTextField, 1, 0); // Column 1, Row 0
        inputBox.add(lastNameLabel, 0, 1); // Column 0, Row 1
        inputBox.add(lastNameTextField, 1, 1); // Column 1, Row 1
        inputBox.add(dobLabel, 0, 2); // Column 0, Row 2
        inputBox.add(dobDatePicker, 1, 2); // Column 1, Row 2
        inputBox.add(createAccountButton, 1, 3);
        GridPane.setMargin(createAccountButton, new Insets(20, 0, 0, -20));

        // Create a VBox to hold the buttons
        root = new GridPane();
        root.setHgap(50);
        root.setVgap(100);
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        root.add(topBox, 0, 0);
        root.add(logoImageView, 2, 0, 1, 3);
        root.add(titleLabel, 1, 0);
        root.add(inputBox, 1, 1);
        GridPane.setMargin(titleLabel, new Insets(30, 0, 0, 60));
        GridPane.setMargin(inputBox, new Insets(-50, 0, 0, 60));
        GridPane.setMargin(logoImageView, new Insets(-100, 0, 0, 0));
        //root.getStylesheets().add(getClass().getResource("C:\\Users\\LoNeZiLLa\\Documents\\ASU\\Classes\\Summer 2023\\CSE 360\\Class Project\\Phase 3\\prototype\\demo\\src\\main\\java\\prototype\\demo\\application.css").toExternalForm());
        

        // Set spacing between the buttons
        //VBox.setMargin(viewInfoButton, new Insets(10, 0, 0, 0));
    }

    public GridPane getRoot() {
        return root;
    }
}
