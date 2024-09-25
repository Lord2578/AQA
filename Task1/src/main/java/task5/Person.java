package task5;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private boolean married;
    private Address address;

    // Конструктор без параметрів
    public Person() {}

    // Конструктор з параметрами
    public Person(String name, int age, boolean married, Address address) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.address = address;
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", address=" + address +
                '}';
    }

    // Вкладений клас для Address
    public static class Address implements Serializable {
        private String city;
        private String state;

        // Конструктор без параметрів
        public Address() {}

        // Конструктор з параметрами
        public Address(String city, String state) {
            this.city = city;
            this.state = state;
        }

        // Геттери та сеттери
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    '}';
        }
    }
}
