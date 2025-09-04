package demoQa.examplePageObject.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubmitComponent {
    public void submitClick() {
        $("#submit").click();
    }

    public void submitOfcloseLargeModal() {
        $("#closeLargeModal").click();
    }
}
