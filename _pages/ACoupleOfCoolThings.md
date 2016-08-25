---
layout: post
title: "A couple of cool things"
section: 1 - Whats The Point?
order: 3
category: wiki
---
To whet the appetite, here's a couple of examples where frameworkium features make your life nicer.

## @Visible

Say you're expecting an element on a webpage, and you want to wait until it's there and visible before clicking on it.

#### Vanilla selenium might look like:

``` java
WebElement button = driver.findElement(By.cssSelector("button#search_button");
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOf(button));
button.click();
```

Sure - you could probably do this with a (longish) one-liner, but if we were trying to make the code nice and maintainable etc, it's going to look roughly like the above.

#### PageFactory would neaten this to:

``` java
//somewhere at the top of your class
@FindBy(css="button#search_button")
private WebElement button;

//and then when you actually need to use it
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOf(button));
button.click();
```

Which is nicer, because
* you've put the css selector for that control in *one* place, rather than repeating it every time you use it. It changes? You update the 1 instance, rather than 5
* pagefactory removes the need for quite so much `driver.` action - again reducing the reuse, overlap, repetition, etc

*(NB If you've never heard of [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory), it's a pattern for using page objects that's part of the selenium libraries - a sort of selenium+)*

#### Frameworkium then builds on this:
``` java
//somewhere at the top of your class
@Visible
@FindBy(css="button#search_button")
private WebElement button;

//and then when you actually need to use it
button.click();
```

By using the `@Visible` annotation, when the page loads you'd automatically wait for the button to be visible. Which even further neatens things - particularly when you imagine there might be 10-20 things on a page that we _might_ want to wait for. The `@Visible` annotation becomes your friend...

There's also an `@Invisible`, and works with List<WebElement>, HtmlElements..... etc
