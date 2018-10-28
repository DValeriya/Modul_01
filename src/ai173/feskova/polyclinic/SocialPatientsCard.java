package ai173.feskova.polyclinic;

public class SocialPatientsCard extends PatientsCard{
    public SocialPatientsCard(String name, String surname) {
        super(name, surname);
    }

    public SocialPatientsCard(String name, String surname, String address) {
        super(name, surname, address);
    }

    public SocialPatientsCard(String name, String surname, String address, MedicalInsurancePolicy insurancePolicy) {
        super(name, surname, address, insurancePolicy);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof SocialPatientsCard;
    }

    @Override
    public int hashCode() {
        final int number = 654321;
        return super.hashCode()^number;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Class: SocialPatientsCard"  + super.toString())).toString();
    }
}
