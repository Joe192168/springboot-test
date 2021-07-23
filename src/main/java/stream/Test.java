package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * 现在有5个用户，筛选
 * 1、id，必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名字母转为大写
 * 4、用户名字倒着排序
 * 5、只输出一个用户
 */
public class Test {

    public static void main(String[] args) {
        User u1 = new User(1,"jack",21);
        User u2 = new User(2,"mack",22);
        User u3 = new User(3,"xiaoming",23);
        User u4 = new User(4,"zhangsan",24);
        User u5 = new User(5,"wangwu",25);
        User u6 = new User(6,"kula",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5,u6);

        //这块使用计算交给Stream
        //lambda表达式，链式编程，函数式接口，Stream流式计算
        list.stream()
                .filter((u)->{return u.getId()%2==0;})
                .filter((u)->{return u.getAge()>23;})
                .map((u)->{return u.getName().toUpperCase();})
                .sorted()
                .limit(1)
                .forEach(System.out::println);
    }

}
