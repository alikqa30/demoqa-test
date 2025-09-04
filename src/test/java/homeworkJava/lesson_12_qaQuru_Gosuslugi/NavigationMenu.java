package homeworkJava.lesson_12_qaQuru_Gosuslugi;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.*;

public class NavigationMenu {

    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://dom.gosuslugi.ru/#!/main";
        Configuration.holdBrowserOpen = true;
    }

    @CsvFileSource(resources = "/dom.csv")
    @ParameterizedTest(name = "Параметризованный тест для проверки выдачи в {1} по {0}")
    @Tags({@Tag("Blocker"), @Tag("High")})

    void testItemOnPage(String itemName, String itemUrl) {
        open("/eServices");
        $(".navbar-collapse ul").shouldHave(Condition.text(itemName));
    }

}