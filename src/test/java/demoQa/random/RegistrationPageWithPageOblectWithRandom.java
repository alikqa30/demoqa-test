package demoQa.random;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demoQa.examplePageObject.pages.components.CalendarComponent;
import demoQa.examplePageObject.pages.components.FileUploadComponent;
import demoQa.examplePageObject.pages.components.RegistrationModulResult;
import demoQa.examplePageObject.pages.components.SubmitComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageWithPageOblectWithRandom {
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

    public RegistrationPageWithPageOblectWithRandom openPage() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$(\"#fixedban\").remove");
        $(".text-center").shouldHave(text(TITLE_PAGE));

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setGender(String value) {
        $("#gender-radio-1").parent().$(byText(value)).click();

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate( day,  month, year);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setSubjects(String value) {
        $("#subjectsInput").setValue((value)).pressEnter();

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setHobbies(String value) {
        $("label[for = hobbies-checkbox-3]").parent().$(byText(value)).click();

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom fileDownload(File file) {
        fileUploadComponent.pictureToDownload(file);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setCurrentAddress(String value) {
        $("#currentAddress").scrollTo().setValue(value);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom setStateAndCity (String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom clickOnSubmit() {
        $("#submit").click();

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom verifyResultModuleAppears() {
        registrationModulResult.verifyModuleAppears();

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom verifyResult(String key, String value) {
        registrationModulResult.verifyResult(key, value);

        return this;
    }
    public RegistrationPageWithPageOblectWithRandom closeLargeModal() {
        $("#closeLargeModal").click();

        return this;
    }
}

