package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass
{	
	@Test(groups={"Regressing","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try {
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("Clicked on my Account Link ");
		
		hp.clickRegister();
		
		logger.info("Clicked on Register Link ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		regpage.setFirstName("Nikhil");
		regpage.setLastName("Nidhi");
		regpage.setEmail("nikhilnidhi5@gmail.com");
		regpage.setTelephone("9876543217");
		
		//String password = randomAlpaNumeric();
		
		String password = "123456";
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPivatePolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	 }
		catch(Exception e)
		{
			logger.info("Test Failed");
			logger.debug("Debug Logs");
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
}