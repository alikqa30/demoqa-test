package demoQa.examplePageObject;


import org.junit.jupiter.api.Test;

import java.io.File;

public class successfullyRegistrationsWithPageObjectsTest extends testBase {

    @Test
    void fieldAutomationPracticeForm()  {
        File file = new File("C:/Users/alikb/OneDrive/Рабочий стол/правила НИ/тауантинсуй");

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(userEmail)
                        .setGender("Male")
                        .setPhone(userNumber)
                        .setBirthDate("04", "September", "1993")
                        .setSubjects("Economics")
                        .setHobbies("Music")
                        .setCurrentAddress(currentAddress);

        registrationPage.fileDownload(file)

                        .setStateAndCity("NCR", "Delhi")

                        .clickOnSubmit();

        // Test pop-up
        registrationPage.verifyResultModuleAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "04 September,1993")

                        .closeLargeModal();
    }
}


