package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Page");

        SignInPage signInPage = new SignInPage(primaryStage);
        Scene scene = new Scene(signInPage.getRoot(), 800, 600);
        //scene.getStylesheets().add(getClass().getResource("C:\\Users\\LoNeZiLLa\\Documents\\ASU\\Classes\\Summer 2023\\CSE 360\\Class Project\\Phase 3\\prototype\\demo\\src\\main\\java\\prototype\\demo\\application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
