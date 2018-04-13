Hello - Spring
=============

## Brief Introduction
Introduction into Spring.

Following tutorial of __《Java Web整合开发 王者归来》__

##### v0.5.1
If an interface is implemented by some classes, the interface can be instantiated. 
Just imagine it is instantiated by an anonymous class.

com.stark.hello.SpringTest.java:  
replace 

        ServiceImpl hello = (ServiceImpl) factory.getBean("service");
with 

        IService hello = (IService) factory.getBean("service");
  
com.stark.aop.AopRun.java:  
replace

        AopServiceImpl hello = (AopServiceImpl) context.getBean("aopService");
with 

        IAopService hello = (IAopService) context.getBean("aopService");


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

##### Problem encountered
1. SpringTest.java: 
        
        XmlBeanFactory has been deprecated 
    Replace class _XmlBeanFactory_ with class _ApplicationContext_, and replace _XmlBeanFactory()_ with _ClassPathXmlApplicationContext()_
