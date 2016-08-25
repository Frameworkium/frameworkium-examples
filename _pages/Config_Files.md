---
layout: post
title:  "Using Config yaml files Rather than Command Line params"
category: wiki
section: 6 - Advanced Usage
order: 0
---

More detail soon... but rather than providing all of the details in the command line, you can instead create config files (in your `resources` folder) to store common configurations. An example would be:

`/resources/config/FirefoxGrid.yaml`:

```yaml
browser: Firefox
firefoxProfile:
browserVersion:
platform:
platformVersion:
device:
captureURL:
gridURL: http://localhost:4444/wd/hub
build:
appPath:
sauce:
browserStack:
jiraURL:
spiraURL:
resultVersion:
zapiCycleRegEx:
jqlQuery:
sutName:
sutVersion:
jiraResultFieldName:
jiraResultTransition:
jiraUsername:
jiraPassword:
maximise:
resolution:
proxy:
maxRetryCount: 2
```

and you'd then use this config file by running:

```bash
mvn clean verify -Dconfig=FirefoxGrid.yaml
```