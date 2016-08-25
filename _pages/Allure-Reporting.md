---
layout: post
title:  "Allure Reporting"
category: wiki
section: 5 - Logging & Reporting
order: 7
---

You can generate an [Allure](http://allure.qatools.ru/) test report by simply running:

``` bash
mvn site
```

Open target/site/allure-maven-plugin.html to view the report.

*(NB if you try and open the file locally in chrome, chrome doesn't like opening file://blah files and the report won't display properly. Either open via IntelliJ (they host it on a local webserver for you) or use another browser!)*

This will interpret @Step, @Issue, @Features and @Story annotations, and provide rich reporting on the suite just run.

## Jenkins + Allure Reporting

When run via Jenkins, the [allure-jenkins-plugin](https://github.com/allure-framework/allure-jenkins-plugin) can be added to the jenkins job, and will automatically produce and store reports for every job run.