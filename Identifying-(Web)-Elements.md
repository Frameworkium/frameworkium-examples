---
layout: post
title:  "Identifying Web Elements"
category: wiki
section: 4 - Page Object Guidance
order: 5
---
As per the examples on the [Page Objects](https://github.com/Frameworkium/frameworkium/wiki/Page-Objects) page, we identify elements on Web pages using the @FindBy annotation, and passing in selector strings.

Try to pick selectors that are:
* least likely to change
* most likely to be unique

###@FindBy(css = "input#fromButton")
css selectors. _These are the preferred means of identifying controls_. Css selectors are generally easier to read than xpath, and generally as fast or faster than xpath. See [here](http://flukeout.github.io) for an interactive game to help you learn the syntax

Click [here](http://www.cheetyr.com/css-selectors) for a cheat sheet for css selectors

Firebug for Firefox allows you to identify and test your css selectors before you put them into your pages.

###@FindBy(linkText = "Click here to view")
linkText does exactly what it says on the tin - searches for any links on the page that display the text specified. _BEWARE_ - often the same text will be used in multiple places on a page, so use this with caution

###@FindBy(xpath = "//div")
xpath selectors. Useful for when you need to identify an element based on the text _within_ an element, as you can specify "contains":

eg: `//div[contains(.,'Click here')]` will select the div `<div>Click here</div>`

Xpath test plugins for chrome and firefox are available, which allow you to test your selector before putting it into your page.

###Tips
* If you can, try to select the actual element that you want to perform the operation on. eg `<div id="link-button"><a href="blah">Link</a></div>` -> `css="div#link-button a"` will be more robust to _click_ than `css="div#link-button"` since it's actually the link that you want - eg some browsers will treat the entire div as the link, others may not

* **Element Visibility** -  Selenium will not find hidden controls on the page. This is on purpose, since it's trying to simulate the activities of a real user. However, if it's the ONLY way, you can use javascript injection to 'unhide' controls. See [this]() example.

* **Auto-Generated tags** - the naming conventions of buttons will entirely depend on the framework used. Avoid using auto-generated 'id' tags, for example, as these tend to get regenerated when new pages/controls are added