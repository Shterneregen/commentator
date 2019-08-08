package random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader
                .load(Objects.requireNonNull(getClass().getClassLoader().getResource("frame.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Commentator");
        primaryStage.show();

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

}
