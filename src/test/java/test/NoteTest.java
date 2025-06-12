package test;

import configuration.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class NoteTest extends BaseTest {

    @Test
    public void createNote() {
        homePage.clickButtonEnter();
        authorizationPage.setDataAndAuthorizations("admin", "1234");
        projectPage.createNote();
        boolean checkDisplay = projectPage.checkDisplayNote();
        Assert.assertTrue(checkDisplay);

    }

    @Test
    public void deleteNote() throws InterruptedException {
        homePage.clickButtonEnter();
        authorizationPage.setDataAndAuthorizations("admin", "1234");
        projectPage.createNote();
        boolean checkDisplay = projectPage.deleteAndCheckDisplayNote();
        Assert.assertTrue(checkDisplay);
    }

    @Test
    public void refactorNote() {
        homePage.clickButtonEnter();
        authorizationPage.setDataAndAuthorizations("admin", "1234");
        String nameNote = projectPage.refactorAndReturnHeaderNameNote(1L, "Заметка 1", "Измененная заметка");
        sleep(1000);
        Assert.assertEquals("Измененная заметка", nameNote);
    }
}
