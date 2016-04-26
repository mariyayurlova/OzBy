package tests;

import UI.forms.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Mariya on 26.04.2016.
 */
public class OzBySortPrice extends BaseTest {


    private String menu;
    private String catalog;
    private String nextCatalog;
    private String name;


    @BeforeMethod
    @Parameters({"menu", "catalog", "nextCatalog", "name"})
    public void readParams(String menu, String catalog, String nextCatalog, String name) throws Throwable{
        this.menu = menu;
        this.catalog = catalog;
        this.nextCatalog = nextCatalog;
        this.name = name;
    }


    public void runTest() throws InterruptedException {
        logger.step(1);
        SelectionForm selectionForm = new SelectionForm();
        selectionForm.navigateMenu(menu);
        logger.step(2);
        CatalogForm catalogForm = new CatalogForm();
        catalogForm.navigateCatalog(catalog);
        logger.step(3);
        NextCatalogForm nextCatalogForm = new NextCatalogForm();
        nextCatalogForm.navigateNextCatalog(nextCatalog);
        logger.step(4);
        SortForm sortForm = new SortForm();
        sortForm.clickDelLabel();
        logger.step(5);
        sortForm.clickSortLabel();
        sortForm.clickSortItem(name);
        logger.step(6);
        sortForm.testingSort();



    }


}
