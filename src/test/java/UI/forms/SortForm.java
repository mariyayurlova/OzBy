package UI.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.BaseElement;
import webdriver.elements.Label;

import java.util.List;

/**
 * Created by Mariya on 26.04.2016.
 */
public class SortForm extends BaseForm {

    private Label lblSort = new Label(By.xpath("//div/ul/li/div/span[@class='top-filters__eselect__item top-filters__viewer__open']"), "Sorting");
    private Label lblItemSort;
    private Label lblDeleteLabel = new Label(By.xpath("//li[@class='top-filters__sqcheckers__li top-filters__sqcheckers__li_lastval']/a[@class='top-filters__sqcheckers__del']"), "DeleteSettings");
    private String locSort = "//li/a[@data-sort='price_asc']";

    /**
     * КОнструктор
     */
    public SortForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }

    /**
     * Переопределяем метод
     */
    private BaseElement beList3 = new BaseElement(By.className("top-panel__logo__item"), "Oz.by") {
        @Override
        protected String getElementType() {
            return null;
        }
    };


    /**
     * Выбираем сортировку
     */
    public void clickSortLabel(){
        lblSort.click();
    }



    /**
     * Выбираем тип сортировки
     */
    public void clickSortItem(String name){

        lblItemSort = new Label(By.xpath(String.format(locSort,name)), "Sorting");
        lblItemSort.click();
    }

    /**
     * Убераем лишнее из сортировки
     */
    public void clickDelLabel(){
        lblDeleteLabel.click();
    }

    /**
     * Проверяем прошла ли сортировка успешно
     */
    public void testingSort(){


        List<WebElement> list = beList3.findElements("//div/a/span[@class='item-type-card__btn']");
        info(String.valueOf(list.size()));
        for (int i = 0; i < 94; i++) {
            list = beList3.findElements("//div/a/span[@class='item-type-card__btn']");


            String resultA = String.valueOf(list.get(i).getText().split(" руб.")[0]);
            String resA = resultA.replaceAll(" ","");
            info(resA);
            String resultB = String.valueOf(list.get(i+1).getText().split(" руб.")[0]);
            String resB = resultB.replaceAll(" ","");
            int a = Integer.parseInt(resA);
            int b = Integer.parseInt(resB);

            if (a>b) {
                error("Sorting error "+i);
            }

            else {

                info("Sorting successful "+i);
            }

        }
                }
        }






