import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Testing {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String winHandleBefore = driver.getWindowHandle();
        driver.manage().window().maximize();


        driver.get("https://www.g-store.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement element = driver.findElement(By.name("query"));
        element.sendKeys("GA-700SKE-7A" + "\n");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"bx_3329384694_746065\"]/a[1]/img"));
        element1.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"bx_840233306_746065\"]/div[1]/div[1]/div[2]/div[6]/div[3]/form/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element2);
        element2.click();



        WebElement element3 = driver.findElement(By.className("incart__btns-cart"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        element3.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement element4 = driver.findElement(By.className("basket__item-title"));
        String par = element4.getText();
        System.out.println(par);
        if(par.equals("GA-700SKE-7A")) {
            WebElement element5 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[1]/div[2]/div/div[2]/div/div/div[2]/span"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element5);
            element5.click();;
        } else {
            System.out.println("naaah. Not our item");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement element5 = driver.findElement(By.className("popup__close"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        element5.click();


        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement element6 = driver.findElement(By.className("head__note"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element6);
        String par1 = element6.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        System.out.println(par1);

    }
}
