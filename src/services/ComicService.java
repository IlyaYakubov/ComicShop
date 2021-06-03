package services;

import domain.Comic;
import domain.sell.Cart;
import domain.sell.CartItem;
import domain.sell.Sell;
import repository.FileDao;
import repository.SellDao;
import repository.WriteOffDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис по работе с комиксами
 */
public class ComicService {

    private static final String DELIMITER = ";";

    private FileDao fileDao = new FileDao();
    private List<String> comicsInFile = fileDao.readFromFile();

    /**
     * Добавление комикса из элементов
     *
     * @param comic - элементы комикса
     */
    public void addComic(String[] comic) {
        fileDao.saveToFile(formComicFromElements(comic).toString());
    }

    /**
     * Редактирование комикса
     *
     * @param comic - элементы комикса
     */
    public void editComic(String[] comic) {
        for (String elementsOfComic : comicsInFile) {
            if (elementsOfComic.equals(comic[0])) {
                deleteComic(elementsOfComic);
                addComic(comic);
            }
        }
    }

    /**
     * Удаление комикса
     * При совпадении имени комикс не перезаписывается
     * (файл предварительно удаляется)
     *
     * @param nameOfComic - название комикса
     */
    public void deleteComic(String nameOfComic) {
        if (comicsInFile.size() > 0) {
            List<String> newListOfComics = new ArrayList<>();
            fileDao.deleteFile();
            boolean wasAPass = false;
            for (String comic : comicsInFile) {
                String[] arrayOfElements = comic.split(DELIMITER);
                if (arrayOfElements[0].equals(nameOfComic) && !wasAPass) {
                    wasAPass = true;
                    continue;
                }
                newListOfComics.add(comic);
                fileDao.saveToFile(comic);
            }
            comicsInFile = newListOfComics;
        }
    }

    /**
     * Продажа комиксов
     *
     * @param cart - корзина комиксов
     */
    public void makePurchase(Cart cart) {
        for (CartItem item : cart.getComics()) {
            deleteComic(item.getComic());
        }

        SellDao sellDao = new SellDao();
        for (CartItem comic : cart.getComics()) {
            String buyItem = LocalDateTime.now() + DELIMITER + comic.getComic() + DELIMITER
                    + comic.getPrice();
            sellDao.saveToFile(buyItem);
        }
        Sell sell = new Sell(cart);
        sell.makePurchase();
    }

    /**
     * Списание комиксов
     *
     * @param cart - корзина комиксов
     */
    public void writeOffComics(Cart cart) {
        for (CartItem comic : cart.getComics()) {
            deleteComic(comic.getComic());
        }

        WriteOffDao writeOffDao = new WriteOffDao();
        for (CartItem comic : cart.getComics()) {
            String buyItem = LocalDateTime.now() + DELIMITER + comic.getComic();
            writeOffDao.saveToFile(buyItem);
        }

        cart.getComics().clear();
    }

    /**
     * Получение комикса по наименованию
     *
     * @param nameOfComic - наименование комикса
     * @return - комикс, если найден в файле
     */
    public Comic getComicByName(String nameOfComic) {
        return fileDao.getComicByName(nameOfComic);
    }

    private StringBuilder formComicFromElements(String[] comic) {
        StringBuilder data = new StringBuilder();
        data
                .append(comic[0]).append(DELIMITER) // наименование
                .append(comic[1]).append(DELIMITER) // автор
                .append(comic[2]).append(DELIMITER) // издательство
                .append(comic[3]).append(DELIMITER) // количество страниц
                .append(comic[4]).append(DELIMITER) // жанр
                .append(comic[5]).append(DELIMITER) // год издательства
                .append(comic[6]).append(DELIMITER) // себестоимость
                .append(comic[7]).append(DELIMITER) // цена продажи
                .append(comic[8]).append(DELIMITER); // является продолжением
        return data;
    }
}
