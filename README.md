Hello - Spring
=============

## Brief Introduction
Introduction into Spring.

Following tutorial of __《Java Web整合开发 王者归来》__

##### v0.5
Intercept method with interceptor implementation

##### v0.2
AOP interface implementation.  
Interceptor implementation.
###### Problem encountered
1. MethodBeforeAdviceImpl.java:  

        Attribute local is not allowed
    Replace _local_ with _bean_

#### v0.1
Implementation of DAO interface implementation and Service interface implementation.

##### Encoutered Problems
1. SpringTest.java: 
        
        XmlBeanFactory has been deprecated 
    Replace class _XmlBeanFactory_ with class _ApplicationContext_, and replace _XmlBeanFactory()_ with _ClassPathXmlApplicationContext()_
