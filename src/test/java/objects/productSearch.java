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

}
