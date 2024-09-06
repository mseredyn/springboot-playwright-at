package com.example.springboottests.pages;

import com.example.springboottests.config.PlaywrightManager;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Lazy
@Component
@Scope("prototype")
public class BasePage {
    @Value("${base.url}")
    private String url;

    @Value("${test.seed}")
    private String testSeed;

    protected Locator getBy(String selector) {
        Locator locator = PlaywrightManager.getPage().locator(selector);
        locator.scrollIntoViewIfNeeded();
        return locator;
    }

    @Step
    protected void clickBy(String selector) {
        this.getBy(selector).click();
    }

    @Step
    protected void fillWithBy(String valueToFill, String selector) {
        this.getBy(selector).fill(valueToFill);
    }

    @Step
    protected String getTextBy(String selector) {
        return this.getBy(selector).textContent();
    }

    @Step
    protected String getValueBy(String selector) {
        return this.getBy(selector).inputValue();
    }

    @Step
    protected void selectOptionInDropdown(String valueToSelect, String selector) {
        this.getBy(selector).selectOption(valueToSelect);
    }

    @Step
    protected void assertTextBy(String expectedText, String selector) {
        assertThat(getBy(selector)).hasText(expectedText);
    }

    @Step
    protected void navigateToExercise(String exerciseName) {
        PlaywrightManager.getPage().navigate(url + exerciseName + "?seed=" + testSeed);
    }
}
