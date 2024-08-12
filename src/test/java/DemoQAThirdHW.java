import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class DemoQAThirdHW {

    @BeforeAll
    static void BeforeAll() {
        Configuration.timeout =5000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    String name = "Danila";
    String lastName = "Bogrov";
    String fullName = name + " " + lastName;
    String mail = "mailq@mail.com";
    String numaber = "1390846575";
    String fileName = "ScreenshotHW1.png";
    String address = "ulitsa Pushkina, dom Kolotoshkina";



    @Test
    void allFormCompleteTest() {
        open("https://demoqa.com/automation-practice-form");

        $("input[id=firstName]").setValue(name);
        $("input[id=lastName]").setValue(lastName);
        $("input[id=userEmail]").setValue(mail);

        $("div#genterWrapper").$(byText("Other")).click();
        $("input[id=userNumber]").setValue(numaber);

        $("input[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__month").$(byText("16")).click();

        $("#subjectsInput").setValue("b");
        $("#react-select-2-option-0").click();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath(fileName);

        $("#currentAddress").setValue(address);

        $("#state").scrollIntoView(true).click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        executeJavaScript("document.querySelector('#fixedban').style.display='none';");
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name" +" "+ fullName));
        $(".table-responsive").shouldHave(text("Student Email" +" "+ mail));
        $(".table-responsive").shouldHave(text("Gender Other"));
        $(".table-responsive").shouldHave(text("Mobile" +" "+ numaber));
        $(".table-responsive").shouldHave(text("Date of Birth 16 May,1990"));
        $(".table-responsive").shouldHave(text("Subjects Biology"));
        $(".table-responsive").shouldHave(text("Gender Other"));
        $(".table-responsive").shouldHave(text("Hobbies Reading"));
        $(".table-responsive").shouldHave(text("Picture" +" "+ fileName));
        $(".table-responsive").shouldHave(text("Address" +" "+ address));
        $(".table-responsive").shouldHave(text("State and City Uttar Pradesh Lucknow"));

    }
}
