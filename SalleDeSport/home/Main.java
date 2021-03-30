package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SalleDeSport.fxml"));
        primaryStage.setScene(new Scene(root));
        Image icon = new Image(getClass().getResourceAsStream("logo.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("SPORTify-Gestion salle de sport");
        //set stage borderless
        //primaryStage.initStyle(StageStyle.UNDECORATED);
root.getStylesheets().add("style.css");
        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
