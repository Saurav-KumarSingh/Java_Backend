package com.loose.coupling;

public class LooseCouplingExample {
    public static void main(String[] args) {
        final UserDataProvider databaseProvider=new UserDatabaseProvider();

        UserManager userManagerWithDB=new UserManager(databaseProvider);

        System.out.println(userManagerWithDB.getUserInfo());

        final UserDataProvider webServiceProvider=new WebServiceDataProvider();

        UserManager userManagerWithWS=new UserManager(webServiceProvider);

        System.out.println(userManagerWithWS.getUserInfo());



    }
}
