import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;



public class testGoogle {
    @Test
    void checkedGoogleUrl() {
        open("https://google.com");
    }
}
