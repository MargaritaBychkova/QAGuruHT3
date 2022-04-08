package Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class StudentFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        String firstname = "Jane";
        String lastname = "Dow";
        String useremail = "Jane@dow.com";
        String usermobile = "70800000000";
        String dateofbirth = "07 Mar 1990";
        String subject = "Marketing technologies";

        open("/automation-practice-form");

        //Fill the form
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(useremail);
        $("#gender-radio-2").closest("div").click();
        $("#userNumber").setValue(usermobile);
        $("#dateOfBirthInput").sendKeys((Keys.CONTROL + "a"));
        $("#dateOfBirthInput").sendKeys((Keys.SPACE));
        $("#dateOfBirthInput").setValue(dateofbirth).pressEnter();
        $("#subjectsInput").setValue(subject);
        $("#hobbies-checkbox-2").closest("div").click();
        $("#hobbies-checkbox-3").closest("div").click();



    }
}
