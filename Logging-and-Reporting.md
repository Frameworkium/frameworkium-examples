---
layout: post
title:  "Logging and Reporting"
category: wiki
order: 7
---

# Logging

Each test run generates a log as defined in the log4j.xml

# Reporting

You can generate an [Allure](http://allure.qatools.ru/) test report by simply running:

``` bash
mvn site
```

Open target/site/allure-maven-plugin.html to view the report.

This will interpret @Step, @Issue, @Features and @Story annotations, and provide rich reporting on the suite just run.

# Jenkins Reporting

When run via Jenkins, the [allure-jenkins-plugin](https://github.com/allure-framework/allure-jenkins-plugin) can be added to the jenkins job, and will automatically produce and store reports for every job run.