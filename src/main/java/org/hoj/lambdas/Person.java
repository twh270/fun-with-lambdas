package org.hoj.lambdas;

public class Person {

    private final int age;
    private final CitizenshipStatus citizenshipStatus;
    private final int yearsOfResidency;

    public Person(int age, CitizenshipStatus citizenshipStatus, int yearsOfResidency) {
        this.age = age;
        this.citizenshipStatus = citizenshipStatus;
        this.yearsOfResidency = yearsOfResidency;
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
}
