package test_prices.jd;

import automation.testmanagement.UiBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test_prices.entities.Item;

public class TestGetItemsFromJDUi extends UiBaseTest {
    Item item;
    String url = "https://www.jd.com";

    @Test
    public void testGetItem() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.id("key")).sendKeys("连衣裙");
//        driver.findElement(By.xpath(".//button[contains(text(),'搜索')]")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/button/i")).click();
    }
}
