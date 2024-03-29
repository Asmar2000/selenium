package testMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.cartItems;
import objects.productSearch;
import objects.todayDeals;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_Scenarios {
WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        Dimension taskDimension = new Dimension(1024, 768); //set the window size to 1024 x 768 as mentioned in the task
        driver.manage().window().setSize(taskDimension);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @Test
    public void testSearch() {
        driver.get("https://www.amazon.eg/");
        Assert.assertEquals(driver.getTitle(), "أمازون مصر: تسوق أونلاين | أسعار مخفضة على الإلكترونيات، الأزياء، الموبايل، السوبرماركت والمزيد");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.eg/");
        productSearch test = new productSearch(driver);
        cartItems cart = new cartItems(driver);
        test.searchFor("car accessories");
        test.searchResult();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.eg/s?k=car+accessories"),"URL doesn't contain the expected substring");
        test.selectItem();
        test.productImage();
        cart.AddToCart();
    }

    @Test
    public void verifyCart() {
        cartItems test = new cartItems(driver);
        test.verifyCart();
        test.removeItem();
    }
    @Test
    public void TodayDeals() {
        todayDeals test = new todayDeals(driver);
        test.openDeals();

        test.checkCategories();
        test.checkDiscount();
        test.paginateTo(4);
    }
    @Test
    public void dealSelection() {
        todayDeals test = new todayDeals(driver);
        test.selectProduct();
        cartItems cart = new cartItems(driver);
        cart.AddToCart();
        cart.verifyCart();
        cart.removeItem();
    }




    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
