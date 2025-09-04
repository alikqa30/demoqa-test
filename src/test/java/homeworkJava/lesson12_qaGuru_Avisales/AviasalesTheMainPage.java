package homeworkJava.lesson12_qaGuru_Avisales;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AviasalesTheMainPage {
    public AviasalesTheMainPage hotelSearchFilter() {
        open("hotels");
        $("#hotel_autocomplete-input").click();
        $("#hotel_autocomplete-input").setValue("Дубай");
        $("#hotel_autocomplete-item-1").click();
        $("button[data-test-id='start-date-field']").click();

        ElementsCollection months = $$("select[data-test-id='select-month']");
        ElementsCollection days = $$("div[data-test-id^='date-']");

        months.get(0).selectOptionByValue("2025-10");
        days.findBy(Condition.exactText("10")).click();

        months.get(1).selectOptionByValue("2025-10");
        days.findBy(Condition.exactText("20")).click();

        $("button[data-test-id='dropdownButton']").click();

        ElementsCollection numbersOfAdults = $$("button[data-test-id='decrease-button']");
        ElementsCollection numbersOfKids = $$("button[data-test-id='increase-button']");

        numbersOfAdults.get(0).click();
        numbersOfKids.get(1).click();

        $("input[data-test-id='input']").click();

        ElementsCollection items = $$("div#downshift-0-menu ul li");
        SelenideElement item10 = items.get(11);
        item10.click();

        $("button[data-test-id='form-submit']").click();

        return this;
    }
}


