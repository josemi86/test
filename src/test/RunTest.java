package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RunTest {

    private static List<Person> people = loadPeople();

    public static void main(String[] args) {
        Optional<Person> celebrity = getCelebrity();
        if (celebrity.isPresent()) { 
            System.out.println("Celebrity is " + celebrity.get()); 
        } 
        else { 
            System.out.println("No celebrity"); 
        } 
    }
    
    private static Optional<Person> getCelebrity() {
        return people.stream().filter(person->person.getKnownPeople().size() == 0 && isKnownByAll(person)).findFirst();
    }

    private static boolean isKnownByAll(Person person) {
        boolean response = true;
        if(people.stream().anyMatch(otherPerson->!otherPerson.getName().equals(person.getName()) 
                    && !otherPerson.getKnownPeople().contains(person)))
            response = false;
        return response;
    }

    private static List<Person> loadPeople() {
        List<Person> people = new ArrayList<Person>();
        Person celebrity = new Person("Brian", new ArrayList<Person>());
        Person person1 = new Person("John", Arrays.asList(celebrity));
        Person person2 = new Person("Jack", Arrays.asList(celebrity, person1));
        Person person3 = new Person("James", Arrays.asList(person1, person2));
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(celebrity);
        return people;
    }
}