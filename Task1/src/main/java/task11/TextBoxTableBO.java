package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static task11.DriverProvider.driver;

public class TextBoxTableBO {
    TextBoxTablePO textBoxTablePO = new TextBoxTablePO();
    public TextBoxTableBO gototextboxpage() {
        DriverProvider.getDriver().get("https://demoqa.com/text-box");
        return this;
    }

    public TextBoxTableBO fillUpText(String name, String email, String currentAddress, String permanentAddress) {
        Assert.assertTrue(textBoxTablePO.getNameInput().isDisplayed(), "Cant find name input");
        textBoxTablePO.getNameInput().sendKeys(name);

        Assert.assertTrue(textBoxTablePO.getEmailInput().isDisplayed(), "Cant find email input");
        textBoxTablePO.getEmailInput().sendKeys(email);

        Assert.assertTrue(textBoxTablePO.getCurAddressInput().isDisplayed(), "Cant find current address input");
        textBoxTablePO.getCurAddressInput().sendKeys(currentAddress);

        Assert.assertTrue(textBoxTablePO.getPermAddressInput().isDisplayed(), "Cant find permanent address input");
        textBoxTablePO.getPermAddressInput().sendKeys(permanentAddress);

        return this;
    }


    public TextBoxTableBO tapSubmitBtn() throws InterruptedException {
        Assert.assertTrue(textBoxTablePO.tapSubmitBtn().isDisplayed(), "Cant find Submit button");
        Thread.sleep(4000);
        textBoxTablePO.tapSubmitBtn().click();
        return this;
    }

    public void verifyTable(String name, String email, String currentAddress, String permanentAddress) throws InterruptedException {
        Thread.sleep(4000);
        
        WebElement outputContainer = driver.findElement(By.id("output"));

        List<WebElement> rows = outputContainer.findElements(By.tagName("p"));

        String newName = rows.get(0).getText().replace("Name:", "").trim();
        String newEmail = rows.get(1).getText().replace("Email:", "").trim();
        String newCurrentAddress = rows.get(2).getText().replace("Current Address :", "").trim();
        String newPermanentAddress = rows.get(3).getText().replace("Permananet Address :", "").trim();


        Assert.assertEquals(newName, name, "Name does not match.");
        Assert.assertEquals(newEmail, email, "Email does not match.");
        Assert.assertEquals(newCurrentAddress, currentAddress, "Current address does not match.");
        Assert.assertEquals(newPermanentAddress, permanentAddress, "Permanent address does not match.");

        System.out.println("Усі значення відповідають введеним.");
    }
}
