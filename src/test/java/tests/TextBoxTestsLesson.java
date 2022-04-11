package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestsLesson {

    @BeforeAll
    static void SetUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String name = "Mary Smith"; // to do make with other test data
        String email = "Mary@Smith.org";
        String currentAddress = "Some street 1";
        String permanentAddress = "Another street 2";


        open("/text-box");

        $("[id=userName]").setValue("Mary Smith");
        $("[id=userEmail]").setValue("Mary@Smith.org");
        $("[id=currentAddress]").setValue("Some street 1");
        $("[id=permanentAddress]").setValue("Another street 2");
        $("[id=submit]").click();

        //Asserts
        $("[id=output]").shouldHave(text(name), text(email), text(currentAddress), text(permanentAddress) );
        $("[id=output] [id = name]").shouldHave(text(name));
        $("[id=output] [id = email]").shouldHave(text(email));
        $("[id=output] [id = currentAddress]").shouldHave(text(currentAddress));
        $("[id=output] [id = permanentAddress]").shouldHave(text(permanentAddress));


    }

}

