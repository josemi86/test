package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunTest {

    private static List<Person> people = loadPeople();

    public static void main(String[] args) {
        if (isCelebrity("Brian"))
            System.out.println("Is celebrity!!!");
    }

    private static boolean isCelebrity(String name) {
        boolean response = false;
        for (Person person : people) {
            if (person.getName().equals(name) && person.getKnownPeople().size() == 0 && isKnownByAll(person)) {
                response = true;
            }
        }
        return response;
    }

    private static boolean isKnownByAll(Person person) {
        boolean response = true;
        for (Person otherPerson : people) {
            if (!otherPerson.getName().equals(person.getName()) && !isKnownByPerson(person, otherPerson)) {
                response = false;
            }
        }
        return response;
    }

    private static boolean isKnownByPerson(Person person, Person otherPerson) {
        boolean response = false;
        for (Person knownPerson : otherPerson.getKnownPeople()) {
            if (knownPerson.getName().equals(person.getName()))
                response = true;
        }
        return response;
    }

    private static List<Person> loadPeople() {
        List<Person> people = new ArrayList<Person>();
        Person celebrity = new Person("Brian", new ArrayList<Person>());
        Person person1 = new Person("John", Arrays.asList(celebrity));
        Person person2 = new Person("Jack", Arrays.asList(celebrity, person1));
        Person person3 = new Person("James", Arrays.asList(celebrity, person1, person2));
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(celebrity);
        return people;
    }
}