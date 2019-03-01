package com.epam.bko.at.testtask;

import com.epam.bko.at.testtask.helpers.PropertiesReader;
import com.epam.bko.at.testtask.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
    GoogleSearchPage googlePage;

    @BeforeClass
    public void openPage() {
        googlePage = new GoogleSearchPage();
        googlePage.openPage();
    }

    @Test
    public void makeSearch() {
        googlePage.search(PropertiesReader.getProperty("searchValue"));
    }

    @Test(dependsOnMethods = "makeSearch")
    public void checkSearchResults() {
        Long searchResultsNumber = googlePage.getResultsNumber();
        Assert.assertTrue(searchResultsNumber > Long.parseLong(PropertiesReader.getProperty("minNumberOfResults")),
                "Number of search results should be more, than 100000, actual value is " + searchResultsNumber
        );
    }
}
