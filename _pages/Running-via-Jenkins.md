---
layout: post
title:  "Running via Build Tool (eg Jenkins)"
category: wiki
section: 6 - Advanced Usage
order: 9
---

## Why bother?

- It encourages good source control practice
- You can kick stuff off and leave it overnight
- It can be triggered by other builds
- It's much more reliable than custom 'runner' scripts
- You can set default parameters so you don't mistype things
- It saves results from previous executions, including [Allure](http://allure.qatools.ru/) reports

## What you need

- [Allure Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Allure+Plugin)

## Parameters

- Set up build parameters for each (or the ones you'll need) of the [command line variables](http://github.com/robertgates55/frameworkium/wiki/Command-Line-Interface) we can pass in
- eg a variable called `BROWSER` which has a dropdown list of firefox, chrome, safari, etc
- Pass these parameters into the relevant section of the maven build job - eg `mvn test -Dbrowser=$BROWSER`
