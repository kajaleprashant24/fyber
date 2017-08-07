# README

To Run the test cases follow the steps:-
1.Extract the project to a directory.  
2.cd to project directory.  
3.run following command from cmd:-
#mvn clean test 

Total test scenarios executed will be 19.

This tests are configured to run on firefox,chrome and IE. Execution is tested on Windows machine against Firefox 54 browser.
(Note:-As the selenium java version used is 3.4.0)

Result will be generated under target->surefire-reports->Exercise suite 

Note:-
1.Source for test can be found under:- src/test/java
2.package com.funda.selenium.test.suite has test case/suite implementation
3.package com.funda.selenium.test.base has implementation specific to application pages/functionality.
4.package com.funda.selenium.webdriver.base has implementation specific to webdriver like initialising webdriver instance etc.


