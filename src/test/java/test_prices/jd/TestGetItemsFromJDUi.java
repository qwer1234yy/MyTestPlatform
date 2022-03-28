package test_prices.jd;

import automation.testmanagement.UiBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test_prices.entities.Item;

public class TestGetItemsFromJDUi extends UiBaseTest {
    Item item;
    String url = "https://www.jd.com";
    long wait = 1000 * 2;

    @Test
    public void testGetItem() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.id("q")).sendKeys("连衣裙");
        driver.findElement(By.className("btn-search")).click();
    }
}
