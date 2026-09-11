package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
public WebDriver driver;

public LoginPage(WebDriver driver) {
	super(driver);
}

@FindBy (xpath = "//input[@id='input-email']")
WebElement emailId;

@FindBy (xpath = "//input[@name='password']")
WebElement password;

@FindBy(xpath = "//input[@type='submit']")
WebElement login;

public void setEmail(String email) {
	emailId.sendKeys(email);
}

public void setpassword(String pwd) {
	password.sendKeys(pwd);
}

public void clickLogin() {
	login.click();
}
}
