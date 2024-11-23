package task10;

//Версія 129.0.6668.101

//1. Set up ChromeDriver using the driver file and properties.
//2. Set up ChromeDriver using DriverManager.
//3. Navigate to the page assigned to your variant.
//4. Select any three different elements.
//5. Interact with all the selected elements.
//6. Verify the visibility of each element using assertions.
//7. Wrap all these steps into a TestNG test case.
//V1. https://demoqa.com (text-box)

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task10TestManager {
    WebDriver driver;
    @BeforeTest
    void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void task10Test() throws InterruptedException {
        System.out.println("TestManager");
        driver.get("https://demoqa.com/elements");

        WebElement textBoxMenuItem = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
        textBoxMenuItem.click();

        WebElement textBoxName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        Assert.assertTrue(textBoxName.isDisplayed(), "Text Box Name is not visible.");
        textBoxName.sendKeys("some text");

        Thread.sleep(2000);

        WebElement btnSubmit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        Assert.assertTrue(btnSubmit.isDisplayed(), "Submit button is not visible.");
        btnSubmit.click();

    }

    @AfterTest
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}