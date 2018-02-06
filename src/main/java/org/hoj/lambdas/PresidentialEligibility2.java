package org.hoj.lambdas;

public class PresidentialEligibility2 {
    public boolean isEligible(Person person, EligibilityRule... rules) {
        for (EligibilityRule condition : rules) {
            if (!condition.apply(person)) return false;
        }
        return true;
    }

}
