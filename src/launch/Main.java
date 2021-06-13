package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.old.MainUI;

import java.io.IOException;
import java.util.Objects;

/**
 * Начало программы
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Отображает окно входа в систему
     *
     * @param stage окно
     * @throws IOException исключение, если не возможно открыть окно
     */
    @Override
    public void start(Stage stage) throws IOException {
        MainUI mainUI = new MainUI();
        mainUI.start(new Stage());
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ui/resources/login.fxml")));
        stage.setTitle("Вход");
        stage.setScene(new Scene(root, 240, 145));
        stage.setResizable(false);
        stage.show();*/
    }
}
