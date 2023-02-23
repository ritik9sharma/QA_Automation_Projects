package Pages;

//import java.io.File;
//import java.io.FileOutputStream;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.Base;

public class HealthInsurances extends Base {
	By list = By.xpath("/html/body/section[2]/div/div/div/div/ul[3]/li");

	public void list() throws InterruptedException {
		

		exttest = report.createTest("To Display the Health Insurance Menu list");

		System.out.println("*****************************************************");
		System.out.println("        The Health Isurance Menu Items are: ");
		System.out.println("*****************************************************");
		List<WebElement> insuranceList = driver.findElements(list);
		Thread.sleep(2000);
		for (int j = 1; j < insuranceList.size(); ++j) {
			System.out.println(insuranceList.get(j).getText());
		}
		exttest.log(Status.PASS, "Health Insurance Menu List is obtained");
		
		exttest.log(Status.PASS, "All Test case passed Successfully!");
		Thread.sleep(1000);
		
		
       }

}
