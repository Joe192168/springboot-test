package com.jvm;

import org.springframework.cglib.beans.BeanGenerator;

public class PermTest {

    public static void main(String[] args) {
        for(int i = 0 ; 1 <1000000  ; i++){
            try {
                BeanGenerator generator = new BeanGenerator();
                generator.addProperty("PermGenOOM"+i,  Class.forName("java.io.File"));
                generator.create();
                System.out.println("创建第"+i+"个Bean对象");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}