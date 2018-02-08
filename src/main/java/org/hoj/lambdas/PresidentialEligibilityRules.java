package org.hoj.lambdas;

import org.hoj.lambdas.eligibility.EligibilityRule;

import java.util.ArrayList;
import java.util.List;

public class PresidentialEligibilityRules {
    private final List<EligibilityRule<Person>> eligibilityRules = new ArrayList<>();

    public PresidentialEligibilityRules() {
        eligibilityRules.add(person -> person.getAge() >= 35);
        eligibilityRules.add(person -> person.getCitizenshipStatus() == CitizenshipStatus.NATURAL_BORN);
        eligibilityRules.add(person -> person.getYearsOfResidency() >= 14);
        eligibilityRules.add(this::isPresidentialServiceHistoryEligible);
    }

    public List<EligibilityRule<Person>> getEligibilityRules() {
        return eligibilityRules;
    }

    private boolean isPresidentialServiceHistoryEligible(Person person) {
        PresidentialServiceHistory presidentialServiceHistory = person.getPresidentialServiceHistory();
        if (presidentialServiceHistory.getTermsHeld() == 0) return true;
        if (presidentialServiceHistory.getTermsHeld() >= 2) return false;
        if (presidentialServiceHistory.getActingAsYears() >= 3) return false;
        return true;
    }
}
