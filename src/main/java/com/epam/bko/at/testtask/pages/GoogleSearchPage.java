package com.epam.bko.at.testtask.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.bko.at.testtask.helpers.PropertiesReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

@Slf4j
public class GoogleSearchPage {
    private final String resultsNumberRegexp = ":([^\\(]*)\\(";

    private String pageAddress;

    public GoogleSearchPage() {
        pageAddress = "https://www.google.com/";
    }

    public GoogleSearchPage(String url) {
        pageAddress = url;
    }

    public void openPage() {
        log.debug("Open page:" + pageAddress);
        Selenide.open(pageAddress);

    }

    public GoogleSearchPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleSearchPage.class);
    }

    public Long getResultsNumber() {
        String searchStatus = $(By.xpath("//*[@id='resultStats']")).getText();
        log.debug("Search status result:" + searchStatus);
        Pattern pattern = Pattern.compile(resultsNumberRegexp);
        Matcher matcher = pattern.matcher(searchStatus);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1).replaceAll("[\\D]", ""));
        } else {
            throw new RuntimeException("'" + resultsNumberRegexp +
                    "' not found in search status string '" + searchStatus + "'");
        }
    }

}
