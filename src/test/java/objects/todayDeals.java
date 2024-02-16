package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class todayDeals {
    WebDriver driver;
    public todayDeals(WebDriver driver) {
        this.driver = driver;
    }

    public void dealItems() {
        driver.get("https://www.amazon.eg/");
        WebElement todayDeals = driver.findElement(By.id("desktop-grid-5"));
    }
}
