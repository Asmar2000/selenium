package objects;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        List<WebElement> checkbox = driver.findElements(By.xpath("// input [@data-csa-c-type=\"uxElement\"]"));
        WebElement menCategory =  checkbox.get(8);
        menCategory.click(); //check Men's fashion
        WebElement womenCategory = checkbox.get(9);
        womenCategory.click(); //check Women's fashion
        WebElement electronics = checkbox.get(11);
        electronics.click(); //check Electronics
        Assert.assertTrue(menCategory.isSelected(), "Men's fashion checkbox is not checked");
        Assert.assertTrue(womenCategory.isSelected(), "Women's fashion checkbox is not checked");
        Assert.assertTrue(electronics.isSelected(), "Electronics checkbox is not checked");
    }
    public void checkDiscount() {
        driver.findElement(By.linkText("خصم 10% أو أكثر")).click(); //check 10% off
        WebElement assertDiscount = driver.findElement(By.xpath("// a [@data-csa-c-element-id=\"filter-discount-10-\"]"));
        Assert.assertTrue(assertDiscount.isDisplayed(), "Discount filter is not working");
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
        Assert.assertTrue(paginate.isDisplayed(), "Pagination is not working");
    }
    public void selectProduct() {
        List<WebElement> categories = driver.findElements(By.xpath("// div [@class=\"DealGridItem-module__dealItemContent_1vFddcq1F8pUxM8dd9FW32\"]"));
        WebElement firstCategory = categories.getFirst();
        firstCategory.click();
        List<WebElement> product = driver.findElements(By.xpath("// div [@class=\"a-section a-spacing-base a-text-center octopus-dlp-image-section\"]"));
        WebElement firstProduct = product.getFirst();
        firstProduct.click();
    }
}
