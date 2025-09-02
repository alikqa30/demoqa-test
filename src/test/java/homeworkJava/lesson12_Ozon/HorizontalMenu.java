package homeworkJava.lesson12_Ozon;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HorizontalMenu {

    @BeforeAll
    static void beforeAll() {
        open("https://hh.ru/");
        Configuration.holdBrowserOpen = true;
    }
@Test
////    @CsvFileSource(resources = "/ozon.csv")
////    @ParameterizedTest(name = "Параметризованный тест для проверки выдачи {0}")
//    @Tags({@Tag("UI"), @Tag("Ozon menu")})
    void horizontalMenuOnMainPage() {
        $("input#a11y-search-input").click();
        $("input#a11y-search-input").setValue("qa");
    }
}
