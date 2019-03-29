# FreshDistribution
Fresh distribution decision platform

1.Config information：
	Charset : UTF-8
	Java version:1.8
	MySql Server version:5.7.20
	DataBase name:fresh
	Browser : IE9+,Chrome ...

2.Import all module project by maven on Eclipse 

3.Create DataBase [fresh] and Source SQL Data file [fresh.sql] on charset UTF-8

4.Maven install jeecg-p3-base-system，jeecg-p3-biz-fresh，jeecg-p3-core-ui，jeecg-p3-starter-parent

5.Maven command：tomcat7:run to Run jeecg-p3-starter-web at local
	Or maven install to get a war package run on tomcat server.
	
6.Visit: http://localhost:8080/jeecg-p3-starter-web/login.do?login