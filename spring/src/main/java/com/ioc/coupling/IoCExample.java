package com.ioc.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCExample {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationIoCLooseCouplingContext.xml");

/*
        final UserDataProvider databaseProvider=new UserDatabaseProvider();
        UserManager userManagerWithDB=new UserManager(databaseProvider);
*/

        UserManager userManagerWithDB= (UserManager) context.getBean("userManagerWithUserDataProvider");

        System.out.println(userManagerWithDB.getUserInfo());


//        UserManager userManagerWithWS=new UserManager(webServiceProvider);
//
//        System.out.println(userManagerWithWS.getUserInfo());

        UserManager userManagerWithWS= (UserManager) context.getBean("userManagerWithWebServiceDataProvider");

        System.out.println(userManagerWithWS.getUserInfo());


    }
}
