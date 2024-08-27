package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class RegistrationPage {
    private Random random = new Random();
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    ElementsCollection genderOptions = $$x("//label[@class='custom-control-label']"),
            hobbiesOptions = $$x("//label[@class='custom-control-label']");
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            dateOfBirth = $x("//input[@id='dateOfBirthInput']"),
            setSubject = $x("//input[@id='subjectsInput']"),
            setPicture = $x("//input[@id='uploadPicture']"),
            currentAddress = $x("//textarea[@id='currentAddress']"),
            state = $x("//div[@id='state']"),
            city = $x("//div[@id='city']"),
            submitBth = $x("//button[@id='submit']");


    @Step("Open page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $x("//h1[@class='text-center']/following-sibling::*").shouldHave(text(TITLE_TEXT));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Input firstname")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Input lastname")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Input email")
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Set gender")
    public RegistrationPage setGender(String gender) {
        genderOptions.findBy(text(gender)).click();
        return this;
    }
    @Step("Input phone number")
    public RegistrationPage setNumber(String number) {
        numberInput.setValue(number);
        return this;
    }
    @Step("Input birth date")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Set subject")
    public RegistrationPage setSubjects(String subject) {
        setSubject.setValue(subject).pressEnter();
        return this;
    }
    @Step("Set hobby")
    public RegistrationPage setHobbies(String hobbie) {
        hobbiesOptions.findBy(text(hobbie)).click();
        return this;
    }
    @Step("Upload picture")
    public RegistrationPage uploadPicture(String path) {
        setPicture.uploadFromClasspath(path);
        return this;
    }
    @Step("Input current address")
    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }
    @Step("Set state")
    public RegistrationPage setState() {
        state.click();
        ElementsCollection states = $$x("//div[@class=' css-11unzgr']/div");
        states.get(new Random().nextInt(states.size())).click();
        return this;
    }
    @Step("Set city")
    public RegistrationPage setCity() {
        city.click();
        ElementsCollection cities = $$x("//div[@class=' css-11unzgr']/div");
        cities.get(new Random().nextInt(cities.size())).click();
        return this;
    }
    @Step("Press submit button")
    public RegistrationPage pressSubmit() {
        submitBth.click();
        return this;
    }
    @Step("Verify modal appears")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
    @Step("Verify input data")
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
