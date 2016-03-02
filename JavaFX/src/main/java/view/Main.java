package view;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlFile = "/fx/sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("Battle Ship");
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add("/fx/style.css");
        primaryStage.show();


        Controller controller = new Controller();
        controller.gameSession();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
