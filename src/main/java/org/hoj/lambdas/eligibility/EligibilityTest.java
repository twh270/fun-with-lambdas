package org.hoj.lambdas.eligibility;

public class EligibilityTest<T> {
    private final Iterable<EligibilityRule<T>> rules;

    public EligibilityTest(Iterable<EligibilityRule<T>> rules) {
        this.rules = rules;
    }

    public boolean isEligible(T target) {
        for (EligibilityRule<T> rule : rules) {
            if (!rule.apply(target)) return false;
        }
        return true;
    }

}
