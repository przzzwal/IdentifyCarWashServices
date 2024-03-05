package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.CarWashingServices;
import testBase.baseClass;

public class TC_0001 extends baseClass {
	
	
	@Test(priority=1,groups={"sanity","regression","master"})
	public void checkLocation() throws InterruptedException, IOException {
		
		CarWashingServices loc=new CarWashingServices(driver);
		loc.handlePopupWindow();
		logger.info("First Pop Up Handled.......");
		
		loc.enterLocation();
		logger.info("Near By Location is entered.......");
		
		loc.selectLocation();
		logger.info("Suggested location is selected.......");
		
	}
	@Test(priority=2,groups={"sanity", "master"})
	public void searchCarWashingSrvcs() throws InterruptedException {
		CarWashingServices cw=new CarWashingServices(driver);
		
		cw.enterCarWashServices();
		logger.info("Type Car Washing Services in search box.......");
		
		cw.selectButton();
		logger.info("Suggested Car Washing Services is selected.......");
		
		cw.clickSearchButton();
		logger.info("Clicked on search button and result appears.......");
	}
	
	@Test(priority=3,groups={"sanity","master"})
	public void applyFilters() throws InterruptedException, IOException {
			CarWashingServices cw=new CarWashingServices(driver);
			
			cw.clickAllFilters();
			logger.info("Clicked on All Filters Sub-Menu.......");
		
		    cw.clickRating();
		    logger.info("Click and Select rating 4.0+.......");
		
		    cw.clickApplyFilter();
		    logger.info("Click on Apply Filter Button.......");
		}
		
	@Test(priority=4,groups= {"sanity","master"})
	public void clickContactButton() throws InterruptedException, IOException {
			CarWashingServices cw=new CarWashingServices(driver);
		    cw.clickContactFlareBtn();
		    logger.info("Click on Show Number Flare Button to get contact of car washing services Dealer ");
		    
		    cw.handleLastPopupWindow();
		    logger.info("PopUp appeared and handled.......");
	}
	
	@Test(priority=5,groups= {"regression","master"})
	public void printCarWashingSrvcsDetails() throws IOException, InterruptedException {
		    CarWashingServices cw=new CarWashingServices(driver);
		    cw.printCarSrvcNames();
		    logger.info("Printing Details of Car Washing Services.......");
		}
		
	}
