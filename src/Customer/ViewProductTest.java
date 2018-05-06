package Customer;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ViewProductTest {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    ChromeDriver driver;
    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void view() {
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/StoreView/Bosla/27");
        //driver.get("http://localhost:4200/StoreView/Bosla/27");
        int intialViewNumber = Integer.parseInt(driver.findElementByXPath("//*[@id=\"box\"]/div/p[6]").getText().substring(8));
        driver.findElementByXPath("//*[@id=\"box\"]/div/button[1]").click();

        driver.get("http://localhost:4200/StoreView/Bosla/27");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int currentSoldNumber =   Integer.parseInt(driver.findElementByXPath("//*[@id=\"box\"]/div/p[6]").getText().substring(8));
        Assert.assertEquals(currentSoldNumber, intialViewNumber + 1 );

    }
    @AfterTest
    public void close() {
        driver.close();
    }
}
