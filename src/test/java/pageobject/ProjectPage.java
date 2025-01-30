package pageobject;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {

    private String locatorUser = "//div[@class='username' and text()='%s']";
    private SelenideElement locatorButtonCreateNote = $x("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']");
    private List<SelenideElement> locatorAllNote = $$x("//button[span[text()='Удалить']]");
    private String locatorNewNote = "(//button[span[text()='Удалить']])[%s]";
    private SelenideElement locatorDialogContainer = $("#mat-dialog-0");
    private SelenideElement locatorInputHeaderField = $("#mat-input-0");
    private SelenideElement locatorButtonSave = $x("//button/span[text()='Сохранить']");
    private String locatorHeaderNote = "//div[%s]/h3[text()='%s']";

    public boolean checkUsername(String user) {
        SelenideElement username = $x(String.format(locatorUser, user)).shouldBe(visible);
        return username.isDisplayed();
    }

    public void createNote() {
        locatorButtonCreateNote.click();
    }

    public boolean checkDisplayNote() {
        int numNewNote = locatorAllNote.size() - 1;
        SelenideElement newNote = $x(String.format(locatorNewNote, numNewNote));
        newNote.scrollTo();
        newNote.shouldBe(visible);
        return newNote.isDisplayed();
    }

    public boolean deleteAndCheckDisplayNote() {
        sleep(1000);
        int numNewNote = locatorAllNote.size() - 1;
        sleep(1000);
        SelenideElement newNote = $x(String.format(locatorNewNote, numNewNote));
        sleep(1000);
        newNote.scrollTo();
        sleep(1000);
        newNote.shouldBe(visible);
        sleep(2000);
        newNote.click();
        sleep(2000);
        return locatorDialogContainer.isDisplayed();
    }

    public String refactorAndReturnHeaderNameNote(Long numNote, String oldNameNote, String newNameNote) {
        SelenideElement headerName = $x(String.format(locatorHeaderNote, numNote, oldNameNote));
        headerName.click();
        locatorInputHeaderField.clear();
        locatorInputHeaderField.setValue(newNameNote);
        locatorButtonSave.click();
        int numNewNote = locatorAllNote.size();
        SelenideElement refactorNote = $x(String.format(locatorHeaderNote, numNewNote, newNameNote));
        refactorNote.scrollTo();
        refactorNote.shouldBe(visible);
        return refactorNote.getText();
    }
//*[@id="mat-dialog-0"]/app-create-edit/div/mat-dialog-actions/button[2]/span[1]
}
