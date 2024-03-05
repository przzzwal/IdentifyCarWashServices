package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.GymsSectionPage;
import testBase.baseClass;

public class TC_0003 extends baseClass{
	
	@Test(priority=1,groups= {"sanity","master"})
	public void clickGymSection() throws InterruptedException, IOException {
		
		GymsSectionPage gs=new GymsSectionPage(driver);
		gs.FindGym();
		logger.info("Type gyms in search box.......");
	}
	
	@Test(priority=2,groups={"regression","master"})
	public void printGymSubList() throws InterruptedException, IOException {
		GymsSectionPage gs=new GymsSectionPage(driver);
		
		gs.printGymSubList();
		logger.info("Sub-Menu of Gyms are Printed.......");

	}
	
	@Test(priority=3,groups= {"regression","master"})
	public void printSubMenuList() {
		GymsSectionPage gs=new GymsSectionPage(driver);
		gs.subMenuDetails();
		logger.info("Sub-Menu dropdown items list is printed.....");
		
	}

}
