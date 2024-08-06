package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class BAC4841{
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "C:\\Chrome driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("disable-notifications");
        driver = new ChromeDriver(opt);
    }
    @Test
    public void testLogin() throws InterruptedException {

        //Open UAT URL
        driver.get("https://telefonica-business--uat.sandbox.lightning.force.com");

        // Maximize the window
        driver.manage().window().maximize();

        //Login to the window
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sh20319668@wipro.com.uat");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SHRE@4444wi");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        Thread.sleep(2000);
        System.out.println("Login Successfully");
        //Alex page search
        driver.findElement(By.xpath("//*[@class='slds-button slds-button_neutral search-button slds-truncate']")).click();
        WebElement search = driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[2]"));
        search.click();
        search.sendKeys("Alexander rupprecht");
        System.out.println("Search results for Alexander rupprecht");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        //scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)","");
        //Click on the kundenname
        driver.findElement(By.xpath("//a[@title=\"Alexander Rupprecht Test 1\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//button[@class=\"slds-button slds-button_neutral\"])[2]")).click();
        Thread.sleep(15000);
        //Open Bestandskunden page
        driver.findElement(By.xpath("//*[text()='Bestandskunden']/parent::a/parent::*")).click();
        Thread.sleep(18000);
        String parentwindow=driver.getWindowHandle();
        driver.findElement(By.xpath("(//span[@title=\"Accounts\"])[1]")).click();
        Thread.sleep(2000);

        //Account Name field validation
        WebElement accountname=driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[1]"));
        accountname.sendKeys("Pero Ljubojevic");
        WebElement suchen = driver.findElement(By.xpath("//button[@type=\"Submit\"]"));
        suchen.click();
        Thread.sleep(4000);
        WebElement accountlabel=driver.findElement(By.xpath("//span[@title=\"Accountname\"]/parent::*"));
        accountlabel.click();
        WebElement PLaccount = driver.findElement(By.xpath("//*[text()=\"Pero Ljubojevic\"]/parent::*"));
        Thread.sleep(5000);
        PLaccount.click();
        driver.switchTo().window(parentwindow);
        accountname.clear();

        //Kundennummer field Validation
        WebElement kundennummer=driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[2]"));
        kundennummer.sendKeys("40102552");
        suchen.click();
        Thread.sleep(3000);
        accountlabel.click();
        PLaccount.click();
        driver.switchTo().window(parentwindow);
        kundennummer.clear();

        //SPIN field Validation
        WebElement spinno=driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[3]"));
        spinno.sendKeys("713115");
        suchen.click();
        Thread.sleep(3000);
        accountlabel.click();
        PLaccount.click();
        driver.switchTo().window(parentwindow);
        spinno.clear();

        //Account-ID field Validation
        WebElement accountid = driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[4]"));
        accountid.sendKeys("001w000001HqLysAAF");
        suchen.click();
        Thread.sleep(3000);
        accountlabel.click();
        PLaccount.click();
        driver.switchTo().window(parentwindow);
        accountid.clear();

        //partner VO field Validation
        WebElement partnerVO = driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[5]"));
        partnerVO.sendKeys("96720001");
        suchen.click();
        Thread.sleep(5000);
        accountlabel.click();
        PLaccount.click();
        driver.switchTo().window(parentwindow);
        partnerVO.clear();

        //Vertriebsbeauftragter field Validation
        WebElement vertriebsbeauftragter = driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[6]"));
        vertriebsbeauftragter.sendKeys("Alexander Rupprecht Telefonica Germany GmbH&Co.OHG (96800111)");
        suchen.click();
        Thread.sleep(12000);
        accountlabel.click();
        PLaccount.click();
        driver.switchTo().window(parentwindow);

        driver.quit();

        System.out.println("Test case pass");

    }


}
