package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;

public class GymsSectionPage extends BasePage{

	public GymsSectionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[text()='Gym']")
	WebElement click_Gym;
	
	@FindBy(xpath="//ul[@id=\"filter_ul\"]/li")
	List<WebElement> SubList;
	
	@FindBy(xpath="//*[@class = 'jsx-6ab5af3a8693e5db animlabel']")
	public List<WebElement> dropDown;
	
	
	public void FindGym() throws InterruptedException {
		click_Gym.click();
		Thread.sleep(3000);
	}

	public void printGymSubList() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Sub-Menu items Of Gyms are: ");
		for(WebElement list:SubList) {
			System.out.println(list.getText());
			
			}
		ExcelUtils.writeGymSubList(SubList);
		Thread.sleep(2000);
	}
	
	public void subMenuDetails() {
		for (int i = 0; i < SubList.size(); i++) {
            String Text = SubList.get(i).getText();
            if (Text.contains("Sort")) {
            	System.out.println("-------------Sort By Dropdown List----------");
            	SubList.get(i).click();
                for(int j =0; j<dropDown.size(); j++) {
                		String s = dropDown.get(j).getText();
                		System.out.println(s);
                }
            }
            if (Text.contains("Amenities")) {
            	System.out.println("-------------Amentities Dropdown List----------");
            	SubList.get(i).click();
                for(int j =0; j<dropDown.size(); j++) {
                		String s = dropDown.get(j).getText();
                		System.out.println(s);
                }
            }
            if (Text.contains("Ratings")) {
            	System.out.println("-------------Ratings Dropdown List----------");
            	SubList.get(i).click();
                for(int j =0; j<dropDown.size(); j++) {
                		String s = dropDown.get(j).getText();
                		System.out.println(s);
                }
            }
		}
	}

}
