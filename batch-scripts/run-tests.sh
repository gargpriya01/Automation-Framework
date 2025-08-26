@echo off
echo Running TestNG suite...
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
pause

echo Running BDD Tests...
mvn clean test -Dcucumber.options="src/test/resources/features/login.feature"
pause