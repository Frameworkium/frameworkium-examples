---
layout: post
title:  "Layers"
category: wiki
section: 2 - Basics
order: 2
---

Frameworkium encourages the use of page-object and service-object patterns - writing your test code in such a way that abstracts the functionality of the system you're testing into it's own layer so that: *the tests interact with the page or service layer* and *the page or service layer interacts with the system under test*.

Metaphors abound, but in essence: the tests do the decision making, the pages or services do the grunt work.

If you build it right, when the service or page that you're testing changes, but the test doesn't (eg a user still should be able to search for bananas), you just change the one method that conducts that operation, rather than the 15 tests that do banana searches. Likewise, if the id of a button changes following a major UI overhaul, if you've organised things right that ID will only be *in one place (the relevant page object, in fact)* and you can update just that one instance.

```
                  _________        _____________________
                 |         |      ||                   ||
 _________   /-> |  PAGES  |  ->  ||                   ||
|         | /    |_________|      ||   SYSTEM UNDER    ||
|  TESTS  |       _________       ||       TEST        ||
|_________| \    |         |      ||                   ||
             \-> | SERVICES|  ->  ||                   ||
                 |_________|      ||___________________||
```

Going BDD? The same should apply - try and keep core 'page' or 'service' level functionality/methods out of your steps - as there may end up being multiple steps that use the same pages/buttons/endpoints etc - again, you only want to have to update that in one place. Steps are for chaining together operations so that you can keep your features and scenarios as natural-reading as possible.

```
                                  _________        _____________________
                                 |         |      ||                   ||
 __________      _________   /-> |  PAGES  |  ->  ||                   ||
|          |    |         | /    |_________|      ||   SYSTEM UNDER    ||
| FEATURES | -> |  STEPS  |       _________       ||       TEST        ||
|__________|    |_________| \    |         |      ||                   ||
                             \-> | SERVICES|  ->  ||                   ||
                                 |_________|      ||___________________||
```