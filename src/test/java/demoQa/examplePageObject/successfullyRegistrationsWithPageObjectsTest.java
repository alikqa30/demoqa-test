package demoQa.examplePageObject;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.sleep;

public class successfullyRegistrationsWithPageObjectsTest extends testBase {

    @Test
    void fieldAutomationPracticeForm()  {
        SelenideLogger.addListener("allure", new AllureSelenide());
        File file = new File("C:/Users/alikb/OneDrive/Рабочий стол/правила НИ/тауантинсуй");

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(userEmail)
                        .setGender(userGender)
                        .setPhone(String.valueOf(userNumber))
                        .setBirthDate(day, month, String.valueOf(year));

        registrationPage.setSubjects(userSubjects);

        sleep(1000);

//        registrationPage.setHobbies(userHobbies);

        registrationPage.setCurrentAddress(currentAddress);

        registrationPage.fileDownload(file)

                        .setState(userState)
                        .setCity(userCity)

                        .clickOnSubmit();

        // Test pop-up
        registrationPage.verifyResultModuleAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", String.valueOf(userNumber))
                .verifyResult("Date of Birth", day + " " + month + "," +year)
                .verifyResult("Subjects", userSubjects)
//                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", userState + " " + userCity)

                        .closeLargeModal();
    }
}


