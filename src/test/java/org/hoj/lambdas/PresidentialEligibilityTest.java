package org.hoj.lambdas;

import org.hoj.lambdas.eligibility.EligibilityTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PresidentialEligibilityTest {
    private EligibilityTest<Person> testObj = new EligibilityTest<>(new PresidentialEligibilityRules().getEligibilityRules());

    @Test
    public void rejectsPersonUnderAgeLimit() {
        Person person = PersonObjectMother.builder().withAge(34).build();

        assertFalse(testObj.isEligible(person));
    }

    @Test
    public void acceptsPersonOverAgeLimit() {
        Person person = PersonObjectMother.builder().withAge(35).build();

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

        Person person = PersonObjectMother.builder().withCitizenShipStatus(citizenshipStatus).build();

        assertEquals(isAccepted, testObj.isEligible(person));
    }

    @Test
    public void rejectsPersonWithTooFewYearsOfResidency() {
        Person person = PersonObjectMother.builder().withYearsOfResidency(13).build();

        assertFalse(testObj.isEligible(person));
    }

    @Test
    public void acceptsPersonWithEnoughYearsOfResidency() {
        Person person = PersonObjectMother.builder().withYearsOfResidency(14).build();

        assertTrue(testObj.isEligible(person));
    }

    @ParameterizedTest
    @CsvSource({"0, 0, true",
            "1, 0, true",
            "2, 0, false",
            "0, 1, true",
            "0, 2, true",
            "1, 1, true",
            "1, 2, true",
            "1, 3, false"})
    public void rejectsPersonWithTooMuchService(String termsHeldString, String actingAsYearsString, String acceptedString) {
        int termsHeld = Integer.valueOf(termsHeldString);
        int actingAsYears = Integer.valueOf(actingAsYearsString);
        boolean isAccepted = Boolean.valueOf(acceptedString);

        Person person = PersonObjectMother.builder().withPresidentialServiceHistory(new PresidentialServiceHistory(termsHeld, actingAsYears)).build();

        assertEquals(isAccepted, testObj.isEligible(person));
    }

}
