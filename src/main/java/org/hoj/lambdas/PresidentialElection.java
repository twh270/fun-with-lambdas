package org.hoj.lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class PresidentialElection {
    private final PresidentialEligibilityRequirements eligibilityRequirements = new PresidentialEligibilityRequirements();

    public List<Person> filterEligibleCandidates(List<Person> persons) {
        List<Person> eligibleCandidates = persons
                .stream()
                .filter(eligibilityRequirements::isEligible)
                .collect(Collectors.toList());
        return eligibleCandidates;
    }
}
