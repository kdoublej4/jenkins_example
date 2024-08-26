package pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        String formattedDay = day.length() < 2 ? "0" + day : day;

        $x("//select[@class='react-datepicker__month-select']").selectOption(month);
        $x("//select[@class='react-datepicker__year-select']").selectOption(year);
        $x("//div[contains(@class, 'react-datepicker__day--0"+ formattedDay
                + "') and not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
    }
}
