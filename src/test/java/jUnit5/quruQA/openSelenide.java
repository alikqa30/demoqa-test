package jUnit5.quruQA;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class openSelenide {

    @BeforeEach
    void setUp(){
        Configuration.holdBrowserOpen = true;
    }

    static Stream<Arguments> selenideSiteShouldAllOfButtonForRuAnaEng() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of(
                        "Quick start","Docs","FAQ","Blog","Javadoc","Users","Quotes"
                )),
                Arguments.of(Locale.RU, List.of(
                        "С чего начать?", "Док","ЧАВО","Блог","Javadoc","Пользователи","Отзывы"
                ))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображается {1}")
    @Tag("Blocker")
    void selenideSiteShouldAllOfButtonForRuAnaEng( Locale locale, List<String> buttons){
        open("https://ru.selenide.org/");
        $$("#languages a").find(Condition.text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible).shouldHave(texts(buttons));

    }
}
