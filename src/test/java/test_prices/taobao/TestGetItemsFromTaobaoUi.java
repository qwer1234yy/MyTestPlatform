package test_prices.taobao;

import automation.testmanagement.UiBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test_prices.entities.Item;

public class TestGetItemsFromTaobaoUi extends UiBaseTest {
    Item item;
    String url = "https://www.taobao.com";
    long wait = 1000 * 2;

    @Test
    public void testGetItem() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.id("q")).sendKeys("连衣裙");
        driver.findElement(By.className("btn-search")).click();
    }
}
