package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
  WebDriver driver;
  
  public AccountRegistrationPage(WebDriver driver) {
	  super(driver);
  }
  
  @FindBy (xpath= "//input[@name='firstname']")
  WebElement txtFirstName;
  
  @FindBy (xpath = "//input[@name='lastname']")
  WebElement txtLastName;
  
  @FindBy (xpath="//input[@name='email']")
  WebElement txtEmail;
  
  @FindBy(xpath="//input[@name='telephone']")
  WebElement txttelephone;
  
  @FindBy(xpath="//input[@name='password']")
  WebElement txtPwd;
  
  @FindBy(xpath = "//input[@name='confirm']")
  WebElement txtConfirmPwd;
  
  @FindBy(xpath="//input[@name='agree']")
  WebElement chkPollicy;
  
  @FindBy(xpath = "//input[@type='submit']")
  WebElement buttonContiue; 
  
  @FindBy(xpath="//a[contains(text(),'Continue')]")
  WebElement confirmation;
  
  @FindBy(xpath="//h1[contains(.,'Your Account Has Been Created!')]")
  WebElement confirmationMsg;
  
  public void setFirstName(String fname) {
	  txtFirstName.sendKeys(fname);
  }
  public void setLastName(String lname) {
	  txtLastName.sendKeys(lname);
  }
  public void setEmail(String email) {
	  txtEmail.sendKeys(email);
  }
  public void settelephone(String tel) {
	  txttelephone.sendKeys(tel);
  }
  public void setPassword(String pwd) {
	  txtPwd.sendKeys(pwd);
  }
  public void setConfirmPassword(String pwd) {
	  txtConfirmPwd.sendKeys(pwd);
  }
  public void setPrivacyPolicy() {
	  chkPollicy.click();
  }
  public void clickContiue() {
	 buttonContiue.click();
  }
  
  public String getConfirmationMessage() {
	  try {
		  return (confirmationMsg.getText());
	  }catch (Exception e) {
		return (e.getMessage());
	}
  }
  
        
}
