---
layout: post
title:  "Multiple Test Environments"
category: wiki
section: 6 - Advanced Usage
order: 7
---

### Problem
When a team have multiple staging environments for different purpose within the same project (eg QA, DevInt, Staging), we often need to parameterise multiple variables (Eg urls, usernames, passwords)

### Solution
Store the details for all environments in a properties file, and pass an environemnt 'key' at runtime to tell the code which parameters to use.

#### Create a properties file
The properties file must be in your */resources* folder. In your properties file, define the key and value pair for each URL and any other information.

In this case:

* `qa` points to http://qa.com
* `staging` points to http://staging.com

```
//config.properties file
qa.baseURL=http://qa.com
qa.username=ninja
qa.password=turtle

staging.baseURL=http://staging.com
staging.username=rick
staging.password=morty

//add more keys as needed
```

#### Create a config property reader

```java
public class Config {
    private static final Properties properties = new Properties();
    private static final String environmentPrefix;

    /* initialise data, the key defaults to this when none is specified at command line */
    static {
        initPropertiesFromFile();
        environmentPrefix = System.getProperty("environmentKey", "staging") + ".";
    }

    private static void initPropertiesFromFile() {
        try (InputStream stream =
                     Config.class.getResourceAsStream("/config.properties")) {
            properties.load(stream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getProperty(String s) {
        return properties.getProperty(environmentPrefix + s);
    }

    /* getters for environment properties */

    public static String getBaseURL() {
        return getProperty("baseURL");
    }

    public static String getUsername() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("password");
    }
```

#### Use the values from the Config in the Page Object/Test

In your *tests* layer:

```java
      XYZPage xyzPage = XYZPage.open();
      xYZPage.typeNameTextBox(Config.getUsername())
             .then().typePasswordTextBox(Config.getPassword())
             .then().clickLoginButton();
```

And in your *pages* layer:

```java
    @Step("Navigate to XYZ Page")
    public static XYZPage open() {
        return PageFactory.newInstance(XYZPage.class,
                Config.getBaseURL() + "welcome.com");
    }
```

#### Specify which environment to use via command line when executing tests
Choose which environment to run your test in by specifying  the corresponding "key"

`mvn clean verify -DenvironmentKey=staging`

OR

`mvn clean verify -DenvironmentKey=qa`
