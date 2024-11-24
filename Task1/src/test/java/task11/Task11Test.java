package task11;

//1. Make up one simple UI end-to-end test case for your test page from Task_10
//2. Automate that scenario using WebDriver
//3. Create PageObject (use Business object if need)for all pages used in scenario

import com.automation.remarks.testng.UniversalVideoListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task14.AlureListener;

@Listeners({AlureListener.class, UniversalVideoListener.class})

public class Task11Test {
    @Test
    void addRowTest() {
        //Test Data
        String name = "Vitalik";
        String email = "bodnar.vietal@gmail.com";
        String currentAddress = "Lviv";
        String permanentAddress = "London";
        //Step 1: Go to text-box page
        new TextBoxTableBO().gototextboxpage()

                //Step 2: Fill up textboxes
                .fillUpText(name, email, currentAddress, permanentAddress)

                //Step 3: Tap on Submit button
                .tapSubmitBtn()

                //Step 4: Verify that your info appear under textboxes
                .verifyTable(name, email, currentAddress, permanentAddress);


    }

    @Test
    void addRowFailTest() {
        //Test Data
        String name = "Vitalik";
        String email = "bodnar.vietal@gmail.com";
        String currentAddress = "Lviv";
        String permanentAddress = "London";
        //Step 1: Go to text-box page
        new TextBoxTableBO().gototextboxpage()

                //Step 2: Fill up textboxes
                .fillUpText(name, email, currentAddress, permanentAddress)

                //Step 3: Tap on Submit button
                .tapSubmitBtn()

                //Step 4: Verify that your info appear under textboxes
                .verifyTable(name, email, currentAddress, permanentAddress);
        Assert.fail();


    }
}
