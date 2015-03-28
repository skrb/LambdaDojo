package questions;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LambdaForJavaFX extends Application {
    private int count;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Lambda");
        
        // カウンタを表示するラベル
        final Label counterLabel = new Label(String.valueOf(count));
        
        Button button = new Button("Count");

        // ボタンをクリックすると、カウントアップする
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count++;
                counterLabel.setText(String.valueOf(count));
            }
        });
        
        // 垂直方向にラベルとボタンを配置するコンテナ
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(counterLabel, button);
        
        Scene scene = new Scene(root, 100, 100);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String... args) {
        launch(args);
    }
}
