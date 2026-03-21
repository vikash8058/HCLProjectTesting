# Udemy Use Case
---

## Use Case

**Udemy – Course Search & Detail Validation**

This project automates a guest user journey on Udemy where a user searches for an online course, applies a filter, opens the first course card, and validates key details like course title, rating, and instructor name — without enrolling or logging in.

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Selenium WebDriver | Browser automation |
| Java | Programming language |
| TestNG | Test management and assertions |
| PageFactory + @FindBy | Page Object Model implementation |
| ExtentReports | HTML test reporting |
| WebDriverManager | Auto ChromeDriver setup |
| Maven | Dependency management |

---

## Project Structure

```
EcommerceProjectTesting/
|
|-- src/main/java/
|   |-- base/
|   |   `-- DriverFactory.java
|   |-- pages/
|   |   |-- BasePage.java
|   |   |-- HomePage.java
|   |   |-- SearchResultsPage.java
|   |   `-- CourseDetailPage.java
|   `-- utils/
|       |-- ExtentReportManager.java
|       |-- ScreenshotUtil.java
|       `-- WaitUtil.java
|
|-- src/test/java/
|   |-- base/
|   |   `-- BaseTest.java
|   |-- listeners/
|   |   `-- TestListener.java
|   `-- tests/
|       |-- HomePageTest.java
|       |-- SearchResultsTest.java
|       `-- CourseDetailTest.java
|
|-- reports/
|   `-- ExtentReport.html
|-- screenshots/
|   `-- failed/
|-- testng.xml
`-- pom.xml
```

---

## Automation Flow

```
1. Open Chrome Browser
2. Navigate to https://www.udemy.com
3. Handle cookies or popups if displayed
4. Search for "Python" course
5. Verify search results page loads
6. Apply Ratings filter
7. Click on first course card
8. Verify course title is displayed
9. Verify course rating is displayed
10. Verify instructor name is displayed
11. Generate ExtentReport with pass/fail status
12. Capture screenshot on any test failure
```

---

## Test Cases

### HomePageTest.java — 10 Test Cases

| ID | Test Case | Type |
|----|-----------|------|
| TC01 | Verify Udemy home page is displayed | Positive |
| TC02 | Verify page title contains Udemy | Positive |
| TC03 | Verify URL contains udemy | Positive |
| TC04 | Verify search with valid keyword Python | Positive |
| TC05 | Verify search results page loads | Positive |
| TC06 | Verify search with empty input | Negative |
| TC07 | Verify search with invalid keyword | Negative |
| TC08 | Verify search with special characters | Negative |
| TC09 | Verify search with spaces only | Negative |
| TC10 | Verify search with very long text | Negative |

### SearchResultsTest.java — 10 Test Cases

| ID | Test Case | Type |
|----|-----------|------|
| TC01 | Verify results displayed for Python | Positive |
| TC02 | Verify results URL contains Python | Positive |
| TC03 | Verify results page title is not empty | Positive |
| TC04 | Verify filter option is visible | Positive |
| TC05 | Verify clicking first course opens detail page | Positive |
| TC06 | Verify page does not crash on bad input | Negative |
| TC07 | Verify page does not crash on numeric input | Negative |
| TC08 | Verify page does not crash on special chars | Negative |
| TC09 | Verify results page URL is not empty | Negative |
| TC10 | Verify results page title is not empty | Negative |

### CourseDetailTest.java — 10 Test Cases

| ID | Test Case | Type |
|----|-----------|------|
| TC01 | Verify course detail page is displayed | Positive |
| TC02 | Verify course title is displayed | Positive |
| TC03 | Verify course title is not null | Positive |
| TC04 | Verify course rating is displayed | Positive |
| TC05 | Verify instructor name is displayed | Positive |
| TC06 | Verify course page URL is not empty | Negative |
| TC07 | Verify course page title is not empty | Negative |
| TC08 | Verify course page URL contains udemy | Negative |
| TC09 | Verify course rating is not null | Negative |
| TC10 | Verify instructor name is not null | Negative |

**Total Test Cases: 30**

---

## Framework Layers

```
+----------------------------------+
|          TEST LAYER              |
|  HomePageTest                    |
|  SearchResultsTest               |
|  CourseDetailTest                |
|  (30 test cases + assertions)    |
+----------------------------------+
|          PAGE LAYER              |
|  HomePage                        |
|  SearchResultsPage               |
|  CourseDetailPage                |
|  (@FindBy + methods)             |
+----------------------------------+
|          BASE LAYER              |
|  BasePage                        |
|  BaseTest                        |
|  DriverFactory                   |
|  (setup + teardown + driver)     |
+----------------------------------+
|          UTILS LAYER             |
|  WaitUtil                        |
|  ScreenshotUtil                  |
|  ExtentReportManager             |
|  (reusable helper methods)       |
+----------------------------------+
|    SELENIUM + CHROMEDRIVER       |
|    (actual browser control)      |
+----------------------------------+
```

---

## Key Implementation Details

### Bot Detection Bypass
Udemy uses Cloudflare security. We bypass it using ChromeOptions:
```java
options.addArguments("--disable-blink-features=AutomationControlled");
options.addArguments("--start-maximized");
```

### Dynamic Element Handling
Udemy loads content dynamically. We use direct findElements for course cards:
```java
List<WebElement> courses = driver.findElements(
    By.xpath("//a[contains(@href,'/course/')]")
);
```

### New Tab Handling
Course links open in new tab. We use JavaScript navigation to stay in same tab:
```java
((JavascriptExecutor) driver)
    .executeScript("window.location.href='" + href + "'");
```

### Auto Screenshot on Failure
TestListener automatically captures screenshot on every test failure and attaches it to ExtentReport.

---

## How to Run

### Prerequisites
- Java 17 or above
- Maven installed
- Chrome browser installed
- Internet connection

### Steps
```
1. Clone or download the project
2. Open in Eclipse or IntelliJ
3. Create folders:
   -> reports/
   -> screenshots/failed/
4. Right click testng.xml
5. Run As -> TestNG Suite
6. After run open reports/ExtentReport.html
```

---

## Reports

After test execution open:
```
reports/ExtentReport.html
```

Report shows:
- Total tests run
- Pass count (green)
- Fail count (red)
- Screenshot on failure
- System information
- Time taken per test

---

## Squad Responsibilities

| Member | Responsibility |
|--------|---------------|
| Member 1 | Full skeleton + HomePage + HomePageTest + all base files |
| Member 2 | SearchResultsPage + SearchResultsTest |
| Member 3 | CourseDetailPage + CourseDetailTest |
| Member 4 | WaitUtil + ExtentReportManager + ScreenshotUtil + TestListener + testng.xml |

---

