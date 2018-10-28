package ai173.feskova.polyclinic;

public class VoluntaryMedicalInsurancePolicy extends MedicalInsurancePolicy{
    private double totalAmountOfInsurance;
    private double paidInsuranceAmount;

    public VoluntaryMedicalInsurancePolicy() {
        this.totalAmountOfInsurance = 100000;
        this.paidInsuranceAmount = 0;
    }

    public VoluntaryMedicalInsurancePolicy(double totalAmountOfInsurance) {
        this.totalAmountOfInsurance = totalAmountOfInsurance;
        this.paidInsuranceAmount = 0;
    }

    public double getTotalAmountOfInsurance() {
        return totalAmountOfInsurance;
    }

    public void setTotalAmountOfInsurance(double totalAmountOfInsurance) {
        this.totalAmountOfInsurance = totalAmountOfInsurance;
    }

    public double getPaidInsuranceAmount() {
        return paidInsuranceAmount;
    }

    public void setPaidInsuranceAmount(double paidInsuranceAmount) {
        this.paidInsuranceAmount = paidInsuranceAmount;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Totaly sum of insurance: " + totalAmountOfInsurance + "Paid insurance sum: " + paidInsuranceAmount + super.toString())).toString();
    }
}
