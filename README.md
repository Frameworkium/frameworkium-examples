Frameworkium [![Build Status][status-svg]][status]
==================================================

This project is based on Ardesco's [Selenium-Maven-Template][ardesco] and 
Joe VDW's [Bootstrapium][bootstrapium] with some handy added extras for getting 
started quickly with Selenium, Appium and [Rest Assured][rest-assured].

This is a *sample project* which utilises [frameworkium-core][frameworkium-core], 
a framework for writing maintainable Selenium and REST API tests that also makes 
integrating with other test things (e.g. JIRA) much easier.

As a result:
* please raise issues against the [frameworkium-core][frameworkium-core] project (https://github.com/Frameworkium/frameworkium-core/issues)
* please see the frameworkium-core releases page (https://github.com/Frameworkium/frameworkium-core/releases) for information about changes made and features added
* Don't be worried if it doesn't look like this codebase has been updated recently - chances are, the underlying project has!
* please update the `pom.xml` downloaded with this sample project to keep up to date with the latest releases of the underlying frameworkium-core project, by modifying the following block:
```xml
  <dependencies>
    <dependency>
      <groupId>com.github.frameworkium</groupId>
      <artifactId>frameworkium-core</artifactId>
      <version>2.1.4</version> <!--Update this number with the latest from the frameworkium-core releases page-->
    </dependency>
  </dependencies>
```
  

## Getting started

After setting up [apache maven][mvn], open the `frameworkium` directory in a 
terminal/command prompt and run `mvn clean verify` to run the example tests using Firefox.

However, this only works for Firefox versions earlier than 47. You will need to either:
downgrade Firefox, use [Marionette][marionette], use a different browser or use a grid.

### Stuff you can do

Want to run the tests on a different browser?
No problem, just provide the 'browser' argument:

```
mvn clean verify -Dbrowser=chrome 
```

For chrome, [ChromeDriver][chromedriver] needs to be on your path or specified
as an argument:
```
mvn clean verify -Dbrowser=chrome -Dwebdriver.chrome.driver=c:\path\to\your\chromedriver.exe
```

Want to run tests using a grid and in parallel?
```
mvn clean verify -Dbrowser=chrome -DgridURL=http://localhost:4444/wd/hub -Dthreads=4
```

All you need to do is ensure the browser is installed in the default location.

Running mobile web tests using Appium on Sauce Labs is only slightly more involved:

```bash
export SAUCE_USERNAME=<username>
export SAUCE_ACCESS_KEY=<access_key>
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
[mvn]: https://maven.apache.org/download.cgi
[marionette]: https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette
[chromedriver]: https://sites.google.com/a/chromium.org/chromedriver/home
[frameworkium-core]: https://github.com/Frameworkium/frameworkium-core
[guidance]: http://frameworkium.github.io/frameworkium/
[allure]: http://allure.qatools.ru
