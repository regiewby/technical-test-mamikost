# technical-test-mamikost
techincal-test-mamikost project was made to participate in the selection at mamikos company.
this project developed using several framework tools such as
<li> maven
<li> Cucumber 
<li> TestNg
<br> <br>

## Folder Structure
<br/>The folder structure is as following:

    techincal-test-mamikost
    │ 
    ├─ features                           # gherkin test cases 
    ├─ src
    │   ├─ test                               # Test files
    │         ├─ pages                         # Page Object Factory
    │         ├─ runners                       # TestNg Runner
    │         ├─ steps                         # Step Definitions
    │   ├─ main 
    │         ├─ factories                     # implement design pattern factory for init an objects
    │         ├─ helpers                       # helpers
    │         └─ utilities                     # utility
    ├─ README.md
    ├─ pom.xml
    ├─ testng.xml
    └─ ...   


## How to Run
1. Clone this project from branch Master by running this url on your terminal
    ````
   git clone https://github.com/regiewby/technical-test-mamikost.git    
    ````
2. there's 2 option to running this project on your local PC
   - using pom.xml
   - using testng.xml
    <br> <br>
     
3. Running using maven
````
mvn clean
````
3. Or you can do right click on testng.xml file and click 'Run .../testng.xml' if you're using IntelliJ IDEA

## Reporting
I'm using extentreport for reporting, <br>
and file report will be generated on directory 'test-output',
