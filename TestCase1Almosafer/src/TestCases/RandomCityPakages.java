package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RandomCityPakages {
	String WebSite = "https://www.almosafer.com/en?ncr=1";
	WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();
	Random rand = new Random();

	@BeforeTest
	public void SetUp() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test()
	public void ChooseTheRandomPakage() {
List<WebElement> PakgeDeals=driver.findElements(By.className("slick-track"));
int RandomIndex=rand.nextInt(PakgeDeals.size());
WebElement TheChoosenIndex=PakgeDeals.get(0);
String TheActualHotel=TheChoosenIndex.getText();
TheChoosenIndex.click();
/*WebElement TheNameOfTheHotel=driver.findElement(By.cssSelector(".sc-jWxkHr.fRzvgx"));
String TheExpectedNameofThehotel=TheNameOfTheHotel.getAttribute("data-testid");
Assert.assertEquals(TheActualHotel, TheExpectedNameofThehotel);*/



	}

}
