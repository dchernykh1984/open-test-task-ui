package com.epam.bko.at.testtask;

import com.epam.bko.at.testtask.helpers.PropertiesReader;
import com.epam.bko.at.testtask.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
    GoogleSearchPage googlePage;

    @BeforeClass(description = "Open default google search page by googleUrl property")
    public void openPage() {
        googlePage = new GoogleSearchPage(PropertiesReader.getProperty("googleUrl"));
        googlePage.openPage();
    }

    @Test(description = "Make search by searchValue property")
    public void makeSearch() {
        googlePage.search(PropertiesReader.getProperty("searchValue"));
    }

    @Test(description = "Check number of found items more than minNumberOfResults property", dependsOnMethods = "makeSearch")
    public void checkSearchResults() {
        Long searchResultsNumber = googlePage.getResultsNumber();
        Assert.assertTrue(searchResultsNumber > Long.parseLong(PropertiesReader.getProperty("minNumberOfResults")),
                "Number of search results should be more, than " + PropertiesReader.getProperty("minNumberOfResults") +
                        ", actual value is " + searchResultsNumber
        );
    }
}
