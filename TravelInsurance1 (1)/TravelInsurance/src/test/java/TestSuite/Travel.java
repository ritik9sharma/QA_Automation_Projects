package TestSuite;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CarInsurance;
import Pages.HealthInsurances;
import Pages.TravelInsurance;


public class Travel {
	
	@Test
	public void testing() throws InterruptedException
	{
		TravelInsurance ti= new TravelInsurance();
		
		CarInsurance ci= new CarInsurance();
		HealthInsurances hi= new HealthInsurances();
		ti.driverSetup();
		ti.openUrl();
		ti.travel();
		ci.openUrl();
		ci.car();
		ci.Screenshot();
		hi.openUrl();
		hi.list();
		hi.closeBrowser();
		
	}
	
	

}
