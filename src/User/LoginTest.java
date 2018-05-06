package User;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    String chromePath = "/home/ms10596/IdeaProjects/e-commerce-spring-boot/chromedriver";
    String baseUrl = "http://localhost:4200/logIn";
    ChromeDriver driver;
    @BeforeTest
    public void setBaseURL() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
    }
    @Test
    public void verifyAdmin() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sayedAdmin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/Admin/sayedAdmin");
    }
    @Test
    public void verifyAdmin1() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sayedAdmin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:4200/Admin/sayedAdmin");
    }
    @Test
    public void verifyAdmin2() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:4200/Admin/sayedAdmin");
    }
    @Test
    public void verifyAdmin3() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:4200/Admin/sayedAdmin");
    }
    @Test
    public void verifyAdmin4() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sayedAdmin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("sos' OR 'X'='x");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:4200/Admin/sayedAdmin");
    }
    @Test
    public void verifyAdmin5() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ms10596@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/Admin/sayedAdmin");
    }
    @Test
    public void verifyStoreOwner() {
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sayedStoreOwner");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/StoreOwner/sayedStoreOwner");
    }
    @Test
    public void verifyStoreOwner1() {
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ms10596@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/StoreOwner/sayedStoreOwner");
    }
    @Test
    public void verifyCustomer() {
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sayedCustomer");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/Customer/sayedCustomer");
    }
    @Test
    public void verifyCustomer1() {
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ms10596@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("moh10596");
        driver.findElement(By.xpath("/html/body/app-root/login-form/div/div/div/div/div[2]/form/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/html/body/app-root/nav/a");

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/Customer/sayedCustomer");
    }
    @AfterTest
    public void close() {
        driver.close();
    }


}
