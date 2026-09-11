package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//h2[contains(.,'My Account')]")
	WebElement msgHeading ;
	
	@FindBy (xpath="(.//a[contains(.,'Logout')])[2]")
	WebElement logout;
	
	public boolean isMyAccountPageExist() {
		try {
		return msgHeading.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	public void clickOnLogout() {
		logout.click();
	}
}
