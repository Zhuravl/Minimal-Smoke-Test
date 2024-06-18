# The minimal Test Automation Framework for the GUI Smoke Testing
The framework is designed to launch the smoke test after a branch deployment. 
This test will verify that the provided user can log in to the web portal using the Chrome browser. 
Finally, an execution result will be provided in the console.

## Requirements: 
- Having Java 11 (Java 17 is better, based on the https://www.selenium.dev/blog/2023/java-8-support/)
- Having the latest Google Chrome browser installed
- Having the `webdrivermanager-5.7.0-fat.jar` and `SmokeTest.java` files placed in the system

## Compilation:
To compile (is executed one time while setting up): `javac -cp webdrivermanager-5.7.0-fat.jar SmokeTest.java`

## Execution:
To execute the code: `java -cp .:webdrivermanager-5.7.0-fat.jar SmokeTest {WEBSITE_ADDRESS} {USER_LOGIN} {USER_PASSWORD}`