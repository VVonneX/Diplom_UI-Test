package test;

import com.codeborne.selenide.Configuration;
import configuration.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.AuthorizationPage;
import pageobject.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BaseTest {
    @Test
    public void authorizationAdmin() {
        homePage.clickButtonEnter();
        authorizationPage.setDataAndAuthorizations("admin", "1234");
        boolean username = projectPage.checkUsername("admin");
        Assert.assertTrue(username);
    }

    @Test
    public void authorizationUser() {
        homePage.clickButtonEnter();
        authorizationPage.setDataAndAuthorizations("user", "1234");
        boolean username = projectPage.checkUsername("user");
        Assert.assertTrue(username);
    }


}
