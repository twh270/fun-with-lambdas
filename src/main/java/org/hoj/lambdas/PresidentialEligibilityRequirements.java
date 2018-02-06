package org.hoj.lambdas;

public class PresidentialEligibilityRequirements {
    private final PresidentialEligibility2 presidentialEligibility;
    private final EligibilityRule[] eligibilityRules;

    public PresidentialEligibilityRequirements() {
        this.eligibilityRules = new EligibilityRule[] {
                person -> person.getAge() >= 35,
                person -> person.getCitizenshipStatus() == CitizenshipStatus.NATURAL_BORN,
                person -> person.getYearsOfResidency() >= 14,
                this::isPresidentialServiceHistoryEligible
        };
        this.presidentialEligibility = new PresidentialEligibility2();
    }

    public boolean isEligible(Person person) {
        return presidentialEligibility.isEligible(person, eligibilityRules);
    }

    private boolean isPresidentialServiceHistoryEligible(Person person) {
        PresidentialServiceHistory presidentialServiceHistory = person.getPresidentialServiceHistory();
        if (presidentialServiceHistory.getTermsHeld() == 0) return true;
        if (presidentialServiceHistory.getTermsHeld() >= 2) return false;
        if (presidentialServiceHistory.getActingAsYears() >= 3) return false;
        return true;
    }

}
