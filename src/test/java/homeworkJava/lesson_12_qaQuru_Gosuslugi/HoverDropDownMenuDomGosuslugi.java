package homeworkJava.lesson_12_qaQuru_Gosuslugi;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HoverDropDownMenuDomGosuslugi {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://dom.gosuslugi.ru/#!/main";
        Configuration.holdBrowserOpen = true;
    }

    static Stream<Arguments> hoverMenuTestsData() {
        return Stream.of(
                Arguments.of(
                        0,
                        "Обучающие материалы",
                        List.of(
                                "Учебники",
                                "Видео ГИС ЖКХ")),
                        Arguments.of(
                        1,
                        "Программы в сфере ЖКХ и Горсреды",
                        List.of(
                                "Реестр программ в сфере ЖКХ",
                                "Реестр программ капитального ремонта",
                                "Федеральный проект «Формирование комфортной городской среды"
                        )
                )

        );
    }
    @MethodSource("hoverMenuTestsData")
    @ParameterizedTest(name = "Для меню {1} отображается {2}")
    @Tags({@Tag("UI"), @Tag("jUnit"), @Tag("Priority high")})

    void hoverMenuTestsData(int menuIndex, String parentMenu, List<String> childrenMenu) {
        open("/eServices");
// 1
        SelenideElement item1 =  $$(".app-nav-main ul.navbar-public-menu > li > a.main-page-link").
                findBy(exactText(parentMenu)).
                shouldBe(visible,enabled).hover();

        SelenideElement dropdown = item1.parent().$(".dropdown-menu").shouldBe(visible,enabled);

        for (String child : childrenMenu){
            dropdown.$$("li > a.main-page-link").findBy(exactText(child))
                    .shouldBe(visible, enabled);
        }
    }
}
