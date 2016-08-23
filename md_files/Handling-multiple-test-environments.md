#### Problem
When a team have multiple staging environments for different purpose within the same project, we face the problem where the test websites has different URLs but are essentially the same thing. This poses a problem that leads to having multiple copies of code that handles each URL.
Here is how to have all of the different URLs in one, easy to maintain place.
          
Example of 2 staging environments with the same website:   
***staging environment #1***    
[http://staging1/welcome.com] (https://github.com/robertgates55/frameworkium/wiki/Handling-multiple-test-environments)

***staging environment #2***    
[http://staging2/welcome.com] (https://github.com/robertgates55/frameworkium/wiki/Handling-multiple-test-environments)

#### Solution
In order to cater to multiple URLs of the same project, we store the URLs in a properties file and feed them in  with ```getResourcesAsStream```. In the same vein, we could use the properties file to store other details such as login credentials

#####Create a properties file 
The properties file must be in your */resources* folder. In your properties file, define the key and value pair for each URL and any other information.     
In this case,    
key1 points to http://staging1   
key2 points to http://staging2   
```
//config.properties file
key1.baseURL=http://staging1/
key1.username=ninja
key1.password=turtle

key2.baseURL=http://staging2/
key2.username=rick
key2.password=morty

//add more keys as needed
```
#####Create a config property reader
```java
public class Config {
    private static final Properties properties = new Properties();
    private static final String environmentPrefix;

    /* initialise data, the key defaults to this when none is specified at command line */
    static {
        initPropertiesFromFile();
        environmentPrefix = System.getProperty("environmentKey", "key1") + ".";
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

##### Use the values from the Config in the Page Object/Test
---
```java
    @Step("Navigate to XYZ Page")
    public static XYZPage open() {
        return PageFactory.newInstance(XYZPage.class,
                Config.getBaseURL() + "welcome.com");
    }
```
---
```java
      XYZPage xyzPage = XYZPage.open();
      xYZPage.typeNameTextBox(Config.getUsername())
             .then().typePasswordTextBox(Config.getPassword())
             .then().clickLoginButton();
```
---
#####Specify which environment to use via command line when executing tests
Choose which environment to run your test in by specifying  the corresponding "key"
```
mvn -clean -verify -DenvironmentKey=key1
OR
mvn -clean -verify -DenvironmentKey=key2 
```