package demoQa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import java.io.File;
import java.text.ParseException;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class successfullyRegistrationsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fieldAutomationPracticeForm()  {
        String firstName = "Alik";
        String lastName = "Sloyan";
        String userEmail = "alik@gmail.com";
        String userNumber = "9991234567";
        String subjectsInput = "Subjects";
        File file = new File("C:/Users/alikb/OneDrive/Рабочий стол/правила НИ/Mars dice game");

        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        //Added user first and last name
        $("#userName-label").shouldHave(text("Name"), Duration.ofSeconds(20));
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


