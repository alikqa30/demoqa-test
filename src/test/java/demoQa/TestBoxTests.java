package demoQa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class TestBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
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
        $("#output").shouldBe(visible);

        String displayedText = $("#output").getText();
        assertThat(displayedText).contains("Sloyan Alik", "234@gmail.com", "Russia,Moscow", "Russia,Moscow");
    }
}
