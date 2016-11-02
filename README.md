# UderstandigScopJSF


    
##1) Running server from Command line with java
    
in the main folder where the pom.xml is stored
    
 Apache Maven 3.3.9
 
    mvn clean install

the war file is stored in the folder target/UnderstandingJSF.war and
can be deployed in a tomcat server


second option is to run this in an tomcat container

    mvn clean install
    java -jar target\tomcatRun.jar --port 8081 target\UderstandigScopJSF.war

##2) Start the Client experience 

from Explorer / FireFox / Chrome, go to the web page
http://localhost:8081
