package ai173.feskova.polyclinic;

public class ObligatoryMedicalInsurancePolicy extends MedicalInsurancePolicy{
    @Override
    public String toString() {
        return (new StringBuilder("Class: ObligatoryMedicalInsurancePolicy"  + super.toString())).toString();
    }
}
