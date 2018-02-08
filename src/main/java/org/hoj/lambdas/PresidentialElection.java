package org.hoj.lambdas;

import java.util.ArrayList;
import java.util.List;

public class PresidentialElection {
    PresidentialEligibility presidentialEligibility = new PresidentialEligibility();

    public List<Person> filterEligibleCandidates(List<Person> persons) {
        List<Person> eligibleCandidates = new ArrayList<>();

        for(Person person : persons) {
            if (presidentialEligibility.isEligible(person)) {
                eligibleCandidates.add(person);
            }
        }

        return eligibleCandidates;
    }
}
