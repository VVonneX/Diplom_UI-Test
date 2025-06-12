package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private SelenideElement locatorButtonEnter = $x("//span[@class='min-button' and text()='Войти']");

    public void clickButtonEnter() {
        locatorButtonEnter.click();
    }
}