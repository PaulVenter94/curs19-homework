package ro.fasttrackit.curs19Homework;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String city;

    public Person(String firstName, String lastName, int age, String city) {
        if (validatePerson(firstName, lastName, age, city)) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean validatePerson(String firstName, String lastName, int age, String city) {
        if (firstName == null || lastName == null || age < 0 || city == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getCity().equals(person.getCity()) &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getCity());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }
}
