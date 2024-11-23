package task12;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static task12.DriverProvider.driver;

public class Task12Test {

    @BeforeMethod
    public void setUp() {
        DriverProvider.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverProvider.quitDriver();
    }

    @Test
    void addRowTest() {

        String name = "Vitalik";
        String email = "bodnar.vietal@gmail.com";
        String currentAddress = "Lviv";
        String permanentAddress = "London";

        // Step 1: Go to text-box page
        new Task12BO()
                .goToTextBoxPage()
                .fillUpText(name, email, currentAddress, permanentAddress)
                .tapSubmitBtn()
                .verifyTable(name, email, currentAddress, permanentAddress);
    }
}
