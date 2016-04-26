package UI.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.*;

import java.util.List;

/**
 * Created by Mariya on 25.04.2016.
 */
public class SearchCatalogForm extends BaseForm {

    private TextBox lblAuthor;
    private String locAuthor = "//div/label/input[@id='fm-input-ac-id_people']";
    private TextBox txtPrice = new TextBox(By.xpath("//div/span/input[@id='inp1_r_cost']"));
    private Button btnSubmit = new Button(By.xpath("//button[@class='filters__searchbtn__btn']"));


    ResultCatalogForm resultCatalogForm = new ResultCatalogForm();


    /**
     * Конструктор
     */
    public SearchCatalogForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }

    /**
     * Переопределяем метод
     */
    private BaseElement beList2 = new BaseElement(By.className("top-panel__logo__item"), "Oz.by") {
        @Override
        protected String getElementType() {
            return null;
        }
    };



    /**
     * Вводим атвора
     * @param author атвор
     */

    public void inputAuthor(String author){
        lblAuthor = new TextBox(By.xpath(locAuthor), "Select Author");
        lblAuthor.type(author);
        Label lblSearch = new Label(By.xpath("//ul/li/a[@class='ui-corner-all']"));
        lblSearch.click();
    }


    /**
     * Вводим цену
     * @param price цену
     */
    public void inputPrice(String price){
        txtPrice.type(price);
    }

    /**
     * Запускаем сортировку
     */
    public void submitButton(){
        btnSubmit.clickAndWait("//button[@class='filters__searchbtn__btn']","top-panel__logo__item");
    }

    /**
     * Проверяем на соответствие запроса и результата
     * @param author автор
     * @param price цена
     */
   public void checkResult(String author, String price) throws InterruptedException {
       List<WebElement> list = beList2.findElements("//div/ul/li/div/div/div/a/p[@class='item-type-card__title']");
       info(String.valueOf(list.size()));
       for (int i = 0; i < list.size(); i++) {
           list = beList2.findElements("//div/ul/li/div/div/div/a/p[@class='item-type-card__title']");
           list.get(i).click();
           if ((resultCatalogForm.testAuthor(author) == true) & (resultCatalogForm.testPrice(price) == true)) {
               info("Item "+i+" successful");
               browser.goBack();
           } else {
               error("Item does not match");
           }

       }
   }

}
