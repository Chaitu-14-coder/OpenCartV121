package testCases;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;



public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void verify_Account_Registration() {
	 try {
		logger.info("******* Started TC001_AccountRegistrationTest ********");
		HomePage hp = new HomePage(driver);
		logger.info("Clicked on MyAcount Link");
		hp.clickMyAccount();
		logger.info("Clicked on Register Link");
		hp.clickRegister();
		
		AccountRegistrationPage repage=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		repage.setFirstName(randomString());
		repage.setLastName(randomString());
		repage.setEmail(randomString()+"@gmail.com");
		repage.settelephone(randomNumeric());
		
		String Password = randomAlphNumeric();
		repage.setPassword(Password);
		repage.setConfirmPassword(Password);
		repage.setPrivacyPolicy();
		repage.clickContiue();
		logger.info("Validating Expected Message");
		String confirmationMSg=repage.getConfirmationMessage();
		//Assert.assertEquals(confirmationMSg, "Your Account Has Been Created!");
		if(confirmationMSg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed.....");
			logger.debug("Debug Logs....");
			Assert.assertTrue(false);
		}
	}catch (Exception e) {		
		Assert.fail();		
	}
	 logger.info("******* Finished TC001_AccountRegistrationTest ********");
	
}
}
