package ui.discount;

import domain.discounts.Discount;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presenters.DiscountListPresenter;

/**
 * Окно акций
 */
public class DiscountListUI extends Application {

    private TableView<Discount> table;

    /**
     * Отображает окно акций
     *
     * @param stage окно
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Акции");

        Button buttonAdd = new Button("Создать");
        buttonAdd.setFont(new Font(15));
        buttonAdd.setPrefWidth(200);

        HBox hBox = new HBox();
        hBox.getChildren().add(buttonAdd);

        table = new TableView<>();
        table.setPrefHeight(800.0);

        TableColumn<Discount, String> nameColumn = new TableColumn<>("Список акций");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(800.0);
        table.getColumns().add(nameColumn);

        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(table);
        vBox.setSpacing(20.0);
        vBox.setPadding(new Insets(20));

        DiscountListPresenter discountListPresenter = new DiscountListPresenter(this);
        discountListPresenter.updateTableDiscounts();

        buttonAdd.setOnMouseClicked(mouseEvent -> {
            DiscountUI discountUI = new DiscountUI();
            discountUI.start(new Stage());
        });

        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Установка контента в элементы окна
     *
     * @param comics список комиксов
     */
    public void setContent(ObservableList<Discount> comics) {
        table.setItems(comics);
    }
}
