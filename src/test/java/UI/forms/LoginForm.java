package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

/**
 * Created by Mariya on 25.04.2016.
 */
public class LoginForm extends BaseForm {
    Label lblSignIn = new Label(By.xpath("//div/ul/li/a[@class='top-panel__userbar__auth']"), "SignIn");
    private TextBox txtLogin = new TextBox(By.xpath("//div/input[@name='cl_email']"), "Login");
    private TextBox txtPassword = new TextBox(By.xpath("//div/input[@name='cl_psw']"), "Password");
    private Button btnSubmit = new Button(By.xpath("//div/form/button[@class='i-button i-button_full-width i-button_large i-button_primary i-popup__form-button']"), "Submit button");
    Label lblName = new Label (By.xpath("//div/ul/li/a/span/span[@class='top-panel__userbar__user__name__inner']"));

    /**
     * КОнструктор
     */

    public LoginForm() {
        super(By.className("top-panel__logo__item "), "Oz.by");
    }

    /**
     * Логин
     */

    public void signIn (){
        lblSignIn.click();
    }


    /**
     * Вводим логин
     * @param login логин
     */

    public void inputLogin(String login){
        txtLogin.type(login);
    }

    /**
     * Вводим пароль
     * @param password пароль
     */
    public void inputPassword(String password){
        txtPassword.type(password);
    }

    /**
     * Войти
     */
    public void submitLogin(){
        btnSubmit.clickAndWait("//button[@class='i-button i-button_full-width i-button_large i-button_primary i-popup__form-button']", "top-panel__logo" );
    }

    /**
     * Проверяем соответсвие логина
     * @param name имя
     */
    public void testingSignIn(String name){
        String nameThis = lblName.getText();
        info("Expected name: "+name);
        info("Received name: "+nameThis);
        if (name.equals(nameThis)){
            info("Successful ");
        }
        else {
            error("Entered the wrong data");
        }
    }


}
