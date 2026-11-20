# Selenium Java + Cucumber BDD + TestNG + Allure

Practice project for Jenkins CI/CD with SauceDemo.

## Requirements
- JDK 17+ (Java 21 works)
- Maven 3.x
- Google Chrome
- Internet connection for Maven dependencies and SauceDemo

## Execute locally

```powershell
mvn clean test
mvn clean test -Dheadless=true
mvn clean test '-Dcucumber.filter.tags=@smoke' -Dheadless=true
mvn clean test '-Dcucumber.filter.tags=@regression' -Dheadless=true
```

On Jenkins **Invoke top-level Maven targets**, enter these goals without `mvn`:

```
clean test -Dheadless=true
```

For smoke only:

```
clean test -Dheadless=true -Dcucumber.filter.tags=@smoke
```

## Reports
- Surefire XML: `target/surefire-reports/TEST-*.xml` (Jenkins JUnit publisher)
- Cucumber HTML: `target/cucumber-report.html`
- Allure results: `target/allure-results`

To view Allure locally, install Allure CLI separately and run `allure serve target/allure-results`.
For Jenkins, configure the Allure plugin and Allure commandline installation, then publish `target/allure-results`.

This example captures screenshots **on failure** and attaches them to the Cucumber scenario / Allure adapter. Jenkins may need a browser-capable interactive agent or headless Chrome; use `-Dheadless=true`.

Do not claim this is your existing workplace framework; it is a practice implementation.
