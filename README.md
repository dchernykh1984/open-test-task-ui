# open-test-task-ui
Test task for DBO project

# Description
## UI test

Autotest opens google page

Performs search by word "Открытие"

Checks, that number of found results more than 10000 [SUCCESS]

## API test

Autotest makes request to https://api.github.com/users/defunkt

Checks that login field is defunkt [SUCCESS]

Checks than company name is BankOpen [FAILURE]

# Tools used
[Java](https://java.com/ru/download/)

[TestNG](https://testng.org/doc/index.html)

[Selenide](https://ru.selenide.org/)

[Allure](https://github.com/allure-framework/allure-java)

[RestAssured](http://rest-assured.io/)

[Docker](https://www.docker.com/)

# Autotests usage
## Launch test
> mvn clean test 

## Get autotests report
> mvn allure:report

Report location is target\site\allure-maven-plugin\index.html

## [NOT IMPLEMENTED]Launch autotest on docker server with internet access:
```docker-release.sh
```
