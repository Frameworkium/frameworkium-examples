---
layout: post
title:  "Tests"
category: wiki
section: "2 - Basics"
order: 3
---
## Extend BaseTest

Test classes must extend `com.frameworkium.core.ui.tests.BaseTest`. This handles the `setup` and `teardown` of the WebDriver / AppiumDriver sessions (if you're not needing drivers - eg you're writing some API tests, you should extend `com.frameworkium.core.api.tests.BaseTest` instead)

For example:
```java
public class DynamicLoadingWebTest extends BaseTest { ... }
```

## Look - no drivers!

As you can see in the example tests there are no references to WebDriver or AppiumDriver thanks to Page Objects and some other bits and bobs. This results in more readable tests which only deal with the services offered by your application and not the details and mechanics of it. For further explanation see the Page Objects page.

```java
	@Issue("BBA-5")
	@Story("Logins")
	@Test(description="Login to the application")
	public void validLogin()
	{
		LoginPage loginPage = LandingPage.open().then().clickLoginButton();

		LoggedInHomepage homepage = loginPage.login("user", "password");
	}
```

- The @Issue annotation will be used for JIRA & ZAPI reporting, JQL Query executions, and linked to within the Allure report
- The @Story annotation allows you to utilise Allure's Features and Stories hierachy - and make larger test suites more easy to manage
- The testng @Test annotation contains the description of the test, and can include a number of other details *(`alwaysRun`, `dataProvider`, `dataProviderClass`, `dependsOnGroups`, `dependsOnMethods`, `description`, `enabled`, `expectedExceptions`, `groups`, `invocationCount`, `invocationTimeOut`, `invocationcounts`, `priority`, `successPercentage`, `singleThreaded`, `timeOut`, `threadPoolSize`)* - see [TestNG Annotations](http://testng.org/doc/documentation-main.html#annotations) for further details