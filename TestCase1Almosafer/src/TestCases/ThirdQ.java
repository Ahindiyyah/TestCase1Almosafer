package TestCases;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.bouncycastle.asn1.cmp.Challenge.Rand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class ThirdQ {
	String WebSite = "https://www.almosafer.com/en?ncr=1";
	WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();
	Random rand = new Random();

	@BeforeTest
	public void SetUp() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}

	@Test()
	public void ChooseTheCity() {
		WebElement Cities = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > section:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > a:nth-child(2) > div:nth-child(1)"));
		Cities.click();
		WebElement Names = driver.findElement(By.xpath("//input[@placeholder='Search for hotels or places']"));
		String CITIES[] = { "Dubai", " Jeddah", "Riyadh" };
		int RandomIndex = rand.nextInt(CITIES.length);
		Names.sendKeys(CITIES[RandomIndex]);
		WebElement Choose = driver.findElement(By.xpath(
				"//li[contains(@class,'phbroq-5 dbvRBC AutoComplete__ListItem AutoComplete__ListItem--highlighted AutoComplete__ListItem')]"));
		Names.click();
		Choose.click();
	}

	@Test()
	public void ChoosingTheNumbers() {
		List<WebElement> RoomAdultChildern = driver.findElements(
				By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[3]/div/select/option"));
		int RnadomIndex = rand.nextInt(2);
		System.out.println(RnadomIndex);
		WebElement WhatWeChoice = RoomAdultChildern.get(RnadomIndex);
		WhatWeChoice.click();

		WebElement SearchBtton = driver.findElement(By.xpath(
				"//button[@class='sc-jTzLTM hQpNle sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block']"));
		SearchBtton.click();
	}

	@Test()
	public void Sorting() throws InterruptedException {
		Thread.sleep(10000);
		WebElement Sorting = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));
		Sorting.click();
		WebElement LowestPrice = driver.findElement(
				By.xpath("//div[@class=\"Price__Wrapper undefined sc-dRCTWM GFIG\"]/span[@class=\"Price__Value\"]"));
		String ActualLowestPrice = LowestPrice.getText();
		WebElement FirtsItemPrice = driver.findElement(By.xpath(
				"//div[@class=\"Price__Wrapper PriceDisplay__FinalRate sc-dRCTWM GFIG\"]/span[@class=\"Price__Value\"]"));
		String ExpectedFirtsItemPrice = FirtsItemPrice.getText();
		softAssert.assertEquals(ActualLowestPrice, ExpectedFirtsItemPrice);
		WebElement RandomPrice=driver.findElement(By.xpath("//*[@id=\"hotelCard-1341767\"]/div[3]/div/div[2]/div/div[1]/div/span[2]"));
		int CompareRandomPrice=Integer.parseInt(RandomPrice.getText());
		int LowstPriceCompare=Integer.parseInt(LowestPrice.getText());
		boolean CompareBetweenTheTwo=(CompareRandomPrice>LowstPriceCompare);
		softAssert.assertEquals(CompareBetweenTheTwo, true);
	}

	@AfterTest
	public void Final() {
		softAssert.assertAll();
	}
}
