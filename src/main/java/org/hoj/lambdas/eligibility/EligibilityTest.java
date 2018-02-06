package org.hoj.lambdas.eligibility;

public class EligibilityTest<T> {
    public boolean isEligible(T target, Iterable<EligibilityRule<T>> rules) {
        for (EligibilityRule<T> rule : rules) {
            if (!rule.apply(target)) return false;
        }
        return true;
    }

}
