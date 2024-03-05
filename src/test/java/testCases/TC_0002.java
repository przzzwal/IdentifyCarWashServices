package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.FreeListingPage;
import testBase.baseClass;

public class TC_0002 extends baseClass{
	
	
	@Test(priority=1,groups= {"sanity","master"})
	public void launchFreeListing() throws InterruptedException, IOException {
		FreeListingPage fl=new FreeListingPage(driver);
		
		fl.LaunchFreeListing();
		logger.info("FreeListing is Launched.......");
		
		fl.enterWrongDetail();
		logger.info("Wrong detail is given in input box.......");
	}
	
	
	@Test(priority=2,groups= {"sanity","master"})
	public void clickStartNowBtn() throws InterruptedException, IOException {
		
		FreeListingPage fl=new FreeListingPage(driver);
		fl.clickStartNowBtn();
		logger.info("Start Now Button is clicked.......");
	}
	
	@Test(priority=3,groups= {"regression","master"})
	public void printInvalidMessage() throws InterruptedException, IOException {
		FreeListingPage fl=new FreeListingPage(driver);
		fl.printInvalidMsg();
		logger.info("Invalid Message is printed.......");
	}
	
	@Test(priority=4,groups= {"regression","master"})
	public void navigateBack() {
		FreeListingPage fl=new FreeListingPage(driver);
		fl.navigateBack();
		logger.info("Navigating Back to original Window.......");
	}

}
