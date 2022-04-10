package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        String gender = "Female";
        String usermobile = "7999333344";
        String dateofbirth = "07 March,1990";
        String subject = "Maths";
        String hobbies = "Reading, Music";
        String currenraddress = "Somestreet 123";
        String state = "Uttar Pradesh";
        String city = "Agra";

        open("/automation-practice-form");
        Selenide.zoom(0.75);
        Selenide.executeJavaScript(
                "document.querySelector(\"footer\").hidden = 'true';" +
                        "document.querySelector(\"#fixedban\").hidden = 'true'");

        //Fill the form

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
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue(currenraddress);
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").scrollIntoView("false").click();

        //Asserts

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("div.table-responsive").shouldHave(
                text(firstname + " " + lastname),
                text(useremail),
                text(gender),
                text(usermobile),
                text(dateofbirth),
                text(subject),
                text(hobbies),
                text("img.png"),
                text(currenraddress),
                text(state + " " + city));



    }
}
