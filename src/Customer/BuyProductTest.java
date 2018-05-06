package Customer;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class BuyProductTest {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    ChromeDriver driver;
    int qunatity = 1;
    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void buy() {
        driver.get("http://localhost:4200/StoreView/Bosla/27");
        int intialSoldNumber = Integer.parseInt(driver.findElementByXPath("//*[@id=\"box\"]/div/p[7]").getText().substring(7));
        driver.findElementByXPath("//*[@id=\"box\"]/div/button[2]").click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElementByXPath("/html/body/app-root/buy-product/div/div/div/div/div[2]/form/div[1]/input").sendKeys(String.valueOf(qunatity));
        driver.findElementByXPath("/html/body/app-root/buy-product/div/div/div/div/div[2]/form/div[2]/textarea").sendKeys("p sherman 42 wallaby way sydney");
        driver.findElementByXPath("/html/body/app-root/buy-product/div/div/div/div/div[2]/form/input").click();

        driver.get("http://localhost:4200/StoreView/Bosla/27");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int currentSoldNumber =   Integer.parseInt(driver.findElementByXPath("//*[@id=\"box\"]/div/p[7]").getText().substring(7));
        Assert.assertEquals(currentSoldNumber, intialSoldNumber + qunatity );

    }
}
