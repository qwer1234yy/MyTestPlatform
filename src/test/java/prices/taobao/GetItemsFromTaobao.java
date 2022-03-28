package prices.taobao;

import automation.testmanagement.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import prices.entities.Item;

public class GetItemsFromTaobao extends BaseTest {
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
