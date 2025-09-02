package homeworkJava.lesson12_qaGuru_Avisales;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class UiTest extends BaseTest{

    @Test
    void navMenu() {
        beforeTheTestFirstRun.hotelSearchFilter();
    }
}
