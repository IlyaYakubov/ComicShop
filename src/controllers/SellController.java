package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SellController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField editTextComicName;

    @FXML
    private TableView<?> tableResult;

    @FXML
    private Label labelAmount;

    @FXML
    void onClickAdd(ActionEvent event) {

    }

    @FXML
    void onClickAddInCart(ActionEvent event) {

    }

    @FXML
    void onClickDelete(ActionEvent event) {

    }

    @FXML
    void onClickDiscounts(ActionEvent event) {

    }

    @FXML
    void onClickEdit(ActionEvent event) {

    }

    @FXML
    void onClickOk(ActionEvent event) {

    }

    @FXML
    void onClickReports(ActionEvent event) {

    }

    @FXML
    void onClickReserve(ActionEvent event) {

    }

    @FXML
    void onClickReserved(ActionEvent event) {

    }

    @FXML
    void onClickSearch(ActionEvent event) {

    }

    @FXML
    void onClickSell(ActionEvent event) {

    }

    @FXML
    void onClickWriteOff(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert editTextComicName != null : "fx:id=\"editTextComicName\" was not injected: check your FXML file 'sell.fxml'.";
        assert tableResult != null : "fx:id=\"tableResult\" was not injected: check your FXML file 'sell.fxml'.";
        assert labelAmount != null : "fx:id=\"labelAmount\" was not injected: check your FXML file 'sell.fxml'.";

    }
}
