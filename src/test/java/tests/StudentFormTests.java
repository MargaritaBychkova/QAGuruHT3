package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

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

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //Selenide.zoom(0.75);
        //Selenide.executeJavaScript(
              //  "document.querySelector(\"footer\").hidden = 'true';" +
                 //       "document.querySelector(\"#fixedban\").hidden = 'true'");

        String firstname = "Jane";
        String lastname = "Dow";
        String useremail = "Jane@dow.com";
        String gender = "Female";
        String usermobile = "7999333344";
        String dateofbirth = "07 March,1990";
        String subject = "Maths";
        String hobby = "Music";
        String currenraddress = "Somestreet 123";
        String state = "Uttar Pradesh";
        String city = "Agra";



        //Fill the form

        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(useremail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(usermobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();

        //("#dateOfBirthInput").sendKeys((Keys.CONTROL + "a"));
       //$("#dateOfBirthInput").sendKeys((Keys.SPACE));
        //$("#dateOfBirthInput").setValue(dateofbirth).pressEnter();


        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue(currenraddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
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
                text(hobby),
                text("img.png"),
                text(currenraddress),
                text(state + " " + city));



    }
}
