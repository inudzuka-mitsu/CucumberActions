package com.testproject.steps;

import com.testproject.cucumber.ScenarioContext;
import com.testproject.pages.GoogleSearchPage;
import com.testproject.utils.Driver;
import com.testproject.utils.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleSearchSteps {

    private final GoogleSearchPage page;
    private final ScenarioContext context;

    public GoogleSearchSteps(ScenarioContext context, GoogleSearchPage page) {
        this.context = context;
        this.page = page;
    }

    @Given("^I am on Google search page$")
    public void i_am_on_google_search_page() {
        Driver.get().get(Environment.URL);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String search) {
        page.searchBar.sendKeys(search + Keys.ENTER);
    }

    @Then("I see title contains {string}")
    public void i_see_title_contains(String string) {
        Assert.assertTrue(Driver.get().getTitle().contains(string));
    }
}
