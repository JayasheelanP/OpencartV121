package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void Verify_Login()
	{
		logger.info("******Starting TC_002_LoginTest ******");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
	    boolean tragetPage=macc.isMyAccountPageExists();
	    
	    Assert.assertTrue(tragetPage); //Assert.assertEquals(tragetPage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	    logger.info("***** Finished TC_002_LoginTest****");
	}
	
}
