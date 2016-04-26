package tests;

import UI.forms.AddForm;
import UI.forms.SearchForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Mariya on 26.04.2016.
 */
public class OzByAddTest extends BaseTest {


    private String inquiry;


    @BeforeMethod
    @Parameters({"inquiry"})
    public void readParams(String inquiry) throws Throwable{
        this.inquiry = inquiry;
    }


    public void runTest()  {

        logger.step(1);
        SearchForm searchForm = new SearchForm();
        searchForm.inputInquiry(inquiry);
        searchForm.clickSearch();

        logger.step(2);
        AddForm addForm = new AddForm();
        addForm.searchItem();
        addForm.submitButton();
        logger.step(3);
        addForm.testingAdd(inquiry);


    }


}
