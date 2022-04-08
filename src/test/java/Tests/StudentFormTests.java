package Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
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
        String subject = "Maths";
        String currenraddress = "Somestreet 123";

        open("/automation-practice-form");

        //Fill the form

        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(useremail);
        $("#gender-radio-2").closest("div").click();
        $("#userNumber").setValue(usermobile);
        $("#dateOfBirthInput").sendKeys((Keys.CONTROL + "a"));
        $("#dateOfBirthInput").sendKeys((Keys.SPACE));
        $("#dateOfBirthInput").setValue(dateofbirth).pressEnter();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbies-checkbox-2").closest("div").click();
        $("#hobbies-checkbox-3").closest("div").click();
        $("#currentAddress").setValue(currenraddress);
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#close-fixedban").click();
        $("#submit").scrollIntoView("false").click();

        //Asserts










    }
}
