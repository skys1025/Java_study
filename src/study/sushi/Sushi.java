package study.sushi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Sushi extends Application {
    final private double ROTATION_PER_SEC = 1;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("SUSHI");

        Group root = new Group();
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);

        Text sushi = new Text(50, 125, "鮨");
        sushi.setFill(Color.RED);
        sushi.setFont(new Font("Meiryo", 100));

        root.getChildren().add(sushi);
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double degree = ROTATION_PER_SEC * 360 * (currentNanoTime - startNanoTime) / 1000000000;
                sushi.setRotate(degree);
            }
        }.start();

        stage.show();
    }
}
