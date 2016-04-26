package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by Mariya on 25.04.2016.
 */
public class ResultCatalogForm  extends BaseForm{
    /**
     * Конструктор
     */
    protected ResultCatalogForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }


    /**
     * Проверяем автора
     * @param author автор
     */
    public boolean testAuthor(String author){

        Label lblName = new Label (By.xpath("//div/a[@class='b-product-title__inner-link']"));
        String test = (lblName.getText());
        info(test);
        info("We need: "+author+" We have: "+test);
        if (test.equals(author)){
            return true;
        }
        else{
            error("Author does not match");
            return false;}


    }

    /**
     * Проверяем цену
     * @param price цена
     */
    public boolean testPrice(String price){

        Label lblPrice = new Label (By.xpath("//div/span[@class='b-product-control__text b-product-control__text_main']"));
        String  priceR = lblPrice.getText();
        info("We need: "+price+" <= "+priceR);
        String resultR = priceR.replaceAll(" ", "");
        String resultD = resultR.replaceAll("руб.", "");
        info(resultD);
        int priceResultFirst = new Integer(price).intValue();
        int priceResultSecond = new Integer(resultD).intValue();
        if (priceResultFirst <= priceResultSecond){
            return true;
        }
        else
        {
            error("Price does not match");
            return false;
        }

    }


    }

