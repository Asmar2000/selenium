package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class todayDeals {
    WebDriver driver;
    public todayDeals(WebDriver driver) {
        this.driver = driver;
    }

    public void openDeals() {
        driver.get("https://www.amazon.eg/");
        WebElement todayDeals = driver.findElement(By.xpath("// a [@href=\"/deals?ref_=nav_cs_gb\"]"));
        todayDeals.click();
    }
    public void checkCategories() {
        List<WebElement> check = driver.findElements(By.xpath("// li [@class=\"CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49\"]"));
        check.get(8).click(); //check Men's fashion
        check.get(9).click(); //check Women's fashion
        check.get(11).click(); //check Electronics

    }
    public void checkDiscount() {
        List<WebElement> discount = driver.findElements(By.xpath("// li [@class=\"LinkFilterOption-module__linkFilterOptionListElement_AzC4LFMfeFF1CkwveJM01\"]"));
        discount.get(16).click(); //check 10% off
    }
    public void paginateTo(int pages){
        WebElement paginate = driver.findElement(By.xpath("// li [@class=\"a-last\"]"));
        for(int i = 0; i < pages; i++){
            paginate.click();
            // this block is to wait after loading
            // I know that Thread.sleep is not a best practice, I am a newbie
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // search again for the element after loading
            paginate = driver.findElement(By.xpath("//li[@class='a-last']"));
        }
    }
}
