package demoQa.examplePageObject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import demoQa.examplePageObject.pages.RegistrationPage;
import demoQa.helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Locale;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static java.util.List.of;

public class testBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем браузер и после завершения теста не закрываем его", () -> {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.holdBrowserOpen = true;
            Configuration.timeout = 5000;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("selenoide:options", Map.<String, Object>of(
                    "enableVNC", "true",
                    "enableVideo", "true"
            ));
            Configuration.browserCapabilities = capabilities;
        });
    }

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress(lastName + (faker.number().numberBetween(123, 678)));
    public String userGender = getRandomValue("Male", "Female", "Other");
    public int userNumber = faker.number().numberBetween(1234567890, 987654321);
    //birth
    public String month = getRandomValue("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    public int year = faker.number().numberBetween(1900,2007);
    public String day = setRandomDay() + "";
    public String userSubjects = getRandomValue("Mathematics", "Art", "History", "Music", "Geography", "Physics");
    public String userHobbies = getRandomValue("Sports", "Reading", "Music");
    // png
    public String currentAddress = faker.address().fullAddress();
    public String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String userCity = getStateAndCity();

    public String getRandomValue(String ...values) {
        return faker.options().option(values);
    }

    public boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String setRandomDay() {
        int maxDay;
        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                maxDay = 31;
                break;

            case "April":
            case "June":
            case "September":
            case "November":
                maxDay = 30;
                break;

            case "February":
                if (isLeapYear(year)) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
                break;
            default:
            maxDay = 30;
        }
        int dayNum = faker.number().numberBetween(1, maxDay + 1);
        return (dayNum < 10 ? "0" : "") + dayNum;
    }


    public String getStateAndCity() {
        String stateAndCity = null;

        if (userState.equals("NCR")){
            stateAndCity = getRandomValue("Delhi","Gurgaon","Noida");
        }
         if (userState.equals("Uttar Pradesh")){
             stateAndCity = getRandomValue("Agra","Lucknow","Merrut");
         }
         if (userState.equals("Haryana")){
             stateAndCity = getRandomValue("Karnal","Panipat");
         }
         if (userState.equals("Rajasthan")){
             stateAndCity = getRandomValue("Jaipur","Jaiselmer");
         }
         return stateAndCity;
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screen shot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.attachAsText("Test", "test");
        Attach.addVideo();
    }
}
