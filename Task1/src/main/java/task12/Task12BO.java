package task12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static task12.DriverProvider.getDriver;

public class Task12BO {
    private final Task12PO task12PO = new Task12PO();
    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public Task12BO goToTextBoxPage() {
        getDriver().get("https://demoqa.com/text-box");
        return this;
    }

    public Task12BO fillUpText(String name, String email, String currentAddress, String permanentAddress) {
        task12PO.setText(task12PO.getNameInput(), name);
        task12PO.setText(task12PO.getEmailInput(), email);
        task12PO.setText(task12PO.getCurAddressInput(), currentAddress);
        task12PO.setText(task12PO.getPermAddressInput(), permanentAddress);
        return this;
    }

    public Task12BO tapSubmitBtn() {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOf(task12PO.getSubmitBtn()));

        // Скрол до елемента посередині екрану
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center' });", submitButton);

        Assert.assertTrue(submitButton.isDisplayed(), "Can't find Submit button");
        submitButton.click();
        System.out.println("Натиснуто кнопку Submit");

        return this;
    }

    public void waitForText(By locator, String expectedText) {
        try {
            wait.until(driver -> {
                WebElement element = driver.findElement(locator);
                String actualText = element.getText().replaceAll("\\s+", "").trim(); // Видалення пробілів
                System.out.println("Знайдено текст: \"" + actualText + "\". Очікується: \"" + expectedText + "\".");
                return actualText.equals(expectedText);
            });
            System.out.println("Текст \"" + expectedText + "\" успішно знайдено.");
        } catch (TimeoutException e) {
            throw new AssertionError("Очікуваний текст \"" + expectedText + "\" не знайдено у вказаному елементі протягом очікуваного часу.", e);
        }
    }

    public void verifyTable(String name, String email, String currentAddress, String permanentAddress) {
        WebElement outputContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

        waitForText(By.xpath("//p[contains(text(),'Name:')]"), "Name:" + name); // Без пробілів
        waitForText(By.xpath("//p[contains(text(),'Email:')]"), "Email:" + email);
        waitForText(By.xpath("//p[contains(text(),'Current Address :')]"), "CurrentAddress:" + currentAddress);
        waitForText(By.xpath("//p[contains(text(),'Permananet Address :')]"), "PermananetAddress:" + permanentAddress);

        List<WebElement> rows = outputContainer.findElements(By.tagName("p"));

        String newName = rows.get(0).getText().replaceAll("\\s+", "").replace("Name:", "").trim();
        String newEmail = rows.get(1).getText().replaceAll("\\s+", "").replace("Email:", "").trim();
        String newCurrentAddress = rows.get(2).getText().replaceAll("\\s+", "").replace("CurrentAddress:", "").trim();
        String newPermanentAddress = rows.get(3).getText().replaceAll("\\s+", "").replace("PermananetAddress:", "").trim();

        Assert.assertEquals(newName, name, "Name does not match.");
        Assert.assertEquals(newEmail, email, "Email does not match.");
        Assert.assertEquals(newCurrentAddress, currentAddress, "Current address does not match.");
        Assert.assertEquals(newPermanentAddress, permanentAddress, "Permanent address does not match.");

        System.out.println("Усі значення успішно верифіковано.");
    }



}
