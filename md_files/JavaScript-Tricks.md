**DO NOT USE ANY OF THESE UNLESS IT'S THE ONLY OPTION LEFT!**

Your tests are supposed to be simulating user actions and user flows, so injecting javascript is not to be used unless some weirdness means that selenium cannot do something that a user can.

### Unhiding hidden controls

**Example**

In order to upload a file to a site, the 'choose files' input control is used. See [Native Controls](https://github.com/robertgates55/frameworkium/wiki/Native-Controls) for how we handle this scenario using the SendKeys directly to input controls.


**Problem**

However, in some cases, the input control might be hidden on the page, with a prettified div used on top of it:

```html
<div id="input-button">
  <input class="hidden"... ... ... >
</div>
```

SendKeys to the div does not have the same effect as SendKeys to the 'input', and because the input control is hidden, selenium cannot interact with it (though you can see it in the html).

**Solution**

The solution is to use a javascript executor in your page object to modify the style of the input button such that selenium can interact with it. The method below demonstrates this.

```java
@Name("Upload input")
@FindBy(css="div#upload-button input")
private WebElement uploadInput;


@Step("Upload a file")
public void tryAnUpload(File fileToUpload)
{
  //Css Locator for the hidden input button
  String cssSelector = "div#upload-button input";

  //Use Javascript executor to make the input button visible
  //'super' as it's using a method on the superclass (BasePage)
  super.executeJS("document.querySelector('" + cssSelector + "').style.width = '200px'");
  super.executeJS("document.querySelector('" + cssSelector + "').style.height = '10px'");
  super.executeJS("document.querySelector('" + cssSelector + "').style.opacity = '100'");

  //Send the file path directly to the input button via sendKeys - this performs the upload
  uploadInput.sendKeys(fileToUpload.getAbsolutePath());

}
```

### Isn't that a bit hacky?
Yes, but automation testing is about simulating user's behaviour as best we can. We could use some other tool (eg autoIt, Sikuli, call the upload javascript directly etc) to click the button and enter the file path using a file picker; but the additional flakiness we're likely to introduce by doing so will likely outweigh the benefit.

Ultimately it's about choosing the simplest (& thus least flaky!) approach to get the job done.