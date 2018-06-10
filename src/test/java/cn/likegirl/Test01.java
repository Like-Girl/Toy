package cn.likegirl;

import org.junit.Test;

import java.lang.reflect.Field;

final class User{
    private String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                '}';
    }
}

public class Test01 {

    public void swap(int a, int b) throws NoSuchFieldException, IllegalAccessException {
        int temp = a;
        Class<Integer> integerClass = Integer.class;
        Field value = integerClass.getDeclaredField("value");
        value.setAccessible(true);
        value.setInt(a,b);
        value.setInt(b,temp);
    }

    public void swap(Integer[] arrs) {
        arrs[0] = 123;
    }

    public void swap(User user) {
//        user = new User("hello");
        user.setId("hello");
    }


    @Test
    public void test01() throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);

        Integer[] arrs = {1, 2};
        swap(arrs);
        for (Integer d : arrs) {
            System.out.println(d);
        }

        User user = new User("hi");
        swap(user);
        System.out.println(user.toString());
    }
}
