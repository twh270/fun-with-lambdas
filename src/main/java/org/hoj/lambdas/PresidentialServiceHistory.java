package org.hoj.lambdas;

public class PresidentialServiceHistory {
    private final int termsHeld;
    private final int actingAsYears;

    public PresidentialServiceHistory(int termsHeld, int actingAsYears) {
        this.termsHeld = termsHeld;
        this.actingAsYears = actingAsYears;
    }

    public int getTermsHeld() {
        return termsHeld;
    }

    public int getActingAsYears() {
        return actingAsYears;
    }
}
