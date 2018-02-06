package org.hoj.lambdas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PresidentialEligibilityTest {
    private PresidentialEligibility testObj = new PresidentialEligibility();

    @Test
    public void rejectsPersonUnderAgeLimit() {
        Person person = new Person(34, CitizenshipStatus.NATURAL_BORN, 14);

        assertFalse(testObj.isEligible(person));
    }

    @Test
    public void acceptsPersonOverAgeLimit() {
        Person person = new Person(35, CitizenshipStatus.NATURAL_BORN, 14);

        assertTrue(testObj.isEligible(person));
    }

    @ParameterizedTest
    @CsvSource({"NATURAL_BORN, true",
                "NATURALIZED, false",
                "RESIDENT_ALIEN, false",
                "VISA, false",
                "UNDOCUMENTED, false"})
    public void rejectsPersonWithInvalidCitizenship(String statusString, String acceptedString) {
        CitizenshipStatus citizenshipStatus = CitizenshipStatus.valueOf(statusString);
        boolean isAccepted = Boolean.valueOf(acceptedString);

        Person person = new Person(35, citizenshipStatus, 14);

        assertEquals(isAccepted, testObj.isEligible(person));
    }

    @Test
    public void rejectsPersonWithTooFewYearsOfResidency() {
        Person person = new Person(35, CitizenshipStatus.NATURAL_BORN, 13);

        assertFalse(testObj.isEligible(person));
    }

    @Test
    public void acceptsPersonWithEnoughYearsOfResidency() {
        Person person = new Person(35, CitizenshipStatus.NATURAL_BORN, 14);

        assertTrue(testObj.isEligible(person));
    }
}
