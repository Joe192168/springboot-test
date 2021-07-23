package com.test;

public class Car {

    public static void main(String[] args) {
        Class<Car> car = Car.class;
        System.out.println(car.getClassLoader());

        //这三个名字在栈里面（栈是引用地址），new的实例数据在堆里
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        System.out.println(car1.getClass());
        System.out.println(car2.getClass());
        System.out.println(car3.getClass());
    }

}
