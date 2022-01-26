package person;

import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder() {

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 200) {
            throw new IllegalArgumentException("Указан некорректный возраст: " + age + "!");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || address == null || age.isEmpty() == true) {
            throw new IllegalStateException("Определены не все параметры человека!");
        }
        return new Person(name, surname, age.getAsInt(), address);
    }
}
