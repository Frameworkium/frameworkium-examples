Frameworkium Examples [![Build Status][status-svg]][status]
==================================================

This is a *sample project* which utilises [frameworkium-core][frameworkium-core], 
a framework for writing maintainable Selenium and REST API tests that also makes 
integrating with other test things (e.g. JIRA) much easier.

As a result:
* Please [raise issues][core-issues] against the [frameworkium-core][frameworkium-core] project, not this one
* Please see the [frameworkium-core releases page][core-releases] for information about changes made and new features
* This example project is not updated as regularly as the [core project][frameworkium-core]
* To keep up to date with the latest releases of core, modify the following block in the `pom.xml`:
```xml
<dependencies>
  <dependency>
    <groupId>com.github.frameworkium</groupId>
    <artifactId>frameworkium-core</artifactId>
    <!-- Update this with the latest from the frameworkium-core releases page -->
    <version>2.3.0</version>
  </dependency>
</dependencies>
```

The Frameworkium project is based on Ardesco's [Selenium-Maven-Template][ardesco] and 
Joe VDW's [Bootstrapium][bootstrapium]. We have extended it with some handy extras
for getting started quickly with Selenium, Appium and [Rest Assured][rest-assured].

## Getting Started

After setting up [apache maven][mvn], open the `frameworkium` directory in a 
terminal/command prompt and run `mvn clean verify` to run the example tests using Firefox.

However, this now only works provided you have the [geckodriver][geckodriver] 
on your path and are using Firefox version 48 or above.

### Browsers

You can provide the 'browser' argument to chose a browser to run the tests in.

#### Drivers
Since frameworkium-core v2.3.0 (which included Selenium v3.0.1) each browser 
requires a "driver".

For chrome, [ChromeDriver][chromedriver] needs to be on your path or specified
as an argument:
```
mvn clean verify -Dbrowser=chrome -Dwebdriver.chrome.driver=c:\path\to\chromedriver.exe
```

For Firefox 48 and above, [geckodriver][geckodriver] needs to be on your path or specified
as an argument:
```
mvn clean verify -Dbrowser=firefox -Dwebdriver.gecko.driver=c:\path\to\geckodriver.exe
```

Firefox 47 and below have the driver built in, as such tests can be run by specifying
the `legacyFirefox` browser:
```
mvn clean verify -Dbrowser=legacyFirefox
```

### Selenium Grid

Want to run tests using a grid and in parallel?
```
mvn clean verify -Dbrowser=chrome -DgridURL=http://localhost:4444/wd/hub -Dthreads=4
```

All you need to do is ensure the browser is installed in the default location.

### Sauce Labs

Running mobile web tests using Appium on Sauce Labs is only slightly more involved:

```bash
export SAUCE_USERNAME=username
export SAUCE_ACCESS_KEY=access_key
mvn clean verify -Dplatform=ios -Dbrowser=safari -Dsauce=true 
```

A full list of arguments can be found on the [guidance page][guidance].

### Reporting

After running your tests, you can generate an [Allure][allure] test report by 
simply running:

```
mvn site 
```

## Further Information

Frameworkium sets you up for other stuff too - check out the
[guidance page][guidance] for further info.

[status-svg]: https://travis-ci.org/Frameworkium/frameworkium.svg?branch=master
[status]: https://travis-ci.org/Frameworkium/frameworkium
[ardesco]: https://github.com/Ardesco/Selenium-Maven-Template
[bootstrapium]: https://github.com/jvanderwee/bootstrapium
[rest-assured]: http://rest-assured.io/
[frameworkium-core]: https://github.com/Frameworkium/frameworkium-core
[core-issues]: https://github.com/Frameworkium/frameworkium-core/issues
[core-releases]: https://github.com/Frameworkium/frameworkium-core/releases
[mvn]: https://maven.apache.org/download.cgi
[geckodriver]: https://github.com/mozilla/geckodriver/releases
[marionette]: https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette
[chromedriver]: https://sites.google.com/a/chromium.org/chromedriver/home
[guidance]: http://frameworkium.github.io/
[allure]: http://allure.qatools.ru
