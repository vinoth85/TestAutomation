UI testing framework
=============

Introduction
-----

Selenium + Cucumber-JVM framework aims for front end regression testing. In this framework the acceptance criteria written in plain English are translated into the Java code by Cucumber. Selenium is used to drive the browser. Test parameters like URL, test data and message etc are managed by Yaml files. Finally cucumber report is generated to display test result.

Prerequisites
-------------
* Install and config Maven (http://maven.apache.org/download.cgi, download apache-maven-3.3.3-bin.tar.gz or above)
* Install Java 1.8
* Install Chrome driver

* Optional -- Install cucumber execution terminal with color (https://github.com/adoxa/ansicon/downloads, download ansi160.zip  --follow its read me)
* Optional -- Install eclipse cucumber feature file editor which can highlight Gherkin key word
 
 
Setup
-----
Import the source code as Maven project, run "mvn clean install" to install maven dependency.

Use the below Url and command if you are using Bitbucket.
#stash repository: 
 https://vinoth85@bitbucket.org/vinoth85/uiautomation.git
#To clone the repository
git clone https://vinoth85@bitbucket.org/vinoth85/uiautomation.git

Framework structure
-------------

* Feature files:  feature files are written using Gherkin language based on the behavior-driven development (BDD) style of Given, When, Then. Cucumber-JVM consumes feature files to generate test code.

* Step definitions: implement feature files in java code

* Page objects: page objects are used to abstract the interactions between a user and a web page. Selenium is used to drive the browser.

* Yaml files: yaml files are used to manage test parameters, you can define the test environment URL, test data and message etc.


Execute test scenarios
----------------------
To execute tests, execute one of the following commands: 

To run test as a standalone Junit:
---------------------------------
Go to RunCukesTest.java and run as junit

To run using maven:
------------------
* mvn test -DBrowser="chrome"

* mvn test

#To execute specified test scenarios by tags:
* mvn test -Dcucumber.options="--tags @search"


Cucumber report
---------------
After executing tests, navigate to below folder to check pretty cucumber html reports, screenshot is captured if scenario marked as failed: 

/Target/healthdirect-cucumber-report
* feature-overview.html
* tag-overview.html
