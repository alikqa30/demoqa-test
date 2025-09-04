package homeworkJava.lesson12_qaGuru_Avisales;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    AviasalesTheMainPage beforeTheTestFirstRun = new AviasalesTheMainPage();

    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://www.aviasales.ru/";
        Configuration.holdBrowserOpen = true;
    }
}
