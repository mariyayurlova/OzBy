package UI.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.BaseElement;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

import java.util.List;

/**
 * Created by Mariya on 25.04.2016.
 */
public class SearchForm extends BaseForm {

    TextBox txtSearch = new TextBox(By.xpath("//div/input[@id='top-s']"), "Search");
    Button btnSearch = new Button(By.xpath("//button[@class='top-panel__search__btn']"),"SearchButton");
    String buttonSearch = "//button[@class='top-panel__search__btn']";
    private String locTitleItem = "//div/ul/li/div/div/div/a/p/span[contains(text(),'%s')]";
    int countFirst = 0;
    int count = 0;

    /**
     * КОнструктор
     */
    public SearchForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }


    /**
     * Переопределяем метод
     */
    private BaseElement beList = new BaseElement(By.className("top-panel__logo__item"), "Oz.by") {
        @Override
        protected String getElementType() {
            return null;
        }
    };


    /**
     * Вводим запрос
     * @param inquiry запрос
     */
    public void inputInquiry(String inquiry){
        txtSearch.type(inquiry);
    }

    /**
     * Начинаем поиск
     */
    public void clickSearch(){
        btnSearch.clickAndWait(buttonSearch, "top-panel__search__btn__txt");
    }

    /**
     * Проверяем на совпадения запроса и результата
     * @param inquiry запрос
     */
    public void checkResult(String inquiry){


        List<WebElement> list = beList.findElements(String.format(locTitleItem,inquiry));
        info(String.valueOf(list.size()));
        for (int i=0; i<list.size(); i++) {
        if((list.get(i).getText()).equals(inquiry)){
            info("The element "+i+" received "+list.get(i).getText()+ " coincides with the request "+inquiry);
            count = countFirst+1;
        }
        else
        {warn("The element "+i+" received "+list.get(i).getText()+" does not coincide with the request "+inquiry);}}


        info("Successful "+count+" item");



    }

    public void testingSearch(String inquiry){
        List<WebElement> list = beList.findElements(String.format(locTitleItem,inquiry));
        if (count == list.size()){
            info("All match results");
        }
        else{
            error("Not all of the same");

        }
    }




}
