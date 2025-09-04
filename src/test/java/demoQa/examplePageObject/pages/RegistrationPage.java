package demoQa.examplePageObject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demoQa.examplePageObject.pages.components.CalendarComponent;
import demoQa.examplePageObject.pages.components.FileUploadComponent;
import demoQa.examplePageObject.pages.components.RegistrationModulResult;
import demoQa.examplePageObject.pages.components.SubmitComponent;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
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
            genderCheckBox = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
    //bd
            subjectInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
    //file
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            city = $("#city");

    @Step("Открываем форму регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$(\"#fixedban\").remove");
        $(".text-center").shouldHave(text(TITLE_PAGE));

        return this;
    }
    @Step("Устанавливаем имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Устанавливаем фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Устанавливаем электронную почту")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    @Step("Устанавливаем пол")
    public RegistrationPage setGender(String value) {
        genderCheckBox.parent().$(byText(value)).click();

        return this;
    }
    @Step("Устанавливаем телефон")
    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }
    @Step("Устанавливаем дату рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").shouldBe(visible,enabled).click();
        calendarComponent.setDate( day,  month, year);
        return this;
    }
    @Step("Устанавливаем предметы")
    public RegistrationPage setSubjects(String value) {
        $(".overlay, .loader").shouldBe(Condition.hidden);
        subjectInput.shouldBe(visible, enabled).setValue((value)).pressEnter();

        return this;
    }
    @Step("Устанавливаем хобби")
    public RegistrationPage setHobbies(String value) {
        $(".overlay, .loader").shouldBe(Condition.hidden);
        hobbiesCheckBox.$$("label.custom-control-label").findBy(Condition.text(value)).shouldBe(visible, enabled)
                .scrollTo().click();

        return this;
    }
    @Step("Загружаем файл")
    public RegistrationPage fileDownload(File file) {
        fileUploadComponent.pictureToDownload(file);

        return this;
    }
    @Step("Устанавливаем текущий адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.scrollTo().setValue(value);

        return this;
    }
    @Step("Устанавливаем Штат")
    public RegistrationPage setState(String value) {
        state.click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    @Step("Устанавливаем город")
    public RegistrationPage setCity (String value) {
        city.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }
    @Step("Нажимаем на кнопку")
    public RegistrationPage clickOnSubmit() {
        $("#submit").click();

        return this;
    }
    @Step("Верифицируем модальное окно")
    public RegistrationPage verifyResultModuleAppears() {
        registrationModulResult.verifyModuleAppears();

        return this;
    }
    @Step("Верифицируем данных в модальном окне с данными ввода")
    public RegistrationPage verifyResult(String key, String value) {
        registrationModulResult.verifyResult(key, value);

        return this;
    }
    @Step("Закрываем моадльное окно")
    public RegistrationPage closeLargeModal() {
        $("#closeLargeModal").click();

        return this;
    }
}

