package sample.Sample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;

public class Tc_42_AdvanceSearchSmoke extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void AdvancedSearch() throws Throwable {
		
		/*read test script data*/
		
		String opportunity = eLib.getExcelData("Opportunity", 2, 2);
		String Relatedto =eLib.getExcelData("Opportunity", 2, 3);
		String Assigned = eLib.getExcelData("Opportunity", 2, 4);
		String Sales = eLib.getExcelData("Opportunity", 2, 5);
		String Search = eLib.getExcelData("Opportunity", 2, 6);
		String In = eLib.getExcelData("Opportunity", 2, 7);
		String dd =eLib.getExcelData("Opportunity", 2, 8);
		String Adv = eLib.getExcelData("Opportunity", 2, 9);
		
		 
		 /*Step3"Place the mouse cursor on ""Opportunities""  Link*/
		 
         driver.findElement(By.linkText("Opportunities")).click();
         
         /*Step4."Navigate to ""create new Opportunity""page by click on ""+"" image"*/
 
		  driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		
		/* Step4."create a Opportunity with mandatory fields"*/

		  
		  driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(opportunity); 
		  WebElement addr=driver.findElement(By.id("related_to_type")); 
		  wLib.select(addr, Relatedto);
		  driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img")).click();
		  String parent = driver.getWindowHandle();
		  wLib.switchToWindow(driver, "Organizations");
		  driver.findElement(By.id("search_txt")).sendKeys(Search); 
		  WebElement we = driver.findElement(By.xpath("//select[@name='search_field']")); 
		  wLib.select(we,In);
		  driver.findElement(By.name("search")).click();
		  driver.findElement(By.xpath("//a[text()='Krish P']")).click();
		  driver.switchTo().window(parent);
		  driver.findElement(By.xpath("//input[@value='U']")).click(); 
		  WebElement sales =driver.findElement(By.xpath("//select[@name='sales_stage']")); 
		  wLib.select(sales, Sales);
		  driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		  driver.findElement(By.linkText("Opportunities")).click();
		  
		  /* Step-5.Place the mouse cursor on "Advance Search "  Link*/

		  driver.findElement(By.xpath("//a[text()='Go to Advanced Search']")).click();
		  
		  //Step-6.SearchWithDropdown "Opportunity Name "

		  WebElement op= driver.findElement(By.xpath("//select[@name='fcol0']"));
		  wLib.select(op, Adv);
		  driver.findElement(By.xpath("//td[@align='center']/input[@class='crmbutton small create']")).click();
		  wLib.acceptAlert(driver);
         
		  /* Step-7.SearchWithDropdown "Opportunity Name" Dropdown"Equals"*/
		   
		  
		  WebElement ddo =driver.findElement(By.xpath("//select[@name='fop0']")); 
		  wLib.select(ddo, dd);
		  driver.findElement(By.xpath("//td[@align='center']/input[@class='crmbutton small create']")).click();
		 
		  
		  Thread.sleep(2000); 
		  // Step-8. After filling all "Fields" click on "Search Now" Button

		  wLib.select(ddo, dd);
		  driver.findElement(By.xpath("//input[@name='fval0']")).sendKeys(opportunity);
		  driver.findElement(By.xpath("//td[@align='center']/input[@class='crmbutton small create']")).click();
		  //Verification
		  String Acctualmsg = driver.findElement(By.xpath("//a[text()='Opportunity No']")).getText();
		  if(Acctualmsg.equals("Opportunity No"))
		  {
			  System.out.println("Data found with advanced search");
		  }else
		  {
			  System.out.println("Data is not found with advanced search");
		  }
		  
		
		  

		  }

}
