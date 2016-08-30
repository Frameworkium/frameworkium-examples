---
layout: post
title:  "Zephyr for Jira Integration"
category: wiki
section: 5 - Logging & Reporting
order: 8
---

## Test Case Management (TCM) Logging - Zephyr for JIRA

Ideally, your tests should have test case equivalents, with manual steps written out, and perhaps linked and traceable to the original stories/tasks/epics/requirements/etc.

When some of these tests are automated and others are run manually, it can be difficult to combine run results to show the overall test status. By annotating or tagging your tests with their jira ids, and providing your jira instance details, Frameworkium will log the results of test runs to jira in real time - making it much easier to keep track of execution progress.

### 1 - Annotate or Tag your tests

```java
@TestCaseId("JIRA-1411")
public void myLovelyTest() {
	//some testing
}
```

OR, if using BDD:

```cucumber
@TestCaseId:JIRA-1411
Feature: My Lovely Feature that needs testing

  @TestCaseId:JIRA-1412
  Scenario: Or my lovely scenario
```

### 2 - Make sure test is in Zephyr for Jira test plan

Make a Zephyr for Jira test plan, and make sure your your test is in a particular version & test cycle (NB can't be 'Ad Hoc')

### 3 - Provide JIRA details at runtime

```bash
mvn clean verify -DjiraURL=http://some/jira -DjiraUsername=user1 -DjiraPassword=pword -resultVersion="Version 2.14.8"
# If you have the same test in multiple test cycles, you can specify the cycle with:
# -zapiCycleRegEx="Some Cycle"
```


You should see the test gets marked as 'WIP' on start, and then the result is logged when the test finishes.