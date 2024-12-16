import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthorizationTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //positive
    @Test
    public void ckeckInputs() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        boolean elementOnPage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).isDisplayed();
        Assert.assertTrue(elementOnPage);
    }

    //no password
    @Test
    public void ckeckNoPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        boolean elementErrorPassOnPage = driver.findElement(By.xpath
                ("//*[contains(text(), 'Epic sadface: Password is required')]")).isDisplayed();
        Assert.assertTrue(elementErrorPassOnPage);
    }

    //no login
    @Test
    public void ckeckNoLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click(); // Жмакаем Login
        boolean elementErrorLoginOnPage = driver.findElement(By.xpath
                ("//*[contains(text(), 'Epic sadface: Username is required')]")).isDisplayed();
        Assert.assertTrue(elementErrorLoginOnPage);
    }

    //no valid user
    @Test
    public void ckeckNoValidUser() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("novalid_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        boolean elementErrorLoginOnPage = driver.findElement(By.xpath
                ("//*[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")).isDisplayed();
        Assert.assertTrue(elementErrorLoginOnPage);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
