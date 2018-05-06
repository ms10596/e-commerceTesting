package StoreOwner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddStore {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    ChromeDriver driver;
    @BeforeTest
    public void loginAsStoreOwner() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void addStore() {
        driver.get("http://localhost:4200/addStore/sayedStoreOwner");

        driver.findElementByXPath("//*[@id=\"sname\"]").sendKeys("FCI");
        new Select(driver.findElementByXPath("/html/body/app-root/add-store/div/div/div/div/div[2]/form/div[2]/select")).selectByIndex(1);
        new Select(driver.findElementByXPath("/html/body/app-root/add-store/div/div/div/div/div[2]/form/div[3]/select")).selectByIndex(1);
        driver.findElementByXPath("/html/body/app-root/add-store/div/div/div/div/div[2]/form/input").click();

        driver.get("http://localhost:4200/storeRequest");
        String storeName = driver.findElementByXPath("/html/body/app-root/store-requests/div/div/ul/li/div/p[1]").getText();
        Assert.assertEquals(storeName, "store name : FCI");

    }
    @Test
    public void addDuplicatedStore() {
        driver.get("http://localhost:4200/addStore/sayedStoreOwner");

        driver.findElementByXPath("//*[@id=\"sname\"]").sendKeys("Bosla");
        new Select(driver.findElementByXPath("/html/body/app-root/add-store/div/div/div/div/div[2]/form/div[2]/select")).selectByIndex(1);
        new Select(driver.findElementByXPath("/html/body/app-root/add-store/div/div/div/div/div[2]/form/div[3]/select")).selectByIndex(1);
        driver.findElementByXPath("/html/body/app-root/add-store/div/div/div/div/div[2]/form/input").click();

        driver.get("http://localhost:4200/storeRequest");
        String storeName = driver.findElementByXPath("/html/body/app-root/store-requests/div/div/ul/li/div/p[1]").getText();
        Assert.assertNotEquals(storeName, "store name : Bosla");
    }
    @AfterTest
    public void close() {
        driver.close();
    }

}
