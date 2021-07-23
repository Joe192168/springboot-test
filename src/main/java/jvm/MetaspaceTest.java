package jvm;

import org.springframework.cglib.beans.BeanGenerator;

public class MetaspaceTest {

    public static void main(String[] args) {
        while(true){
            try {
                BeanGenerator generator = new BeanGenerator();
                generator.addProperty("PermGenOOM" + Math.random(), Class.forName("java.io.File"));
                generator.create();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}