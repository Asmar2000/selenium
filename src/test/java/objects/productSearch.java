package objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
public class productSearch {
    WebDriver driver;
    public productSearch(WebDriver driver) {
        this.driver = driver;
    }
    public void searchFor(String text) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(text);
        searchBox.click();
    }
    public void searchResult() {
        WebElement searchResult = driver.findElement(By.id("nav-search-submit-button"));
        searchResult.click();
    }
    public void selectItem() {
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        WebElement firstResult = searchResults.getFirst(); //get the first product
        firstResult.click(); //click on the first product as mentioned in the task
    }
    public void productImage() {
        WebElement productImage = driver.findElement(By.id("landingImage"));
        Assert.assertNotNull(productImage, "Image is not displayed"); //verify that the product image is displayed
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
