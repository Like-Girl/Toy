package cn.likegirl.jvm;


class User {
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

public class jmm {

    public static void main(String[] args) {
        User a = new User("01");

        User b = a;

        a = new User("02");


        System.out.println(a.toString());

        System.out.println(b.toString());


    }

}
