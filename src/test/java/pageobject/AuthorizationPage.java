package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    private SelenideElement locatorInputLogin = $x("//input[@type='text']");
    private SelenideElement locatorInputPassword = $x("//input[@type='password']");
    private SelenideElement locatorButtonAuthorization = $x("//button/span[@class='min-button' and text()='Войти']");

    public void setDataAndAuthorizations(String login, String password) {
        locatorInputLogin.setValue(login);
        locatorInputPassword.setValue(password);
        locatorButtonAuthorization.click();
    }
}
