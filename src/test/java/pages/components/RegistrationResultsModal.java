package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $x("//div[@class='modal-content']").should(appear);
        $x("//div[@class='modal-title h4']").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}
