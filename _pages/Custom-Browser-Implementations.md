---
layout: post
title:  "Custom Browser Implementations"
category: wiki
section: 6 - Advanced Usage
order: 12
---

## Custom Browser Implementations

Sometimes, one needs to open browsers & devices with certain capabilities and flags set. This is achieved in the webdriver protocol by `DesiredCapabilties`, and frameworkium provides a simple mechanism to set these, whilst continuing to handle the eventual browser instantiation behind the scenes.

The solution is to create a new java class extending `AbstractDriver` somewhere in your test code, which sets up the DesiredCapabilities and WebDriver as you require them; then reference this class (by name) using the `-DcustomBrowserImpl` parameter at runtime.

### Running chrome in incognito mode example:

Example would be to create the class `ChromeIncognitoImpl.java` somewhere in your test code:

```java
//package name...
//imports...

public class ChromeIncognitoImpl extends AbstractDriver {

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }

    @Override
    public WebDriver getWebDriver(DesiredCapabilities capabilities) {
        return new ChromeDriver(capabilities);
    }

}
```

and then run your tests with either :

`mvn clean verify -Dbrowser=custom -DcustomBrowserImpl=ChromeIncognitoImpl`

or more simply:

`mvn clean verify -DcustomBrowserImpl=ChromeIncognitoImpl`

(as whenever `-DcustomBrowserImpl` is provided, the browser type defaults to `custom`)

See [here](https://github.com/Frameworkium/frameworkium-core/tree/master/src/main/java/com/frameworkium/core/ui/driver/drivers) for the default implementations used in frameworkium-core, and if you make a better default implementation (or just something cool) submit us a pull request (or gist, or anything)! 
