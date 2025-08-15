package demoQa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.io.File;
import java.text.ParseException;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;
import static org.assertj.core.api.InstanceOfAssertFactories.DURATION;


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

    @Test
    void fieldAutomationPracticeForm() throws ParseException {
        String firstName = "Alik";
        String lastName = "Sloyan";
        String userEmail = "alik@gmail.com";
        String userNumber = "9991234567";
        String subjectsInput = "Subjects";
        File file = new File("C:/Users/alikb/OneDrive/Рабочий стол/правила НИ/Mars dice game");
//        String dateOfBirthInput = null;
////        try {
////            dateOfBirthInput = "04.09.1993";
////            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
////            Date str = formatter.parse(dateOfBirthInput);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }


        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        //Added user first and last name
        $("#userName-label").shouldHave(text("Name"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //Added user email
        $("#userEmail-label").shouldHave(text("Email"));
        $("#userEmail").setValue(userEmail);

        //Choose gender
        //$x("//div[*[@id=genterWrapper and text() = 'Gender']]/div[1]").shouldBe(visible);
        $("label[for='gender-radio-1']").click();
        $("input#gender-radio-1").shouldHave(Condition.attribute("value",
                "Male"));

        ////Added user phone
        $("#userNumber-label").shouldHave(text("Mobile"));
        $("#userNumber").setValue(userNumber);

        //Added birth date
        $("#dateOfBirth-label").shouldHave(text("Date of Birth"));
//        $("input#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("#dateOfBirthInput").click();
        // Choose year
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__year-select").click();
        // Choose month
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__month-select").click();
        // Choose day
        $(".react-datepicker__day--009").click();

        // Added subjects
        $x("//label[@id='subjects-label' and text()='Subjects']").shouldBe(visible);
        $("#subjectsInput").setValue(subjectsInput);

        // Choose hobby
        $("label[for = hobbies-checkbox-1]").click();
        $("label[for = 'hobbies-checkbox-1'").shouldHave(text("Sports"));

        // Loaded file
        $x("//label[@id='subjects-label' and text()='Picture']").shouldBe(visible);
        $("#uploadPicture").uploadFile(file);

        // Added Current Address
        $x("//label[@id='currentAddress-label' and text()='Current Address']").shouldBe(visible);
        $("#currentAddress").pressEnter();
        $("#currentAddress").scrollTo().setValue("Russia");

        // Added State and City
        $("#state").click();
        $("#react-select-3-option-0").click();

        // Click submit
        $("#submit").click();

        // Test pop-up
        $(".table ").should(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").click();


    }
}

