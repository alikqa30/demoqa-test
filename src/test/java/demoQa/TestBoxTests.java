package demoQa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fieldFormTest() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        $("#userName").setValue("Sloyan Alik");
        $("#userEmail").setValue("1234@gmail.com");
        $("#currentAddress").setValue("Russia,Moscow");
        $("#permanentAddress").setValue("Russia,Moscow");
        $("#submit").click();
    }
}
