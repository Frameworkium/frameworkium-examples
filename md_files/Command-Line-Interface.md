Tests can be executed by running `mvn clean verify` followed by any properties you wish to specify.

## General

Property | Description | Values 
----|------|------
` browser `|  The browser on which you wish to run the tests. Defaults to `firefox` if not specified. | ` firefox `, ` chrome `, ` safari `, ` ie `, ` opera `, ` phantomjs `
` browserVersion `| The browser version on which you wish to run the tests. Not mandatory and is only taken into consideration when running remotely e.g. on Selenium Grid, Sauce Labs or BrowserStack | e.g. ` 8.0 `
` groups `| The TestNG test groups which you wish to run. All tests groups will run if not specified. | e.g. ` checkintest `
` test ` | The test class, or list of test classes (separated by commas), to run. Can include wildcards. | ` TflLoginWebTests,Heroku* `
` gridURL `| The URL of your Selenium Grid hub. Mandatory if you wish to run your tests on your Selenium Grid. | e.g. ` http://localhost:4444/wd/hub `
` threads `| The number of threads to use. Defaults to 1 if not specified. | e.g. ` 3 `
` build `| The build version or app version to log to Sauce Labs, BrowserStack, or Capture. Not mandatory. | e.g. ` build-1234 `

## Remote Grids/Different devices & platforms

Property | Description | Values 
----|------|------
` browserStack `| Must be set to true if you wish to run on BrowserStack. Defaults to false. | ` true `, ` false `
` sauce `| Must be set to true if you wish to run on Sauce Labs. Defaults to false. | ` true `, ` false `
` platform `| The platform on which you wish to run the tests. Is only taken into consideration when running remotely. To be specified instead of 'os' when running with BrowserStack. | e.g. ` windows `, ` ios `, ` android `, ` OSX `
` platformVersion `| The platform version on which you wish to run the tests. Is only taken into consideration when running remotely. To be specified instead of 'os_version' when running with BrowserStack. | e.g. ` 5.0 `
` device `| The device on which you wish to run remote tests. If not using SauceLabs or BrowserStack, can be specified with the `-Dbrowser=chrome` parameter to instigate a Chrome browser emulator of the specified device. | ` iPhone `, ` iPad `, ` iPhone Retina 4-inch `, ` Galaxy S4 `, etc….

### Remote Supported Devices/Platforms
**BrowserStack:** https://www.browserstack.com/list-of-browsers-and-platforms

**SauceLabs:** https://saucelabs.com/platforms

## Jira/Zephyr/Test Result Logging Integrations:

Property | Description | Values 
----|------|------
` jiraURL `| The base URL of the JIRA instance you want to use | e.g. ` http://jira:8080 `
` jiraUsername `| The JIRA user you want to use | e.g. ` rgates `
` jiraPassword `| The JIRA user's password | e.g. ` password `
` jqlQuery `| the JQL query to use to look up the JIRA tests to run (the results of the query will be looked up against the @Issue annotations on tests | e.g. ` (priority=1 and component=Admin) or issueKey=JIRA-123 `
` jiraResultFieldName `| The jira field name to attempt to log results to for the specified @Issue. The values to change the field to are specified in the jira config file. Useful if you're using a jira field to mark the test result | e.g. `Test Result`
` jiraResultTransition `| If specified, will attempt to transition the @Issue specified through the transitions specified in the jira config. Useful if using a customised jira workflow for managing test results, for example | e.g. `true`
` resultVersion `| The 'Version' to mark the test execution against in Zephyr for JIRA (requires ZAPI) | e.g. ` App v1.1.2 `
` zapiCycleRegEx `| If the Zephyr test cycle name contains this string test results will be logged against the matching cycles. If not specified, no further filtering of cycles will happen. | e.g. `firefox` or `my-special-cycle`


## Examples

Running web tests using Firefox:

```bash
mvn clean verify
```

Running web tests using Chrome:

```bash
mvn clean verify -Dbrowser=chrome
```

Running web tests on Firefox 34.0.5 with Selenium Grid:
```bash
mvn clean verify -Dbrowser=firefox -DbrowserVersion=34.0.5 -DgridURL=http://localhost:4444/wd/hub
```

Running test methods which match the pattern `testM*` on Firefox 36 with Selenium Grid and Capture:
```bash
mvn clean verify -Dtest=TestClass#testM* -Dbrowser=firefox -DbrowserVersion=36 -DgridURL=http://grid:4444/wd/hub -DsutName="My Project" -DsutVersion=0.0.1 -DcaptureURL=http://capture:5000
```

Running mobile web tests on Chrome, using their device emulation:
```bash
mvn clean verify -Dbrowser=chrome -Ddevice="Apple iPad 3 / 4"
```

Running mobile web tests on BrowserStack Win XP Firefox 33:

```bash
export BROWSER_STACK_USERNAME=<username>
export BROWSER_STACK_ACCESS_KEY=<access_key>
mvn clean verify -DbrowserStack=true -Dbrowser=firefox -DbrowserVersion=33 -Dplatform=Windows -DplatformVersion=XP
```

Running mobile web tests on Sauce Labs iOS 8.0 iPad Simulator:

```bash
export SAUCE_USERNAME=<username>
export SAUCE_ACCESS_KEY=<access_key>
mvn clean verify -Dsauce=true -Dplatform=ios -Dbrowser=safari -DplatformVersion=8.0 -Ddevice="iPad Simulator"
```

Running mobile web tests on BrowserStack iOS iPad Air (real device):

```bash
export BROWSER_STACK_USERNAME=<username>
export BROWSER_STACK_ACCESS_KEY=<access_key>
mvn clean verify -DbrowserStack=true -Dbrowser=ios -Ddevice="iPad Air"
```
NB - platform and platformVersion (os & os_version in BrowserStack config) are not required or supported when running on mobile devices


Running mobile app tests on Sauce Labs Android Emulator:

```bash
export SAUCE_USERNAME=<username>
export SAUCE_ACCESS_KEY=<access_key>
mvn clean verify -Dsauce=true -Dplatform=android -DappPath=<path_to_.apk>
```

Run regression tests (as marked in JIRA with the label REGRESSION) and log test results against the v1.1.2 version in JIRA
```bash
mvn clean verify -Dbrowser=firefox -DjiraURL=http://jira:8080 -DjiraResultVersion=v1.1.2 -DjqlQuery=labels=REGRESSION
```




For full lists of platforms/browsers supported see:
[BrowserStack](https://www.browserstack.com/list-of-browsers-and-platforms?product=automate) and [SauceLabs](https://saucelabs.com/platforms/) platform lists.