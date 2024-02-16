package testMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import objects.productSearch;

public class test_Scenarios {
WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        Dimension taskDimension = new Dimension(1024, 768);
        driver.manage().window().setSize(taskDimension);
        driver.get("https://www.amazon.eg/");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @Test
    public void testSearch() {
        Assert.assertEquals(driver.getTitle(), "أمازون مصر: تسوق أونلاين | أسعار مخفضة على الإلكترونيات، الأزياء، الموبايل، السوبرماركت والمزيد");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.eg/");
        productSearch page = new productSearch(driver);
        page.searchFor("car accessories");
        page.searchResult();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.eg/s?k=car+accessories"),"URL doesn't contain the expected substring");
        page.selectItem();
        page.productImage();
    }
    @Test
    public void addItemToCart() {
        productSearch page = new productSearch(driver);
        page.AddToCart();

    }
    @Test
    public void verifyCart() {
        productSearch page = new productSearch(driver);
        page.verifyCart();
    }
//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }


}
