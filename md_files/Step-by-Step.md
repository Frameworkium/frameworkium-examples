# A Step by Step Guide

## Development Machine Setup
You can either:

* Use our [Vagrant VM](https://github.com/robertgates55/frameworkium-vagrant)

**OR** use chocolatey:

 * Browse to [Chocolatey](https://chocolatey.org/)
 * Open a cmd window as an admin & copy paste the `@powershell ....` text from the chocolatey homepage
 * Once installed, run `choco install firefox jdk8 git eclipse maven -y`

**OR** install:

* [Firefox](https://www.mozilla.org/en-GB/firefox/new/)
* [Java (JDK 8)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
 * Set your JAVA_HOME environment variable to be the location of your JDK e.g. `C:\Program Files\Java\jdk1.8.0_40`
* [git](http://git-scm.com/downloads)
* [eclipse](https://www.eclipse.org/downloads/)
* [maven 3](http://maven.apache.org/download.cgi)
 * extract it to `C:\maven-3.2.5\`, for example, 
 * then add `C:\maven-3.2.5\bin` to your `PATH`

## Frameworkium
either:
 1. Clone the latest `git clone https://github.com/robertgates55/frameworkium`
 2. Create a branch for your work `git checkout -b my_branch_name`
  * Tip: Understand [how to use git](http://git-scm.com/book/en/v2)
 3. Look to store 

or:
 1. Download the frameworkium-master zip file
 2. Extract the zip
 3. Make sure you put your code in version control!

### Eclipse Configuration
* Use IntelliJ
or
* Enable **Save Actions** in `Window -> Preferences -> Java -> Editor -> Save Actions`
* Install TestNG `Help -> Eclipse Marketplace`. Search for TestNG and install
 * Tip: If your environment uses a proxy to connect to the internet, you'll need to configure proxy settings in eclipse > preferences > general > network connections

### Import Project

Import Frameworkium into **IntelliJ**:

1. `File -> new -> Project from existing sources` select the `pom.xml` file.
  * Wait for maven to download the project dependencies

Import Frameworkium into **Eclipse**:

1. `File -> Import` then select **Existing Maven Projects** and find your local frameworkium
 * Wait for maven to download the project dependencies
  
 * Tip: If your environment uses a proxy to connect to the internet, you'll need to configure MAVEN's proxy settings, by editing the maven settings file (found in your maven folder) - to enable maven to get out to the internet to download the dependencies
 
### Sanity Check
1. Expand the project to the 'tests' level
2. Right click the `com/frameworkium/tests/web/TheInternetHerokuWebTest.java` file and choose `Run As -> TestNG Test`
 * The sample "The Internet" tests should now run
  * Tip: If your environment uses a proxy, firefox will by default use whatever settings internet explorer is using for it's proxy - ensure the internet is accessible via IE first

### Your Tests

1. Start by looking at the existing example tests and pages e.g. `TheInternetHerokuWebTest` and `WelcomePage` in the `com.frameworkium.pages.web` package
2. Create your own package for your test scripts and page objects e.g. `com.mycompany.myproject.tests` and `com.mycompany.myproject.pages`

## Other Browsers

* Chrome
 1. [Download Chrome Driver](https://sites.google.com/a/chromium.org/chromedriver/)
 2. Place the _chromedriver.exe_ on your PATH
 3. Run `mvn clean verify -Dbrowser=chrome`
* IE
 1. [Download IE Driver](https://code.google.com/p/selenium/wiki/InternetExplorerDriver)
 2. Place the _IEDriverServer.exe_ on your PATH
 3. Run: `mvn clean verify -Dbrowser=ie`
* PhantomJS
 1. [Download PhantomJS](http://phantomjs.org/)
 2. Start PhantomJS in Remote WebDriver mode: `phantomjs --webdriver=9876`
 3. Run `mvn clean verify -Dbrowser=phantomjs -DgridURL=http://localhost:9876/wd/hub`
