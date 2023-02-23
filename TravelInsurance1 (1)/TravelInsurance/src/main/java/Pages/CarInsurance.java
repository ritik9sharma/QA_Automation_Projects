package Pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import Base.Base;

public class CarInsurance extends Base{
	
	By car=By.xpath("/html/body/main/div[2]/section/div[4]/a/div[1]/p");
	By proceed=By.xpath("//a[@class=\"btn-proceed\"]");
	By no=By.xpath("//*[@id=\"searchInput\"]/div/input");
	By select=By.id("react-autowhatever-1");
	By comp=By.xpath("//input[@placeholder='Search car brand']");
	By fuel=By.id("Diesel");
	By variant=By.xpath("//*[text()='CRDI (1493 cc)']");
	By year=By.xpath("//*[text()='2018']");
	By name=By.id("name");
	By email=By.id("email");
	By phone=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/label");
	By view=By.xpath("//*[@id=\"btnLeadDetails\"]/span");
	By error1=By.xpath("//div[@class='msg-error show']");
	By error2=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[1]");
	
	
	public void car() throws InterruptedException {
		
		exttest = report.createTest("To Display Error Messages in Car Insurance");
	
		driver.findElement(car).click();
		driver.findElement(proceed).click();
		driver.findElement(no).sendKeys("MH12");
		wait(20, select);
		driver.findElement(select).click();
		driver.findElement(comp).sendKeys("accent");
		wait(20, select);
		driver.findElement(select).click();
		Thread.sleep(1000);
		driver.findElement(fuel).click();
		driver.findElement(variant).click();
		driver.findElement(year).click();
		exttest.log(Status.PASS, "Items are being Selected");
		driver.findElement(name).sendKeys("Prafull");
		driver.findElement(email).sendKeys("prafull@gmail");
		exttest.log(Status.PASS, "Car Insurance Details Provided Sucessfully");
		System.out.println("********************************************");
		System.out.println("Car Insurance: \nThe Error Message is: ");
		System.out.println("********************************************");
		System.out.println(driver.findElement(error1).getText());
		driver.findElement(view).click();
		System.out.println(driver.findElement(error2).getText());
		exttest.log(Status.PASS, "Errors are obtained");
		exttest.log(Status.PASS, "Screenshot Captured Successfully");
		Thread.sleep(1000);
	}
}
