import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/toster/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.avito.ru/");
        Select productSelector = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
        productSelector.selectByValue("99");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@class='main-text-2PaZG']")).click();
        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        WebElement chooseCity = driver.findElement(By.xpath("//li[@data-marker='suggest(0)']"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        chooseCity.click();
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement checkbox1 = driver.findElement(By.xpath("//span[@data-marker=\"delivery-filter/text\"]"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        Select sortByPrice = new Select(driver.findElement(By.xpath("//div[2]/select")));
        sortByPrice.selectByValue("2");
        WebElement listOfPrinters = driver.findElement(By.xpath("//div[@data-marker='catalog-serp']"));
        List<WebElement> results = listOfPrinters.findElements(By.cssSelector("div.iva-item-body-NPl6W"));
        System.out.println(results.size());
        for (int i = 0; i < 3; i++) {
            System.out.println(results.get(i).findElement(By.cssSelector("span.price-text-1HrJ_")).getText() + " " + results.get(i).findElement(By.cssSelector("span.title-root-395AQ")).getText());
        }
        driver.close();

    }
}