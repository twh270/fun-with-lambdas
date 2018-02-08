package org.hoj.lambdas.eligibility;

import java.util.List;
import java.util.stream.Collectors;

public class EligibilityFilter<T> {
    private final EligibilityTest<T> eligibilityTest;

    public EligibilityFilter(List<EligibilityRule<T>> rules) {
        this.eligibilityTest = new EligibilityTest<>(rules);
    }

    public List<T> filter(List<T> targets) {
        List<T> filtered = targets
                .stream()
                .filter(eligibilityTest::isEligible)
                .collect(Collectors.toList());
        return filtered;
    }
}
