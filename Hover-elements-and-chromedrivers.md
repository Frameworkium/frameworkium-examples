---
layout: post
title:  "Hovering with ChromeDriver"
category: wiki
order: 15
---
This is a known bug associated with chromedrivers and selenium's interaction with mouseover/hover over elements.

When hovering over an element, it appears to immediately "unhover" as though the mouse was moved away for split second. This results in the ho


```java
    public SomePage clickOnStuffInsideHoverMenu(){
        Actions builder = new Actions(driver);
        builder.moveToElement(elementThatNeedsToBeMouseOver).perform(); // Mouse over an the hover element,
        somethingLinkUnderTheMouseOverElement.click();   // element that we want to click but only accessible from a mouseover menu
        return PageFactory.newInstance(SomePage.class);
    }
```

In this example, we want to click on somethingLinkUnderTheMouseOverElement but its only accessible once we mouse over elementThatNeedsToBeMouseOver.



During execution, the element hovers over elementThatNeedsToBeMouseOver but would immediately close as though the mouse was moved away.

