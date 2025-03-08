package org.example;

import io.qameta.allure.Attachment;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import simbirsoft_test.FormPage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class TestForm {
    public static WebDriver driver;
    public static FormPage page;
    private static Logger logger = Logger.getLogger(TestForm.class.getName());
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("https://practice-automation.com/form-fields/");
    }

    @Test
    public void test() throws AWTException, IOException {
        page = new FormPage(driver);
        inputName();
        inputPassword();
        chooseDrink();
        chooseColor();
        doYouLikeAutomation();
        inputEmail();
        inputMessage();
        submit();
        File outputfile = new File("resultscreenshot.jpg");
        ImageIO.write(getScreenShot(), "jpg", outputfile);
    }
    public  void inputName(){
        page.inputName("Иванов Иван Иванович");
    }
    //Заполнить поле Password
    public  void inputPassword(){
        page.inputPassword("qWeRtY");
    }
    //Из списка What is your favorite drink? выбрать Milk и Coffee
    public  void chooseDrink (){
        page.clickMilk();
        page.clickCoffee();
    }
    //Из списка What is your favorite color? выбрать Yellow
    public  void chooseColor(){
        page.clickYellow();
    }
    //В поле Do you like automation? выбрать любой вариант
    public  void doYouLikeAutomation(){
        page.inputSelectForm("Yes");
    }
    //Поле Email заполнить строкой формата name@example.com
    public  void inputEmail(){
        page.inputEmail("testmail@mail.ru");
    }
    //В поле Message написать количество инструментов, описанных в пункте Automation tools,
    // дополнительно написать инструмент из списка Automation tools, содержащий наибольшее количество символов
    public  void inputMessage(){
        page.inputMessage(page.getToolsNumber()+" "+page.getMaxLength());
    }
    //Нажать на кнопку Submit
    public void submit() {
        page.submit();

    }
    //Просмотр результата
    public BufferedImage getScreenShot() throws AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.alertIsPresent());
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        driver.switchTo().alert().accept();
        return image;
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
