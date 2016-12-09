---
layout: post
title: "Frameworkium vs frameworkium-core"
section: 1 - Whats The Point?
order: 2
category: wiki
---
[`frameworkium`](https://github.com/Frameworkium/frameworkium) is the base project, designed for test engineers to download, clone, and generally make their own. It comes with a load of example tests, for both web automation & rest api, which should hopefully give a pretty clear idea of how to structure new tests. But that's pretty much it - it's just a quickstart project.

[`frameworkium-core`](https://github.com/Frameworkium/frameworkium-core) is a separate project, which contains (and tucks away) all of the magic that helps to simplify & keep tidy your tests. **You do not need to clone/edit/touch it!** (unless you want to help improve it by submitting a pull request!)
It's updated [pretty frequently](https://github.com/Frameworkium/frameworkium-core/releases) and to update to using the latest all you need to do is find and update the lines in your **frameworkium** project's `pom.xml` file:

``` xml
<dependency>
  <groupId>com.github.frameworkium</groupId>
  <artifactId>frameworkium-core</artifactId>
  <version>2.3.1</version>
</dependency>
```

Update the version number to the latest on the [releases](https://github.com/Frameworkium/frameworkium-core/releases) page, and _voila_ - you'll get the latest jars and dependencies **(that have already been proven to play nicely together)** pulled down automagically.
