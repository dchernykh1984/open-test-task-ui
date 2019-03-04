# open-test-task-ui
Test task for DBO project

# Description
##UI test
Autotest opens google page
Performs search by word "Открытие" [SUCCESS]
Checks, that number of found results more than 10000 [SUCCESS]
##API test
Autotest makes request to https://api.github.com/users/defunkt
Checks that login field is defunkt [SUCCESS]
Checks than company name is BankOpen [FAILURE]

# Tools used
Java
TestNG
Selenide
Docker
Allure
RestAssured

# Debug and launch test
Launch autotests locally:
```mvn test
```
[NOT IMPLEMENTED]Launch autotest on docker server with internet access:
```docker-release.sh
```
