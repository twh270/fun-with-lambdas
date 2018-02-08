package org.hoj.lambdas;

public class PersonObjectMother {

    public static Person eligiblePerson(String name) {
        return builder().withName(name).build();
    }

    public static Person ineligiblePerson(String name) {
        return builder().withName(name).withAge(34).build();
    }

    public static Builder builder() {
        return new Builder()
            .withName("")
            .withAge(35)
            .withCitizenShipStatus(CitizenshipStatus.NATURAL_BORN)
            .withYearsOfResidency(14)
            .withPresidentialServiceHistory(new PresidentialServiceHistory(0, 0));
    }

    public static class Builder {
        private String name;
        private int age;
        private CitizenshipStatus citizenshipStatus;
        private int yearsOfResidency;
        private PresidentialServiceHistory presidentialServiceHistory;

        public Person build() {
            return new Person(name, age, citizenshipStatus, yearsOfResidency, presidentialServiceHistory);
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withCitizenShipStatus(CitizenshipStatus citizenShipStatus) {
            this.citizenshipStatus = citizenShipStatus;
            return this;
        }

        public Builder withYearsOfResidency(int yearsOfResidency) {
            this.yearsOfResidency = yearsOfResidency;
            return this;
        }

        public Builder withPresidentialServiceHistory(PresidentialServiceHistory presidentialServiceHistory) {
            this.presidentialServiceHistory = presidentialServiceHistory;
            return this;
        }
    }
}
