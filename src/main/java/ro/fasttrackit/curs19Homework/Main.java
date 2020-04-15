package ro.fasttrackit.curs19Homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(List.of(
                new Person("Ana", "Mere", 45, "Bucuresti"),
                new Person("Paul", "Venter", 26, "Oradea"),
                new Person("Marius", "Sumudica", 56, "Giurgiu"),
                new Person("Marius", "Sumudica", 27, "Bucuresti"),
                new Person("Eric", "Cartman", 10, "Southpark"),
                new Person("Butters", "Stoch", 9, "Southpark")
        ));
        PersonService personService = new PersonService(list);
        PersonService personService2 = new PersonService(null);
        personService.addPerson(new Person("Marius", "Pop", 56, "Giurgiu"));
        System.out.println(personService2.getFullName());
        System.out.println(personService.capitalizedFirstName());
        System.out.println(personService.firstNameAndLastNameLetter());
        System.out.println(personService.sortByFirstName());
        System.out.println(personService.sortByLasttName());
        System.out.println(personService.sortByNameThenAge());
    }
}
