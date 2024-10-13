package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static task11.DriverProvider.getDriver;

public class TextBoxTablePO {

    @FindBy(xpath = "//*[@id=\"userName\"]")
    WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    WebElement curAddressInput;

    @FindBy(xpath = "//*[@id=\"permanentAddress\"]")
    WebElement permAddressInput;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement submitBtn;

    public TextBoxTablePO() {
        PageFactory.initElements(getDriver(), this);
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

    public WebElement tapSubmitBtn() {
        return submitBtn;
    }
}
