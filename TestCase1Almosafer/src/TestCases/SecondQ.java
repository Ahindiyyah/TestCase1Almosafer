package TestCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondQ {
	String WebSite = "https://www.almosafer.com/ar?ncr=1";
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
	public void FirstTest() {
		if (true == rand.nextBoolean()) {
			WebElement LanguagesChange = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]"));
			String ActualNewLangue=LanguagesChange.getText();
			String ExpectedNewLanguage="English";
			LanguagesChange.click();
			softAssert.assertEquals(ActualNewLangue, ExpectedNewLanguage);
		}
		else {
			WebElement LanguagesChange = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]"));
			String ActualNewLangue=LanguagesChange.getText();
			String ExpectedNewLanguage="Arabic";
			softAssert.assertNotEquals(ActualNewLangue, ExpectedNewLanguage);
		}
	}
	

	@AfterTest
	public void Final() {
		softAssert.assertAll();
	}

}
