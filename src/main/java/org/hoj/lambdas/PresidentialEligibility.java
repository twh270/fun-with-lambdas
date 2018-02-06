package org.hoj.lambdas;

public class PresidentialEligibility {

    public boolean isEligible(Person person) {
        return person.getAge() >= 35
                && person.getCitizenshipStatus() == CitizenshipStatus.NATURAL_BORN;
    }
}
