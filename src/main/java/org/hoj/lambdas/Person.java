package org.hoj.lambdas;

public class Person {

    private final String name;
    private final int age;
    private final CitizenshipStatus citizenshipStatus;
    private final int yearsOfResidency;
    private final PresidentialServiceHistory presidentialServiceHistory;

    public Person(String name, int age, CitizenshipStatus citizenshipStatus, int yearsOfResidency, PresidentialServiceHistory presidentialServiceHistory) {
        this.name = name;
        this.age = age;
        this.citizenshipStatus = citizenshipStatus;
        this.yearsOfResidency = yearsOfResidency;
        this.presidentialServiceHistory = presidentialServiceHistory;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CitizenshipStatus getCitizenshipStatus() {
        return citizenshipStatus;
    }

    public int getYearsOfResidency() {
        return yearsOfResidency;
    }

    public PresidentialServiceHistory getPresidentialServiceHistory() {
        return presidentialServiceHistory;
    }
}
