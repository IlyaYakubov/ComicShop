package presenters;

import domain.Comic;
import domain.sell.Cart;
import domain.sell.CartItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.ComicService;
import ui.WriteOffUI;

/**
 * Контроллер списания комиксов
 */
public class WriteOffPresenter {

    private ComicService comicService;
    private WriteOffUI writeOffUI;
    private Cart cart = new Cart();

    public WriteOffPresenter(WriteOffUI writeOffUI) {
        comicService = new ComicService();
        this.writeOffUI = writeOffUI;
    }

    /**
     * При нажатии на кнопку добавления комикса в корзину
     * @param comicName - наименование комикса
     */
    public void onClickAdd(String comicName) {
        Comic comic = comicService.getComicByName(comicName);
        if (comic == null) {
            return;
        }
        cart.addComic(comic);
        ObservableList<CartItem> comics = FXCollections.observableArrayList(cart.getComics());
        writeOffUI.setContent(comics);
    }

    /**
     * При нажатии на кнопку "списать"
     */
    public void onClickWriteOff() {
        comicService.writeOffComics(cart);
    }
}