package org.hoj.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PresidentialElectionTest {
    private final PresidentialElection testObj = new PresidentialElection();
    private final Person BOB = PersonObjectMother.ineligiblePerson("Bob");
    private final Person AMY = PersonObjectMother.eligiblePerson("Amy");

    @Test
    public void allowsOnlyEligiblePeople() {
        List<Person> persons = new ArrayList<>();
        persons.add(BOB);
        persons.add(AMY);

        List<Person> eligibleCandidates = testObj.filterEligibleCandidates(persons);
        assertTrue(eligibleCandidates.contains(AMY));
        assertFalse(eligibleCandidates.contains(BOB));
    }
}
