package com.example.autowire.constructor;

public class Car {
    private final Specification specification;
//    private Specification specification1;

    public Car(Specification specification) {
        this.specification = specification;
    }


//    public void setSpecification1(Specification specification1) {
//        this.specification1 = specification1;
//    }


    public void displayDetails(){
        System.out.println("Car Details :" + specification.toString());
    }
}
