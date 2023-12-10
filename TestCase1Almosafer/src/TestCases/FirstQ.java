package TestCases;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Locale;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstQ {
	String WebSite = "https://www.almosafer.com/en?ncr=1";
	WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void SetUp() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test()
	public void TestCase1() {
		WebElement ActualLanguage = driver.findElement(By.tagName("html"));
		String Actual = ActualLanguage.getAttribute("lang");
		softAssert.assertEquals(Actual, "en");

	}

	@Test()
	public void TestCase2() {
		WebElement ActualCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
		String Actual = ActualCurrency.getText();
		softAssert.assertEquals(Actual, "SAR");
	}

	@Test()
	public void TestCase3() {
		WebElement ActualNumber = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
		String Actual = ActualNumber.getText();
		softAssert.assertEquals(Actual, "+966554400000");
	}

	@Test()
	public void TestCase4() {
		WebElement Qtiaf = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/footer/div[3]/div[3]/div[1]/div[2]/div/div[2]"));
		boolean Check = Qtiaf.isDisplayed();
	}

	@Test()
	public void TestCase5() {
		WebElement HotelButton = driver.findElement(By.xpath("//a[@id='uncontrolled-tab-example-tab-hotels']"));
		String CheckedOrNot = HotelButton.getAttribute("aria-selected");
		softAssert.assertEquals(CheckedOrNot, "false");
	}

	@Test()
	public void DepartureAndArravial() {
		WebElement Departure = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"));
		WebElement Arravial = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"));
		int ActualDepartureDate = Integer.parseInt(Departure.getText());
		int ActualArravialDate = Integer.parseInt(Arravial.getText());

		LocalDate today = LocalDate.now();
		int ExpectedDepartureDate = today.plusDays(1).getDayOfMonth();
		int ExpectedArravialDate = today.plusDays(2).getDayOfMonth();
		Assert.assertEquals(ActualDepartureDate,ExpectedDepartureDate);
		Assert.assertEquals(ActualArravialDate,ExpectedArravialDate);

	}

	@AfterTest
	public void Final() {
		softAssert.assertAll();
	}

}
