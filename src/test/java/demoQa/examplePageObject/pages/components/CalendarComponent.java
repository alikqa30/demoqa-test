package demoQa.examplePageObject.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {

        // Choose year
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__year-select").click();
        // Choose month
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__month-select").click();
        // Choose day
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();

    }
}
