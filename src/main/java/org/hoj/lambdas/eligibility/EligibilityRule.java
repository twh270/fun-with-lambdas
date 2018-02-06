package org.hoj.lambdas.eligibility;

import java.util.function.Function;

@FunctionalInterface
public interface EligibilityRule<T> extends Function<T, Boolean> {
}
