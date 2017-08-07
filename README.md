# README

To Run the test cases follow the steps:-  
1.Clone the project to a directory.  
2.cd to project directory.  
3.run following command from cmd:-  
 **mvn clean test**  
 
By default this tests will run on chrome browser.
This tests can be configured to run on firefox,chrome and IE. Execution is tested on Windows machine against Firefox 54 browser.
  
  
Result will be generated under target->surefire-reports->Exercise suite   

**Note:-**  
1.package **com.fyber.selenium.test.suite** has test case/suite implementation  
2.package **com.fyber.selenium.test.base** has implementation specific to application pages/functionality.  
3.package **com.fyber.selenium.webdriver.base** has implementation specific to webdriver like initialising webdriver instance etc.  

Refer **com.fyber.selenium.test.suite.AssignmentTestSuite.java** for Test case implementation  
Refer **com.fyber.selenium.test.base.Home.java** for Page Object Implementation for app  


