package com.testproject.pages;

import com.testproject.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage<GoogleSearchPage> {

    @FindBy(name = "q")
    public WebElement searchBar;

}
