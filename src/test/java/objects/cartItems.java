package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class cartItems {

    WebDriver driver;
    public cartItems(WebDriver driver) {
        this.driver = driver;
    }
    public void AddToCart(){

        WebElement addToCartBTN = driver.findElement(By.id(("add-to-cart-button")));
        addToCartBTN.click();
    }
    public void verifyCart(){
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.eg/cart/"),"URL doesn't contain the expected substring");
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "1", "Cart does not contain one item");

    }
    public void removeItem(){
        WebElement goToCart = driver.findElement(By.id("sw-gtc"));
        goToCart.click();
        WebElement deleteBTN = driver.findElement(By.xpath("//input[@value='حذف']"));
        deleteBTN.click();
        WebElement cartCountAfterDelete = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCountAfterDelete.getText(), "0", "Cart is not empty");
    }
}
