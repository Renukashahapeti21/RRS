package Package1;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Class1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.bookmyshow.com/explore/home");
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.=\"Bengaluru\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.=\"Sign in\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//div[.=\"Continue with Email\"])[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#emailId"))).sendKeys("testusersel@YOPmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.=\"Continue\"]"))).click();
		ArrayList<String> tb = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tb.get(1));
		driver.get("http://www.yopmail.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ycptinput"))).sendKeys("testusersel@YOPmail.com", Keys.ENTER);
		WebElement OTPELE = driver.findElement(By.xpath("//td[@style=\"text-decoration: none; color: rgba(51, 51, 51, 1); font-size: 24px; font-weight: 600\"]"));
		String OTP =OTPELE.getText().replaceAll("\\D", "");
		driver.switchTo().window(tb.get(0));
		for (int i = 0; i < 6; i++) {
		WebElement otpinp = driver.findElement(By.xpath("//input[@type='tel'][" + (i + 1) + "]"));
		char digit = OTP.charAt(i);
		otpinp.sendKeys(String.valueOf(digit));
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.=\"Continue\"]"))).click();
		String Actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bwc__sc-1nbn7v6-12.cQWvYS"))).getText();
		String Expected ="Hi, Guest";
        //Assert.assertEquals(Actual,Expected);
		Assert.assertEquals(Actual,Expected);
		//		System.out.println(Actual);
//		System.out.println("Hence, Validation got completed...");

	}

}
