package com.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test3 {

    static Log log = LogFactory.getLog(Test3.class);

    public static void main(String[] args) {
        User user = new User("zhangsan");
        log.info(user);
        try {
            new User(null);
        } catch (Exception e) {
            log.error("error：",e);
        }
    }

}

class User{
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
