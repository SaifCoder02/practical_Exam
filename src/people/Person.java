package people;

import java.net.IDN;

public abstract class Person {
    private String name;
//    protected int ID;
    static Integer id = 0;
    private int age;

    public Person(String name, int age) {
        id += 1;
        this.name = name;
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "people.Person{" +
                "name = " + name + '\'' +
                ", ID = " + id +
                ", age = " + age +
                '\'' +
                '}';
    }
}
