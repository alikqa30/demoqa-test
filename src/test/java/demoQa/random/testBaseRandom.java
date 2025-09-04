package demoQa.random;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class testBaseRandom {
    RegistrationPageWithPageOblectWithRandom registrationPageRandom = new RegistrationPageWithPageOblectWithRandom();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
}
