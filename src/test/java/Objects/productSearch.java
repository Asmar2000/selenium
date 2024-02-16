package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class productSearch {

    WebDriver driver;
    public productSearch(WebDriver driver) {
        this.driver = driver;
    }
    By searchBox = By.id("twotabsearchtextbox");
    By searchResult = By.id("nav-search-submit-button");
    public void searchFor(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }
    public void searchResult() {
        driver.findElement(searchResult).click();
    }
}
