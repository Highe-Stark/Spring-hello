Hello - Spring
=============

## Brief Introduction
Introduction into Spring.

Following tutorial of __《Java Web整合开发 王者归来》__

##### v0.8
Implement DAO modules with JDBC to connect the database
###### Problem encountered
applicationContext-Person.xml: `com.mysql.jdbc.Driver` is out of date. 
    Adopt `com.mysql.cj.jdbc.Driver` instead.  
    Jdbc connector requires serverTimeZone, specifying in following format
        
        ...?serverTimezone=<Continent>/<City>?...
        ...?serverTimezone=UTC?...
        ...?serverTimezone=GMT%2B<Int>?...       <!-- meaning GMT + <Int> -->
   
If connecting without a certification, specifying `useSSL=false`.  
`&` is a predefined entity ( special character ) among 5 in HTML/XML, use `&amp;` instead.

##### v0.5.1
If an interface is implemented by some classes, the interface can be instantiated. 
Just imagine it is instantiated by an anonymous class.
###### Problem encountered
com.stark.hello.SpringTest.java: 
replace 
        `ServiceImpl hello = (ServiceImpl) factory.getBean("service"); `
with 
        `IService hello = (IService) factory.getBean("service");`
  
com.stark.aop.AopRun.java: 
replace
        `AopServiceImpl hello = (AopServiceImpl) context.getBean("aopService");`
with 
        `IAopService hello = (IAopService) context.getBean("aopService");`


##### v0.5
Intercept method with interceptor implementation


##### v0.2
AOP interface implementation.  
Interceptor implementation.

###### Problem encountered
1. MethodBeforeAdviceImpl.java:  
        `Attribute local is not allowed`  
    Replace `local` with `bean`


##### v0.1
Implementation of DAO interface implementation and Service interface implementation. 
###### Problem encountered
1. SpringTest.java: 
        `XmlBeanFactory has been deprecated `  
    Replace class `XmlBeanFactory` with class `ApplicationContext`, and replace `XmlBeanFactory()` with `ClassPathXmlApplicationContext()`
