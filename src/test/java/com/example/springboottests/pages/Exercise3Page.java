package com.example.springboottests.pages;

import org.springframework.stereotype.Component;

@Component
public class Exercise3Page extends BasePage {

    public void navigateToExercise() {
        this.navigateToExercise("exercise3");
    }

    public void selectOptionInS13(String optionToSelect) {
        this.selectOptionInDropdown(optionToSelect, "#s13");
    }

    public void clickSolution() {
        this.clickBy("#solution");
    }

    public void assertTrailTextIs(String expectedText) {
        this.assertTextBy(expectedText, "#trail .wrap");
    }
}
