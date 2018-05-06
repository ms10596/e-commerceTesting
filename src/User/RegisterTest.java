package User;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class RegisterTest {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    String baseUrl = "http://localhost:4200/signUp";
    ChromeDriver driver;
    @BeforeTest
    public void setBaseURL() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void storeOwnerRegister() {
        driver.get(baseUrl);
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("Mohamed");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Magdy");
        driver.findElementByXPath("//*[@id=\"username\"]").sendKeys("magdyStoreOwner");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("12345678");
        driver.findElementByXPath("//*[@id=\"email\"]").sendKeys("magdy@gmail.com");
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/div[7]/label/input").click();
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/input").click();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        driver.findElementByXPath("/html/body/app-root/app-store-owner/div/div/nav/div/ul/li[1]/a");
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/StoreOwner/magdyStoreOwner");
    }
    @Test
    public void storeOwnerRegister1() {
        driver.get(baseUrl);
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("Mohamed");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Sayed");
        driver.findElementByXPath("//*[@id=\"username\"]").sendKeys("sayedStoreOwner");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("12345678");
        driver.findElementByXPath("//*[@id=\"email\"]").sendKeys("ms10596@gmail.com");
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/div[7]/label/input").click();
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/input").click();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        driver.findElementByXPath("/html/body/app-root/app-store-owner/div/div/nav/div/ul/li[1]/a");
        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:4200/StoreOwner/sayedStoreOwner");
    }
    @Test
    public void customerRegister() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("Mohamed");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Magdy");
        driver.findElementByXPath("//*[@id=\"username\"]").sendKeys("magdyCustomer");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("12345678");
        driver.findElementByXPath("//*[@id=\"email\"]").sendKeys("magdy@gmail.com");
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/div[6]/label/input").click();
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/input").click();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        driver.findElementByXPath("/html/body/app-root/app-customer/div/div/nav/div/ul/li[1]/a");
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/Customer/magdyCustomer");

    }
    @Test
    public void customerRegister1() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("Mohamed");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Sayed");
        driver.findElementByXPath("//*[@id=\"username\"]").sendKeys("sayedCustomer");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("12345678");
        driver.findElementByXPath("//*[@id=\"email\"]").sendKeys("ms10596@gmail.com");
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/div[6]/label/input").click();
        driver.findElementByXPath("/html/body/app-root/signup-form/div/div/div/div/div[2]/form/input").click();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        driver.findElementByXPath("/html/body/app-root/app-customer/div/div/nav/div/ul/li[1]/a");
        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:4200/Customer/sayedCustomer");

    }
    @AfterTest
    public void close() {
        driver.close();
    }

}
