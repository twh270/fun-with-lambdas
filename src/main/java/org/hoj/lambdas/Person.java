package org.hoj.lambdas;

public class Person {

    private final int age;
    private final CitizenshipStatus citizenshipStatus;

    public Person(int age, CitizenshipStatus citizenshipStatus) {
        this.age = age;
        this.citizenshipStatus = citizenshipStatus;
    }

    public int getAge() {
        return age;
    }

    public CitizenshipStatus getCitizenshipStatus() {
        return citizenshipStatus;
    }
}
