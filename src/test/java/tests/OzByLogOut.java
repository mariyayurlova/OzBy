package tests;

import UI.forms.LoginForm;
import UI.forms.MainForm;
import org.bouncycastle.crypto.io.MacInputStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Mariya on 26.04.2016.
 */
public class OzByLogOut extends BaseTest {
    private String login;
    private String password;

    @BeforeMethod
    @Parameters({"login", "password"})
    public void readParams(String login, String password) throws Throwable{
        this.login = login;
        this.password = password;
    }
    @Override
    public void runTest() throws Throwable {
        MainForm mainForm = new MainForm();
        logger.step(1);
        LoginForm loginForm = new LoginForm();
        loginForm.signIn();
        loginForm.inputLogin(login);
        loginForm.inputPassword(password);
        loginForm.submitLogin();
        logger.step(2);
        mainForm.clickLogOut();
        logger.step(3);
        mainForm.checkLogOut();
    }
}
