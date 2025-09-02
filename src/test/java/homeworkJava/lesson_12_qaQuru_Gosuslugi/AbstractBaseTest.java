package homeworkJava.lesson_12_qaQuru_Gosuslugi;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;


public abstract class AbstractBaseTest {

    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://dom.gosuslugi.ru/#!/main";
        Configuration.holdBrowserOpen = true;
    }
}
