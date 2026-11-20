# Selenium Jenkins Practice

A small Selenium Java + TestNG + Maven Page Object Model project against https://www.saucedemo.com/.

## Prerequisites
- JDK 17+
- Maven 3.9+
- Google Chrome
- Internet access for Maven dependencies and Selenium Manager browser driver setup

## Run locally
```bash
mvn clean test
```

Run headless (useful for Jenkins):
```bash
mvn clean test -Dheadless=true
```

Override application URL:
```bash
mvn clean test -DbaseUrl=https://www.saucedemo.com/
```

TestNG reports appear under `target/surefire-reports/`. Maven Surefire emits XML reports suitable for Jenkins JUnit publishing. This initial framework intentionally does not include Jenkinsfile or Allure; we'll add them together during training.

**Note:** SauceDemo is a public demo website; test data and page structure may change. Browser and driver downloads may be required on first execution.
