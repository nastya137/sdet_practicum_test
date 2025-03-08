package simbirsoft_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//Класс для взаимодействия с элементами страницы
public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Поиск элемента по id
    @FindBy(id = "name-input")
    private WebElement nameField;
    //Поиск элемента с использованием css
    @FindBy(css = "#feedbackForm > label:nth-child(3) > input[type=password]")
    //Поиск элементов с использованием XPath
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"drink1\"]")
    private WebElement waterCheckBox;
    @FindBy(xpath = "//*[@id=\"drink2\"]")
    private WebElement milkCheckBox;
    @FindBy(xpath = "//*[@id=\"drink3\"]")
    private WebElement coffeeCheckBox;
    @FindBy(xpath = "//*[@id=\"drink4\"]")
    private WebElement wineCheckBox;
    @FindBy(xpath = "//*[@id=\"drink5\"]")
    private WebElement ctrlAltDelightCheckBox;
    @FindBy(xpath = "//*[@id=\"color3\"]")
    private WebElement yellowCheckBox;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/main/div/article/div/form/select")
    private WebElement selectForm;
    @FindBy(xpath = "//*[@id=\"automation\"]")
    private WebElement doYouLikeAutomation;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/main/div/article/div/form/ul/li")
    private List<WebElement> automationToolsList;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement messageField;
    //Поиск элемента с использованием css
    @FindBy(css = "#submit-btn")
    private WebElement submitButton;

    public void inputName(String name){
        nameField.sendKeys(name);
    }
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickWater(){
        waterCheckBox.click();
    }
    public void clickMilk(){
        milkCheckBox.click();
    }
    public void clickCoffee(){
        coffeeCheckBox.click();
    }
    public void clickWine(){
        wineCheckBox.click();
    }
    public void clickCtrlAltDelight(){
        ctrlAltDelightCheckBox.click();
    }
    public void clickYellow(){
        yellowCheckBox.click();
    }
    public void inputSelectForm(String select){
        doYouLikeAutomation.sendKeys(select);
    }
    public int getToolsNumber(){
        return automationToolsList.size();
    }
    public void inputEmail(String email){
        emailField.sendKeys(email);
    }
    public void inputMessage(String message){
        messageField.sendKeys(message);
    }
    public void submit(){
        submitButton.submit();
    }
    public String getMaxLength(){
        String max = "";
        for(WebElement element : automationToolsList){
            if (element.getText().length() > max.length()){
                max = element.getText();
            }
        }
        return max;
    }


}
