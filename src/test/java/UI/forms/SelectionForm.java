package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by Mariya on 25.04.2016.
 */
public class SelectionForm extends BaseForm {

    private String locatorLabel = "//div/ul/li/a[text()='%s']";
    private Label lbl;
    private String locatorCatalog = "//div/ul/li/a[text()='%s']";
    private Label lblCatalog;


    /**
     * Конструктор
     */
    public SelectionForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }

    /**
     * Навигация по меню
     * @param menu меню
     */
    public void navigateMenu(String menu){
        lbl = new Label(By.xpath((String.format(locatorLabel,menu))), "Menu");
        lbl.clickAndWait(((String.format(locatorLabel,menu))),"top-panel__logo__item");
    }

    /**
     * Навигация по катологу
     * @param catalog каталог
     */
    public void navigateCatalog(String catalog){
        lblCatalog = new Label(By.xpath((String.format(locatorLabel,catalog))), "Catalog");
        lblCatalog.clickAndWait(((String.format(locatorLabel,catalog))),"top-panel__logo__item");
    }

}
