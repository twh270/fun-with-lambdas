package org.hoj.lambdas;

import java.util.function.Function;

@FunctionalInterface
public interface EligibilityRule<T> extends Function<T, Boolean> {
}
