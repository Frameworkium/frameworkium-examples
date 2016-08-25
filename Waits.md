---
layout: post
title:  "Waits"
category: wiki
order: 3
---

**Only use waits in your page object methods - _never_ in your tests**

You shouldn't need to do many waits - the pagefactory layer and @Visible tags will handle the majority of your waits behind the scenes.

However - there are times when you'll need to wait. For example:
 - we want to click a button
 - the button is initially hidden; but made visible by linking the 'more' arrow

So we want to click the 'more' arrow, then wait for the button to be visible before clicking on it. We use the `wait.until` and `ExpectedConditions`, as in the following example:

```java
@Visible
@Name("More Arrow")
@FindBy(css = "div#more-arrow")
private WebElement moreArrow;

@Name("Initially hidden button")
@FindBy(css = "div#button")
private WebElement initiallyHiddenButton;



public Page clickInitiallyHiddenButton()
{
  moreArrow.click();
  wait.until(ExpectedConditions.visibilityOf(initiallyHiddenButton));
  initiallyHiddenButton.click();
  return this;
}
```

`ExpectedConditions` has lots of methods to help your waits - e.g. `elementToBeSelected()`, `titleContains()`, `textToBePresentInElement()`, `textToBePresentInElementValue()`, etc. - see [here](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html) for the full list

We have introduced our own extension to `ExpectedConditions` called `ExtraExpectedConditions`.

NB - Unfortunately Framworkium has implicit waits due to our use of HtmlElements. Ideally we wouldn't to try and encourage a more judicious use of waits, ensure tests fail fast, and aid debugging - "timed out waiting for visibility of element a" is a much more obvious error message than "error while clicking element a", for example.