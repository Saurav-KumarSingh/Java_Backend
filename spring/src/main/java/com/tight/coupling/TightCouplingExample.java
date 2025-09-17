package com.tight.coupling;

public class TightCouplingExample {
    public static void main(String[] args) {
        final UserManager userManager=new UserManager();
        System.out.println(userManager.getUserInfo());
    }
}
