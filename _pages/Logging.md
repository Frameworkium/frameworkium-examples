---
layout: post
title:  "Logging"
category: wiki
section: 5 - Logging & Reporting
order: 7
---

## Logging

Each test run generates a log as defined in the log4j.xml

By default, all contents will push to `frameworkium.log`, available in the `/logs/` folder.

If you want to write to this log (useful for debugging and for other bits and bobs), you should instantiate a new `logger` in the class from which you're logging. Eg:

``` java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeClass extends BasePageOrBaseTestMaybe {

    private Logger logger = LogManager.getLogger(SomeClass.class);

    public void someMethod() {
    	logger.info("I'm logging an info message");
    	logger.warn("I'm logging a warn message");
    	logger.debug("I'm logging a debug message");
    	logger.error("I'm logging an error message");
    	//etc
    }
}
```