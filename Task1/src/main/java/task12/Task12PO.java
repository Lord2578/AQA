package task12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static task12.DriverProvider.getDriver;

public class Task12PO {

    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    private WebElement curAddressInput;

    @FindBy(xpath = "//*[@id=\"permanentAddress\"]")
    private WebElement permAddressInput;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submitBtn;

    public Task12PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public void setText(WebElement element, String text) {
        element.sendKeys(text);
        System.out.println("Встановлено текст: " + text);
    }

    public String getText(WebElement element) {
        String text = element.getText();
        System.out.println("Отримано текст: " + text);
        return text;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getCurAddressInput() {
        return curAddressInput;
    }

    public WebElement getPermAddressInput() {
        return permAddressInput;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }
}
