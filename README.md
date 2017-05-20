jaxrs-cxf-springsec
===================

demo project for jax restful web services and apache cxf with spring security

To run this sample
- run git clone to get the codebase
- move to root of project and run :  mvn clean install
- run *mvn jetty:run*
- Access one of the URLS below.
- Use port 8080 with tomcat or port 9090 with jetty

To install and configure tomcat
- brew install tomcat
- cd /usr/local/Cellar/tomcat/8.5.15/libexec/conf
- edit tomcat-users.xml
- under /tomcat-users make sure you have the manager-gui role defined
such as
<pre>
<role rolename="manager-gui"/>
<user username="admin" password="admin" roles="manager-gui"/>
</pre>
- run tomcat using the command:   catalina run
- invoke the tomcat manager GUI in a browser as http://localhost:8080
- click the "Manager App" button on the top left
- enter in the userid and password we defined above
- Scroll to the Deploy - War to deploy section of the "Tomcat Web Application Manager" page
- click choose file button
- select the .war file in the target directory of this project.  NOTE: the maven install command executed above would have created the .war file
- click the deploy button.  The app should install successfully.
- issue any of the following http request in your favorite browser.

RESTful service URI's...
- No security (try this first) ? http://localhost:8080/jaxrscxf/services/timeoftheday/asplaintext
- With Security & JSON response ? http://localhost:8080/jaxrscxf/services/timeoftheday/asjson/mathew
- With Security & XML response ? http://localhost:8080/jaxrscxf/services/timeoftheday/asxml/mathew

Simple Hello World example (using query params)
- http://localhost:8080/jaxrscxf/services/helloname/
- http://localhost:8080/jaxrscxf/services/helloname/?name=tom

Simple Hello World example (using path params)
- http://localhost:8080/jaxrscxf/services/helloname
- http://localhost:8080/jaxrscxf/services/hello/frank

Prime test
- http://localhost:8080/jaxrscxf/services/prime/isprime/15
- http://localhost:8080/jaxrscxf/services/prime/isprime/13

Prime numbers in a given range
- http://localhost:8080/jaxrscxf/services/prime/primesinrange/1/100

Prime factors of a number
- http://localhost:8080/jaxrscxf/services/prime/factors/2035

Prime Factorization for a set of numbers in given range
- http://localhost:8080/jaxrscxf/services/prime/factorsinrange/20/50


        <sec:user name="admin" password="password" authorities="admin" />
        <sec:user name="johndoe" password="password" authorities="customer, admin" />

