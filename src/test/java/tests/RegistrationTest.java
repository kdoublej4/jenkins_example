package tests;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class RegistrationTest extends TestBase {
    @Test
    public void fillFormTest() throws InterruptedException {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = List.of("Male", "Female", "Other").get(new Random().nextInt(3));
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String[] dateOfBirth = {"21", "July", "1991"};
        String subject = List.of("Math", "Biol", "Phys", "Chem", "Hist", "Art").get(new Random().nextInt(6));
        String hobbie = List.of("Sports", "Reading", "Music").get(new Random().nextInt(3));
        String picturePath = "img/5fa68b7ae518654-upscaled.png";
        String currentAddress = faker.address().fullAddress();

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2])
                .setSubjects(subject)
                .setHobbies(hobbie)
                .uploadPicture(picturePath)
                .setCurrentAddress(currentAddress)
                .setState()
                .setCity()
                .pressSubmit()
                .takeScreenshot();

        formPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber);
    }
}
