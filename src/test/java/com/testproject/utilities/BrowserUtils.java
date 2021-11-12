package com.testproject.utilities;

import com.testproject.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {


    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor)Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor)Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static void doubleClick(WebElement element) {
        new Actions(Driver.get()).doubleClick(element).perform();
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }
}
