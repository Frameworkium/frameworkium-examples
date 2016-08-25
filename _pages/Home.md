---
layout: post
title:  "Intro"
category: intro
order: 0
---

**Frameworkium** is a template designed to get up and running quickly with Selenium and Appium. By abstracting away the complex setup and configuration, Frameworkium enables you to write more reliable and maintainable automated tests which you can run against multiple platforms and browsers with ease.

**Important:** The frameworkium core code has been moved away from this repository and is bundled as a dependancy inside this project. This is to allow version control. Download this project and import it into your preferred IDE, and the frameworkium code will automatically be included.

Frameworkium-core repo _(if required!)_: https://github.com/Frameworkium/frameworkium-core

## Getting Started

Clone this project and (if you want to run via phantomJS or chrome) ensure [PhantomJS](http://phantomjs.org) and [chrome-driver](https://sites.google.com/a/chromium.org/chromedriver/) are on your path.

Open the frameworkium directory in a terminal window/command prompt and run the following to execute the example tests using Firefox.

```bash
mvn clean verify
```

Want to run your tests on a different browser? No problem, just provide the 'browser' property:

```bash
mvn clean verify -Dbrowser=chrome
```

Running your mobile web tests using Appium on Sauce Labs is only slightly more involved:

```bash
export SAUCE_USERNAME=<username>
export SAUCE_ACCESS_KEY=<access_key>
mvn clean verify -Dplatform=ios -Dbrowser=safari -Dsauce=true
```

A full list of commands can be found on the [Command Line Interface](https://github.com/Frameworkium/frameworkium/wiki/Command-Line-Interface) page.

After running your tests, you can generate an [Allure](http://allure.qatools.ru) test report by simply running:

```bash
mvn site
```