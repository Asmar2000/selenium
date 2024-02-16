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
    By searchBox = By.id("twotabsearchtextbox");

    public void searchFor(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }
    By searchResult = By.id("nav-search-submit-button");
    public void searchResult() {
        driver.findElement(searchResult).click();
    }

    public void selectItem() {
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        WebElement firstResult = searchResults.get(0);
        firstResult.click();


    }
    By productImage = By.cssSelector("#imgTagWrapperId");
    public void productImage() {
        driver.findElement(productImage);
        Assert.assertNotNull(productImage, "Image is not displayed");
    }
    By addToCartBTN = By.cssSelector("input#add-to-cart-button");
    public void AddToCart(){
        driver.findElement(addToCartBTN).click();
    }
    public void verifyCart(){

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.eg/cart/"),"URL doesn't contain the expected substring");

    }



}
