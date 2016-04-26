package tests;

import UI.forms.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Mariya on 25.04.2016.
 */
public class OzBySelectionTest extends BaseTest {


    private String menu;
    private String catalog;
    private String nextCatalog;
    private String author;
    private String price;


    @BeforeMethod
    @Parameters({"menu", "catalog", "nextCatalog", "author", "price"})
    public void readParams(String menu, String catalog, String nextCatalog, String author, String price) throws Throwable{
        this.menu = menu;
        this.catalog = catalog;
        this.nextCatalog = nextCatalog;
        this.author = author;

        this.price = price;
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
        SearchCatalogForm searchCatalogForm = new SearchCatalogForm();
        searchCatalogForm.inputAuthor(author);
        searchCatalogForm.inputPrice(price);
        searchCatalogForm.submitButton();
        logger.step(5);
        searchCatalogForm.checkResult(author,price);

    }


}