package test;

import java.util.List;

public class Person {

    private String name;
    private List<Person> knownPeople;

    public Person(String name, List<Person> knownPeople) {
        super();
        this.name = name;
        this.knownPeople = knownPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getKnownPeople() {
        return knownPeople;
    }

    public void setKnownPeople(List<Person> knownPeople) {
        this.knownPeople = knownPeople;
    }

}
