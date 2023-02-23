package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Base.Base;

public class TravelInsurance extends Base{
	
	By travel=By.xpath("//p[text()='Travel']");
	By search=By.id("country");
	By germany=By.xpath("//li[text()='Germany']");
	By nxt=By.xpath("//button[text()='Next']");
	By no=By.xpath("//label[text()='2']");
	By traveller0=By.xpath("(//*[@id='feet'])[1]");
	By traveller1=By.xpath("(//*[@id='feet'])[2]");
	By clik=By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input");
	By start=By.xpath("//button[@aria-label='Apr 30, 2022']");
	By end=By.xpath("//button[@aria-label='May 30, 2022']");
	
	
	By med=By.id("ped_no");
	By proceed=By.xpath("//button[text()='View plans']");
	By mobile=By.id("mobileNumber");
	
	By student=By.xpath("//label[@for='student-trip-desktop']");
	By stud_visa1=By.xpath("//label[text()='Traveller 1 (22 yrs)']");
	By stud_visa2=By.xpath("//label[text()='Traveller 2 (21 yrs)']");
	
	By days=By.xpath("//body//section//div//div//div//div//div//div//div//select");
	
	By apply=By.xpath("//body/section/div/div/div/div/button[1]");
	
	By sortby=By.xpath("//a[normalize-space()='Sort by']");
	
	By low=By.xpath("//label[normalize-space()='Premium low to high']");
	By comp=By.xpath("//div[@class='quotesCard__planName hideSmall']/p[@class='quotesCard--insurerName']");
	
	By price=By.xpath("//div[@class='quotesCard__cta']/p/span");
	
	public void travel() throws InterruptedException {
		
		exttest = report.createTest("To Show Student Travel Insurance Plan ");
		// click on travel insurance menu
		driver.findElement(travel).click();
		// search for country
		driver.findElement(search).sendKeys("Germany");
		wait(20, germany);
		// select the country
		driver.findElement(germany).click();
		driver.findElement(nxt).click();
		driver.findElement(clik).click();
		wait(20, start);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersArrowSwitcher-iconButton MuiIconButton-sizeSmall']//span[@class='MuiIconButton-label']//*[name()='svg']")).click();
		//select start date
		driver.findElement(start).click(); 
		Thread.sleep(2000);
		//select end date
		driver.findElement(end).click();
		driver.findElement(nxt).click();
		// select no of travellers
		driver.findElement(no).click();
		Select age = new Select(driver.findElement(traveller0));
		age.selectByVisibleText("22 years");
		Select age1 = new Select(driver.findElement(traveller1));
		age1.selectByVisibleText("21 years");
		Thread.sleep(2000);
		driver.findElement(nxt).click();
		driver.findElement(med).click();
		driver.findElement(nxt).click();
		wait(20, mobile);
		driver.findElement(mobile).sendKeys("9876543210");
		wait(20, proceed);
		driver.findElement(proceed).click();
		Thread.sleep(5000);
		exttest.log(Status.PASS, "Details are provided Successfully");
		wait(20, student);
		driver.findElement(student).click();
		Thread.sleep(5000);
		driver.findElement(stud_visa1).click();
		driver.findElement(stud_visa2).click();
		Select visadays = new Select(driver.findElement(days));
		visadays.selectByVisibleText("30 Days");
		driver.findElement(apply).click();
		driver.findElement(sortby).click();
		
		driver.findElement(low).click();
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		System.out.println("*****************************************************");
		System.out.println("      The Student Travel Insurance Plans are: ");
		System.out.println("*****************************************************");
		exttest.log(Status.PASS, "Student Insurance Plans has been Displayed Sucessfully into the console");
		List<WebElement> companies=driver.findElements(comp);
		
		List<WebElement> prices=driver.findElements(price);
		
		WebElement n,a;
		int in=1;
		for(int i=0;i<3;i++) {
			n=companies.get(i);
			a=prices.get(i);
			System.out.println(in +") Name of the Insurance Provider Company is: "+n.getText()+" and insurance plan amount is (In INR):"+a.getText());
			in++;
		}
				
		
	}
}