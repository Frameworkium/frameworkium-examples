Frameworkium [![Build Status][status-svg]][status]
==================================================

This project is based on Ardesco's [Selenium-Maven-Template][ardesco] and 
Joe VDW's [Bootstrapium][bootstrapium] with some handy added extras for getting 
started quickly with Selenium and Appium.

This is a sample project which utilises [frameworkium-core][frameworkium-core], 
a framework for writing maintainable Selenium and REST API tests that also makes 
integrating with other test things, e.g. JIRA, much easier.

## Getting started

After setting up [apache maven][mvn], open the `frameworkium` directory in a 
terminal/command prompt and run `mvn clean verify` to run the example tests using Firefox.

### Stuff you can do

Want to run the tests on a different browser?
No problem, just provide the 'browser' argument:

```
mvn clean verify -Dbrowser=chrome 
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

A full list of arguments can be found on the [project wiki][wiki].

### Reporting

After running your tests, you can generate an [Allure][allure] test report by simply running:

```
mvn site 
```

## Further Information

Frameworkium sets you up for other stuff too - check out the [project wiki][wiki] for further info.

[status-svg]: https://travis-ci.org/Frameworkium/frameworkium.svg?branch=master
[status]: https://travis-ci.org/Frameworkium/frameworkium
[ardesco]: https://github.com/Ardesco/Selenium-Maven-Template
[bootstrapium]: https://github.com/jvanderwee/bootstrapium
[mvn]: https://maven.apache.org/download.cgi
[frameworkium-core]: https://github.com/Frameworkium/frameworkium-core
[allure]: http://allure.qatools.ru
[wiki]: https://github.com/Frameworkium/frameworkium/wiki
