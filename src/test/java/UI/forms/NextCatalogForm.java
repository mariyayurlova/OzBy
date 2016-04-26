package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by Mariya on 25.04.2016.
 */
public class NextCatalogForm extends BaseForm {

    private String locatorLabel = "//div/h3/a[text()='%s']";
    private Label lblCatalog;


    /**
     * Конструктор
     */
    public NextCatalogForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }


    /**
     * Переходим по меню
     * @param nextCatalog следующий каталог
     */
    public void navigateNextCatalog(String nextCatalog){
        lblCatalog = new Label(By.xpath((String.format(locatorLabel,nextCatalog))), "NextCatalog");
        lblCatalog.clickAndWait(((String.format(locatorLabel,nextCatalog))),"top-panel__logo__item");
    }

}