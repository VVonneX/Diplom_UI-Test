package pageobject;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

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

    public boolean deleteAndCheckDisplayNote() throws InterruptedException {
        int numNewNote = locatorAllNote.size() - 1;
        SelenideElement newNote = $x(String.format(locatorNewNote, numNewNote));
        newNote.scrollIntoView("{behavior: 'smooth', block: 'end'}")
                .shouldBe(visible, Duration.ofSeconds(10));
        newNote.shouldBe(interactable, Duration.ofSeconds(5))
                .click();
        Thread.sleep(3000);
        return newNote.shouldBe(visible, Duration.ofSeconds(5))
                .isDisplayed();
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
}
