package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class , groups="Datadriven")
	 public void verify_Login(String email , String pwd , String exp) {
		 logger.info("**********Starting TC003_LoginDDT ***************");
		try {
		 HomePage hp=new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setpassword(p.getProperty("password"));
		 lp.clickLogin();
		 
		 MyAccountPage ap=new MyAccountPage(driver);
		 boolean targetPage=ap.isMyAccountPageExist();
		// assertEquals(targetPage, true , "Login Failed");
	if(exp.equalsIgnoreCase("valid")) {
		if(targetPage==true) {
			ap.clickOnLogout();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid")) {
		if(targetPage==true) {
			ap.clickOnLogout();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
		}catch (Exception e) {
			Assert.fail();
		}
	
		 
		 logger.info("**********Finished TC003_LoginDDT ***************");
	 }

}
