package configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import pageobject.AuthorizationPage;
import pageobject.HomePage;
import pageobject.ProjectPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public AuthorizationPage authorizationPage;
    public HomePage homePage;
    public ProjectPage projectPage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://localhost:4200";
        Configuration.headless = true;
        open("/");
        getWebDriver().manage().window().fullscreen();
        homePage = new HomePage();
        authorizationPage = new AuthorizationPage();
        projectPage = new ProjectPage();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }

}
