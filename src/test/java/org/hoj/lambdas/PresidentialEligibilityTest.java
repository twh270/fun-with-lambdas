package org.hoj.lambdas;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PresidentialEligibilityTest {
    private PresidentialEligibility testObj = new PresidentialEligibility();

    @Test
    public void rejectsPersonUnderAgeLimit() {
        Person person = new Person(34);

        assertFalse(testObj.isEligible(person));
    }

    @Test
    public void acceptsPersonOverAgeLimit() {
        Person person = new Person(35);

        assertTrue(testObj.isEligible(person));
    }
}
