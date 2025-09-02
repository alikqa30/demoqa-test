package demoQa.examplePageObject;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demoQa.examplePageObject.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class testBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress("en");
    String userNumber = faker.numerify("1234567890");
    String currentAddress = faker.address().fullAddress();

    //    public String file = faker.file().fileName("resources/", "test", "txt", null);
}
