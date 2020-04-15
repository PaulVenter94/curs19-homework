package ro.fasttrackit.curs19Homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonServiceTest {
    private PersonService personService = new PersonService(null);
    private PersonService emptyPersonService = new PersonService(null);

    @BeforeEach
    void setup() {
        personService.addList(List.of(
                new Person("Ana", "Mere", 45, "Bucuresti"),
                new Person("Paul", "Venter", 26, "Oradea"),
                new Person("Marius", "Sumudica", 56, "Giurgiu"),
                new Person("Marius", "Sumudica", 27, "Cluj"),
                new Person("Eric", "Cartman", 10, "Southpark"),
                new Person("Butters", "Stoch", 10, "Southpark")
        ));
    }

    @Test
    @DisplayName("When giving a null param in constructor THEN create an empty list")
    void createAnEmptyListForNullParam() {
        PersonService personService2 = new PersonService(null);

        assertTrue(personService2.getPeoples().isEmpty());
    }

    @Test
    @DisplayName("When adding a list THEN add that list")
    void addAList() {
        assertThat(personService.getPeoples().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("When getting fullName from a empty list THEN return an empty list")
    void getFullNameReturnEmptyList() {
        assertTrue(emptyPersonService.getFullName().isEmpty());
    }

    @Test
    @DisplayName("When extracting fullName THEN return List of strings")
    void getFullName() {
        assertThat(personService.getFullName().size()).isEqualTo(6);
        assertThat(personService.getFullName().get(0).getClass().getSimpleName()).isEqualTo("String");
    }

    @Test
    @DisplayName("When extracting over 18 person THEN return List of Persons")
    void getPersonsOver18() {
        assertThat(personService.getOver18Age().size()).isEqualTo(4);
        assertThat(personService.getOver18Age().get(0).getClass().getSimpleName()).isEqualTo("Person");
    }

    @Test
    @DisplayName("When getting Person from Oradea THEN return a list<Person>")
    void getPersonsFromOradea() {
        assertThat(personService.getPeopleFromOradea().size()).isEqualTo(1);
        assertThat(personService.getPeopleFromOradea().get(0).getClass().getSimpleName()).isEqualTo("Person");
        assertTrue(emptyPersonService.getPeopleFromOradea().isEmpty());
    }

    @Test
    @DisplayName("When getting Person from Oradea or Cluj THEN return a list<Person>")
    void getPersonsFromOradeaOrCluj() {
        Person personCj = new Person("Marius", "Sumudica", 27, "Cluj");
        assertThat(personService.getCLujOrOradea().size()).isEqualTo(2);
        assertThat(personService.getCLujOrOradea().get(1)).isEqualTo(personCj);
        assertThat(personService.getCLujOrOradea().get(0).getClass().getSimpleName()).isEqualTo("Person");
        assertTrue(emptyPersonService.getCLujOrOradea().isEmpty());
    }

    @Test
    @DisplayName("When capitalize FirstName THEN return List of strings")
    void getCapitalizedFirstName() {
        var capitalizedName = personService.capitalizedFirstName().get(0);
        var normalName = personService.getPeoples().get(0).getFirstName();

        assertThat(personService.capitalizedFirstName().size()).isEqualTo(6);
        assertEquals(capitalizedName, normalName.toUpperCase());
        assertThat(capitalizedName.getClass().getSimpleName()).isEqualTo("String");
    }

    @Test
    @DisplayName("When getting FirstName and first letter from second name THEN return List of strings")
    void getFirstNameAndFirstLetter() {
        var formatedName = personService.firstNameAndLastNameLetter().get(0);
        var person = personService.getPeoples().get(0);

        assertThat(personService.capitalizedFirstName().size()).isEqualTo(6);
        assertEquals(formatedName, person.getFirstName() + " " + person.getLastName().charAt(0) + ".");
        assertThat(formatedName.getClass().getSimpleName()).isEqualTo("String");
    }

    @Test
    @DisplayName("Get all person form 18 to 60 years inclusive")
    void getWorkingCLass() {
        assertThat(personService.workingClass().size()).isEqualTo(4);
        assertThat(personService.workingClass().get(0).getClass().getSimpleName()).isEqualTo("Person");
    }

    @Test
    @DisplayName("Get all person with first letter form first name A")
    void getPersonsWithStartingLetterA() {
        personService.addPerson(new Person("Andrei", "Pop", 95, "Bucuresti"));

        assertThat(personService.startingLetterA().size()).isEqualTo(2);
        assertThat(personService.startingLetterA().get(0).getClass().getSimpleName()).isEqualTo("Person");
    }

    @Test
    @DisplayName("Get all unique first names")
    void getUniqueNames() {
        personService.addPerson(new Person("Marius", "Pop", 95, "Bucuresti"));

        assertThat(personService.uniqueFirstNames().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("Sort by FirstName")
    void sortByFirstName() {
        List<Person> list = new ArrayList<>(personService.getPeoples());

        Collections.sort(list, Comparator.comparing(Person::getFirstName));
        assertThat(personService.sortByFirstName()).isEqualTo(list);
    }

    @Test
    @DisplayName("Sort by LastName")
    void sortByLastName() {
        List<Person> list = new ArrayList<>(personService.getPeoples());

        Collections.sort(list, Comparator.comparing(Person::getLastName));
        assertThat(personService.sortByLasttName()).isEqualTo(list);
    }

    @Test
    @DisplayName("Sort by Name the By Age")
    void sortByNameThenAge() {
        List<Person> list = new ArrayList<>(personService.getPeoples());

        Collections.sort(list, Comparator.comparing(Person::getFullName).thenComparing(Person::getAge));
        assertThat(personService.sortByNameThenAge()).isEqualTo(list);
    }
}