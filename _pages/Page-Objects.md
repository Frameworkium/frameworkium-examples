---
layout: post
title:  "Page Objects"
category: wiki
section: 2 - Basics
order: 3
---

## Extend Base Page

Test classes must extend com.frameworkium.pages.internal.BasePage. This handles the setup and teardown of the WebDriver / AppiumDriver sessions.

```java
public class LoginPage extends BasePage<LoginPage> {
```

## Pages - Elements at the top, Operations at the bottom

### Elements

```java
	  @Name("Username text field")
	  @Visible
	  @FindBy(css="input#inputEmail")
	  private WebElement usernameField;

	  @Name("Password text field")
	  @Visible
	  @FindBy(css="input#inputPassword")
	  private WebElement passwordField;

	  @Name("Invalid login warning")
	  @FindBy(css="div#invalid-login")
	  private WebElement invalidLoginWarning;
```

- The @Name annotation allows additional reporting and debugging information to be used later.
- The @Visible annotation will tell the PageFactory to wait for the element to be displayed before returning the page.
- The @FindBy annotation is a selenium annotation - see help [here](https://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/support/FindBy.html) - that simplifies location of elements
- Finally, elements should be `private`, as they should only be used by this class!

### Operations

```java
	@Step("Enter credentials and return logged in homepage")
	public LoggedInHomepage validLogin(String username, String password)
	{
		login(username, password);
		return PageFactory.newInstance(LoggedInHomepage.class);
	}

	@Step("Enter credentials and expect to stay on the login screen")
	public LoginPage invalidLogin(String username, String password)
	{
		login(username, password);
		return this;
	}

	@Step("Enter username {0} and password {1} and click login")
	private void login(String username, String password)
	{
		usernameField.clear();
		usernameField.sendKeys(username);

		passwordField.clear();
		passwordField.sendKeys(password);

		loginButton.click();
	}
```

- The @Step annotation will be interpreted later on to enable rich reporting of the steps being run - the {0} and {1} in the example above will be replaced in the reports with the variable passed into the method
- Methods that perform operations on the page, but are only used by other methods on the page (eg 'login') should be marked as `private`, as they're only used by this page!

**NB All public methods on the page should return a Page Object!**
eg:

* if clicking something on the page that results in you moving to a new page, then `return PageFactory.newInstance(NextPagePageObject.class);` - eg the validLogin() method above
* if clicking a button on the page results in you staying on the same page, then `return this;` - eg the invalidLogin() method above.