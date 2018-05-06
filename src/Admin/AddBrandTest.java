package Admin;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddBrandTest {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    ChromeDriver driver;
    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void addBrand() {
        driver.get("http://localhost:4200/addBrand");
        driver.findElementByXPath("//*[@id=\"bname\"]").sendKeys("Activ");
        driver.findElementByXPath("//*[@id=\"company\"]").sendKeys("Activ");
        boolean check = driver.findElementByXPath("/html/body/app-root/add-brand/div/div/div/div/div[2]/form/input").isEnabled();
        Assert.assertTrue(check);
    }
    @Test
    public void addDuplicatedBrand() {
        driver.get("http://localhost:4200/addBrand");
        driver.findElementByXPath("//*[@id=\"bname\"]").sendKeys("Activ");
        driver.findElementByXPath("//*[@id=\"company\"]").sendKeys("Activ");
        driver.findElementByXPath("/html/body/app-root/add-brand/div/div/div/div/div[2]/form/input").click();

        driver.get("http://localhost:4200/addProduct");
        List<WebElement> options =new Select(driver.findElementByXPath("/html/body/app-root/add-product/div/div/div/div/div[2]/form/div[4]/select")).getOptions();
        for (WebElement option:options) {
            if(option.getText().equals("Activ")) {
                Assert.assertTrue(false);
                return;
            }
        }
        Assert.assertTrue(true);
    }
    @Test
    public void addEmptyBrand() {
        driver.get("http://localhost:4200/addBrand");
        driver.findElementByXPath("//*[@id=\"bname\"]").sendKeys("");
        driver.findElementByXPath("//*[@id=\"company\"]").sendKeys("");
        boolean check = driver.findElementByXPath("/html/body/app-root/add-brand/div/div/div/div/div[2]/form/input").isEnabled();
        Assert.assertFalse(check);
    }
    @Test
    public void addTooLongBrand() {
        driver.get("http://localhost:4200/addBrand");
        driver.findElementByXPath("//*[@id=\"bname\"]").sendKeys("Hello it's me, I was wondering if after all these years you would like to meet, to goes over everything they said time heals but I know it's not");
        driver.findElementByXPath("//*[@id=\"company\"]").sendKeys("");
        boolean check = driver.findElementByXPath("/html/body/app-root/add-brand/div/div/div/div/div[2]/form/input").isEnabled();
        Assert.assertFalse(check);    }
    @Test
    public void addWeirdCharacters() {
        driver.get("http://localhost:4200/addBrand");
        driver.findElementByXPath("//*[@id=\"bname\"]").sendKeys("!@#$%^&*()_+)*^%$@!~~~@%IOXZASB?}|");
        driver.findElementByXPath("//*[@id=\"company\"]").sendKeys("");
        boolean check = driver.findElementByXPath("/html/body/app-root/add-brand/div/div/div/div/div[2]/form/input").isEnabled();
        Assert.assertFalse(check);    }
    @Test
    public void addArabicCharacters() {
        driver.get("http://localhost:4200/addBrand");
        driver.findElementByXPath("//*[@id=\"bname\"]").sendKeys("كان بدي أغير العالم مش عارف كيف العالم غيرني");
        driver.findElementByXPath("//*[@id=\"company\"]").sendKeys("قول اني منيح");
        boolean check = driver.findElementByXPath("/html/body/app-root/add-brand/div/div/div/div/div[2]/form/input").isEnabled();
        Assert.assertFalse(check);
    }
    @AfterTest
    public void close() {
        driver.close();
    }
}
