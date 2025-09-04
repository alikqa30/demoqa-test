package demoQa.random;

import java.io.File;

import static utils.RandomUtils.randomData;
import static utils.RandomUtils.randomEmail;

public class TestData {

    String firstName = randomData(10);
    String lastName = randomData(10);
    String userEmail = randomEmail();
    String userNumber = "9991234567";
    File file = new File("C:/Users/alikb/OneDrive/Рабочий стол/правила НИ/Mars dice game");

}
