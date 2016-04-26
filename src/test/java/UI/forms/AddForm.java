package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

/**
 * Created by Mariya on 26.04.2016.
 */
public class AddForm extends BaseForm {
    Label lblAdd = new Label(By.xpath("//div/a/p/span[@class='g-highlight']"),"OnDescription");
    Button btnAdd = new Button(By.xpath("//form/button[@id='firstButton']"),"Add");
    Label lblTest = new Label(By.xpath("//li/a[@class='top-panel__userbar__cart__item']"),"Go to add");

    /**
     * Конструктор
     */

    public AddForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }

    /**
     * Поиск label для добавления в корзину
     */
    public void searchItem(){
        lblAdd.click();
    }

    /**
     * Добавить в корзину
     */

    public void submitButton(){
        btnAdd.click();
    }

    /**
     * Проверка на наличие в корзине выбранного эелемента
     * @param inquiry запрос
     */

    public void testingAdd(String inquiry){
        lblTest.click();
        Label name = new Label (By.xpath("//div/a[@class='goods-table-cell__line goods-table-cell__line_title']"));
        info(name.getText());
        String nameAnswer = name.getText();

        if(nameAnswer.equals(inquiry)){
            info("Item add");
        }
        else{
            error("Item not add");
        }
    }


}
