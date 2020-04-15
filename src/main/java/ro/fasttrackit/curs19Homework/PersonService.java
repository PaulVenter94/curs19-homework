package ro.fasttrackit.curs19Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> peoples;

    public PersonService(List<Person> peoples) {
        this.peoples = peoples == null ? new ArrayList<>() : new ArrayList<>(peoples);
    }

    public List<Person> getPeoples() {
        return new ArrayList<>(peoples);
    }

    public void addPerson(Person person) {
        this.peoples.add(person);
    }

    public void addList(List<Person> list) {
        this.peoples.addAll(list);
    }

    public List<String> getFullName() {
        return peoples.stream()
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
    }

    public List<Person> getOver18Age() {
        return peoples.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public List<Person> getPeopleFromOradea() {
        return peoples.stream()
                .filter(person -> person.getCity()
                        .equalsIgnoreCase("oradea"))
                .collect(Collectors.toList());
    }

    public List<Person> getCLujOrOradea() {
        return peoples.stream()
                .filter(person -> person.getCity()
                        .equalsIgnoreCase("oradea") || person.getCity().equalsIgnoreCase("Cluj"))
                .collect(Collectors.toList());
    }

    public List<String> capitalizedFirstName() {
        return peoples.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<String> firstNameAndLastNameLetter() {
        return peoples.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ".")
                .collect(Collectors.toList());
    }

    public List<Person> workingClass() {
        return peoples.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 60)
                .collect(Collectors.toList());
    }

    public List<Person> startingLetterA() {
        return peoples.stream()
                .filter(person -> person.getFirstName().toUpperCase().charAt(0) == 'A')
                .collect(Collectors.toList());
    }

    public Set<String> uniqueFirstNames() {
        return peoples.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
    }

    public List<Person> sortByFirstName() {
        return peoples.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Person> sortByLasttName() {
        return peoples.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortByNameThenAge() {
        return peoples.stream()
                .sorted(Comparator.comparing(Person::getFullName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
}
