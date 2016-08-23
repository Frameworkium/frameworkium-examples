**Tests that don't _assert_ anything aren't Tests!**

**Only use asserts in your _test_ layer - NEVER in pages!**

Google Truth - `assertThat`

Many assert libraries are available, but we recommend using Google's [Truth](https://google.github.io/truth/) library - it's nice and flexible, produces far more verbose assertion errors, and is already part of frameworkium - just `import static com.google.common.truth.Truth.assertThat;` at the top of your test.

Some examples:

Basics

```java
assertThat(someInt).isEqualTo(5);
assertThat(aString).isEqualTo("Blah Foo");
assertThat(aString).contains("lah");
assertThat(foo).isNotNull();
```

Collections and Maps

```java
assertThat(someCollection).contains("a");                       // contains this item
assertThat(someCollection).containsAllOf("a", "b").inOrder();   // contains items in the given order
assertThat(someCollection).containsExactly("a", "b", "c", "d"); // contains all and only these items
assertThat(someCollection).containsNoneOf("q", "r", "s");       // contains none of these items
assertThat(aMap).containsKey("foo");                            // has a key
assertThat(aMap).containsEntry("foo", "bar");                   // has a key, with given value
assertThat(aMap).doesNotContainEntry("foo", "Bar");             // does not have the given entry
```

See [here](http://google.github.io/truth/usage/#built-in-propositions) for many many more examples.