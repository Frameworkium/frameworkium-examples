---
layout: post
title:  "Native Controls"
category: wiki
section: 6 - Advanced Usage
order: 7
---

## Alerts/Dialog boxes

[This test](https://github.com/robertgates55/frameworkium/blob/master/src/test/java/com/frameworkium/tests/web/TheInternetHerokuWebTest.java#L202) demonstrates the use of the `switchTo().alert()` functionality that selenium uses to interact with javascript alert popups. The page object [here](https://github.com/robertgates55/frameworkium/blob/master/src/test/java/com/frameworkium/pages/web/JavaScriptAlertsPage.java) contains the methods that accept, dismiss, cancel, ok, and enter text to a variety of different native JS popups. These are summarised below:

```java
//To accept an alert (eg click 'yes' or 'accept' or 'ok'
driver.switchTo().alert().accept();

//To dismiss or cancel an alert (eg click 'no' or 'dismiss' or 'cancel')
driver.switchTo().alert().dismiss();

//To enter text on an alert requiring text entry
driver.switchTo().alert().sendKeys(textToEnter);

//To enter authentication on an alert requiring a username & password
Credentials credentials = new UsernamePasswordCredentials("username", "password");
driver.switchTo().alert().authenticationWith(credentials);
```
## Handling file pickers - eg 'Choose Files' button

In order to upload a file to a site, the 'choose files' input control is used. To a user, this will open a file browser on whatever platform they're on. To selenium, clicking this link will open a screen that it then cannot interact with.

In order to get around this, we can SendKeys(/path/to/file) directly on the input control - eg `chooseFilesInputButton.sendKeys("/path/to/file");`, which bypasses the file browser that selenium cannot handle.

The example below demonstrates how to perform this on the [HeroKu File Upload](http://the-internet.herokuapp.com/upload) page. The full example page object can be seen [here](https://github.com/robertgates55/frameworkium/blob/master/src/test/java/com/frameworkium/pages/web/FileUploadPage.java) and the test that uses this [here](https://github.com/robertgates55/frameworkium/blob/master/src/test/java/com/frameworkium/tests/web/TheInternetHerokuWebTest.java#L140)

```java
@Visible
@Name("Choose Files button")
@FindBy(css = "input#file-upload")
private WebElement chooseFilesButton;

@Visible
@Name("Upload button")
@FindBy(css = "input#file-submit")
private WebElement uploadButton;


@Step("Upload a file by choosing file and then clicking upload")
public FileUploadSuccessPage uploadFile(File filename) {
  chooseFilesButton.sendKeys(filename.getAbsolutePath());
  uploadButton.click();
  return PageFactory.newInstance(FileUploadSuccessPage.class);
}
```

### Why not use AutoIt, Sikuli, or something that interacts with the file browser dialog instead?

Running locally, on your machine, with your config etc, a number of solutions may work perfectly well. However, the main problems come when you want to ramp things up - what about:
- running tests in parallel?
- other browsers - does it behave the same?
- other OSs - mac dialogs are very different to windows etc
- on a grid - more dependencies required (eg AutoIt must be present on all your grid nodes)

We want to try & keep our test pack as scalable and multi-platform as possible - although we're bypassing the OS's file browser by sending keys directly to the input control here, it's important to remember our main focus is testing _our application_ - not the browser's file picker functionality.
