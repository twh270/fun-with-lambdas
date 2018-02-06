package org.hoj.lambdas;

public class PresidentialEligibility {

    public boolean isEligible(Person person) {
        return person.getAge() >= 35
                && person.getCitizenshipStatus() == CitizenshipStatus.NATURAL_BORN
                && person.getYearsOfResidency() >= 14
                && isServiceHistoryAcceptable(person.getPresidentialServiceHistory());
    }

    private boolean isServiceHistoryAcceptable(PresidentialServiceHistory presidentialServiceHistory) {
        if (presidentialServiceHistory.getTermsHeld() == 0) return true;
        if (presidentialServiceHistory.getTermsHeld() >= 2) return false;
        if (presidentialServiceHistory.getActingAsYears() >= 3) return false;
        return true;
    }
}
