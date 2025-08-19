package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FileUploadComponent;
import pages.components.RegistrationModulResult;
import pages.components.SubmitComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationModulResult registrationModulResult = new RegistrationModulResult();
    FileUploadComponent fileUploadComponent = new FileUploadComponent();
    SubmitComponent submitComponent = new SubmitComponent();
    private final String TITLE_PAGE = "Practice Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$(\"#fixedban\").remove");
        $(".text-center").shouldHave(text(TITLE_PAGE));

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        $("#gender-radio-1").parent().$(byText(value)).click();

        return this;
    }
    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate( day,  month, year);

        return this;
    }
    public RegistrationPage setSubjects(String value) {
        $("#subjectsInput").setValue((value)).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value) {
        $("label[for = hobbies-checkbox-3]").parent().$(byText(value)).click();

        return this;
    }
    public RegistrationPage fileDownload(File file) {
        fileUploadComponent.pictureToDownload(file);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        $("#currentAddress").scrollTo().setValue(value);

        return this;
    }
    public RegistrationPage setStateAndCity (String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }
    public RegistrationPage clickOnSubmit() {
        $("#submit").click();

        return this;
    }
    public RegistrationPage verifyResultModuleAppears() {
        registrationModulResult.verifyModuleAppears();

        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationModulResult.verifyResult(key, value);

        return this;
    }
    public RegistrationPage closeLargeModal() {
        $("#closeLargeModal").click();

        return this;
    }
}

