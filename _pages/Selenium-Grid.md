---
layout: post
title:  "Selenium Grid"
category: wiki
section: 6 - Advanced Usage
order: 1
---

We've already shown that you can use Frameworkium to run your tests on a grid, just by specifying the gridURL parameter at runtime:
```bash
mvn clean verify -DgridURL=http://someurl:4444/wd/hub
```

Setting up a grid using the selenium standalone jar is easy enough, but managing larger grids, and updating the dependencies along the way (eg DriverServer, jars, paths etc) on each of your nodes can be a bit of a pain.

The [Selenium Grid Extras](http://github.com/groupon/Selenium-Grid-Extras) project aims to take the pain out of this. You just run (or have a batch script set up to automatically run)

```bash
java -jar SeleniumGridExtras-1.7.1-SNAPSHOT-jar-with-dependencies.jar
```

and it handles the rest. It can set up nodes, hubs, or combined hubs and nodes; records videos of the executions, automatically installs & configures all the drivers you'll need (and auto-update them to the latest versions), kill stale sessions & broken browsers, and even periodically reboot machines to keep your grid up with minimal maintenance. Download the latest version from [here](http://github.com/groupon/Selenium-Grid-Extras/releases).