package utils;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ReusableMethods {
    static Faker faker;

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickElement(WebElement element) {
        waitForVisibility(element, 9);
        element.click();

    }

    public static void isElementPresent(WebElement element) {
        waitForVisibility(element, 9);
        assertTrue(element.isDisplayed());
    }

    public static void enterKeys(WebElement element, String keys) {
        waitForVisibility(element, 9);
        element.sendKeys(keys);
    }

    public static void enterKeys(WebElement element, String keys, Boolean clear) {
        waitForVisibility(element, 9);
        if (clear) {
            element.clear();
        }
        element.sendKeys(keys);
    }

    public static Faker getFaker() { // getFaker method
        return faker = new Faker();
    }
    public static void jsclick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);

        }
    }
    public static String  getValueWithJs(String elementId){
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        String value=js.executeScript("return document.getElementById('"+elementId+"').value").toString();
        return value;
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public void clickIfItIsNotChecked(WebElement webElement){
        waitForVisibility(webElement,9);
        if(!webElement.isSelected()){
            jsclick(webElement);
        }
    }

    public void clickIfItIsChecked(WebElement webElement){
        waitForVisibility(webElement,9);
        if(webElement.isSelected()){
            jsclick(webElement);
        }
    }



    public boolean isNumberIsBiggerThanTheNumber(WebElement element,int numb){
        return Integer.parseInt(element.getText())>numb;
    }
    public boolean isNumberIsBiggerThanTheNumber(WebElement element,double numb){
        return Double.parseDouble(element.getText())>numb;
    }
    public static void setValueByJS(WebElement element, String key, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('" + key + "','" + text + "')", element);
    }
}
