package Admin;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductTest {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    ChromeDriver driver;
    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void addProduct() {
        driver.get("http://localhost:4200/addProduct");
        driver.findElementByXPath("//*[@id=\"pname\"]").sendKeys("LG");
        driver.findElementByXPath("//*[@id=\"price\"]").sendKeys("7500");
        driver.findElementByXPath("//*[@id=\"category\"]").sendKeys("Smart phones");
        Select selectBox = new Select(driver.findElementByXPath("/html/body/app-root/add-product/div/div/div/div/div[2]/form/div[4]/select"));
        selectBox.selectByIndex(1);
        selectBox = new Select(driver.findElementByXPath("/html/body/app-root/add-product/div/div/div/div/div[2]/form/div[5]/select"));
        selectBox.selectByIndex(1);
        driver.findElementByXPath("/html/body/app-root/add-product/div/div/div/div/div[2]/form/input").click();

        driver.manage().window().maximize();
        driver.get("http://localhost:4200/Store/27/sayedStoreOwner");
        driver.findElementByXPath("//*[@id=\"main\"]/a").click();
        List<WebElement>products = driver.findElementsByClassName("products");
        for(WebElement product:products) {
            System.out.println(product.getText());
            if(product.getText().contains("LG")) {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertFalse(true);


    }
}
