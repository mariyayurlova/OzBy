package tests;

import UI.forms.LoginForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Mariya on 25.04.2016.
 */
public class OzBySignTest extends BaseTest {


    private String login;
    private String password;
    private String name;

    @BeforeMethod
    @Parameters({"login", "password", "name"})
    public void readParams(String login, String password, String name) throws Throwable{
        this.login = login;
        this.password = password;
        this.name = name;
    }


    public void runTest()  {
        logger.step(1);
        LoginForm loginForm = new LoginForm();
        loginForm.signIn();
        loginForm.inputLogin(login);
        loginForm.inputPassword(password);
        loginForm.submitLogin();
        logger.step(2);
        loginForm.testingSignIn(name);
    }


}
