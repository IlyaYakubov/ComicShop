package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Основное окно
 */
public class MainUI extends Application {

    /**
     * Отображает кнопки меню
     *
     * @param stage - окно
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Магазин комиксов");

        Button buttonAddComic = new Button("Добавление");
        buttonAddComic.setPrefWidth(200);
        buttonAddComic.setPrefHeight(70);
        buttonAddComic.setFont(new Font(15));
        Button buttonEditComic = new Button("Редактирование");
        buttonEditComic.setPrefWidth(200);
        buttonEditComic.setPrefHeight(70);
        buttonEditComic.setFont(new Font(15));
        Button buttonDeleteComic = new Button("Удаление");
        buttonDeleteComic.setPrefWidth(200);
        buttonDeleteComic.setPrefHeight(70);
        buttonDeleteComic.setFont(new Font(15));
        Button buttonSellComic = new Button("Продажа");
        buttonSellComic.setPrefWidth(200);
        buttonSellComic.setPrefHeight(70);
        buttonSellComic.setFont(new Font(15));
        Button buttonWriteOffComic = new Button("Списание");
        buttonWriteOffComic.setPrefWidth(200);
        buttonWriteOffComic.setPrefHeight(70);
        buttonWriteOffComic.setFont(new Font(15));

        TilePane tilePane = new TilePane();
        tilePane.setOrientation(Orientation.VERTICAL);
        tilePane.setMargin(buttonAddComic, new Insets(20.0));
        tilePane.setMargin(buttonEditComic, new Insets(20.0));
        tilePane.setMargin(buttonDeleteComic, new Insets(20.0));
        tilePane.setMargin(buttonSellComic, new Insets(20.0));
        tilePane.setMargin(buttonWriteOffComic, new Insets(20.0));

        tilePane.getChildren().add(buttonAddComic);
        tilePane.getChildren().add(buttonEditComic);
        tilePane.getChildren().add(buttonDeleteComic);
        tilePane.getChildren().add(buttonSellComic);
        tilePane.getChildren().add(buttonWriteOffComic);

        buttonAddComic.setOnMouseClicked(mouseEvent -> {
            AdditionUI additionUI = new AdditionUI();
            additionUI.start(new Stage());
        });

        buttonEditComic.setOnMouseClicked(mouseEvent -> {
            FindBeforeEditUI findBeforeEditUI = new FindBeforeEditUI();
            findBeforeEditUI.start(new Stage());
        });

        buttonDeleteComic.setOnMouseClicked(mouseEvent -> {
            DeleteUI deleteUI = new DeleteUI();
            deleteUI.start(new Stage());
        });

        buttonSellComic.setOnMouseClicked(mouseEvent -> {
            SellUI sellUI = new SellUI();
            sellUI.start(new Stage());
        });

        buttonWriteOffComic.setOnMouseClicked(mouseEvent -> {
            WriteOffUI writeOffUI = new WriteOffUI();
            writeOffUI.start(new Stage());
        });

        Scene scene = new Scene(tilePane, 250, 550);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
