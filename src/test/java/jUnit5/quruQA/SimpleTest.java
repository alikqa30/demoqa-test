package jUnit5.quruQA;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleTest {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://www.google.com");
    }

//    @CsvSource({
//            "Allure testops, https://gameta.io",
//            "Selenide, https://selenide.org"
//    })

    @CsvFileSource(resources = "/testdata.csv")

    @ParameterizedTest(name = "Параметризованный тест для проверки выдачи в {1} по {0}")
    @Tags({@Tag("Blocker"), @Tag("UI_TEST")})
    void productSiteUrlShouldBePresentInResultOfSearchInGoogleBySelenideQuery(String productName, String productUrl) {

        $("[name=q]").setValue(productName).pressEnter();
        $("[id=search]").shouldHave(Condition.text(productUrl));

    }

}
