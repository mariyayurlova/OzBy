package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by Mariya on 25.04.2016.
 */
public class MainForm extends BaseForm {


    Label lblLogOut;

    /**
     * Конструктор
     */
    public MainForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }


    /**
     * Выбираем выйти
     */
    public void clickLogOut(){
        lblLogOut = new Label(By.xpath("//li/a[@class='top-panel__userbar__ppnav__item exit']/span[@class='top-panel__userbar__ppnav__name']"));
    }


    /**
     * Проверяем вышли ли
     */
    public void checkLogOut(){
        Label lblCheckLogOut = new Label(By.xpath("//li/a/span[@class='top-panel__userbar__auth__ico']"));

        if (lblCheckLogOut.isPresent(5)){
            info("LogOut successful");
        }
        else{
            error("You can't logout");
        }
    }





}
