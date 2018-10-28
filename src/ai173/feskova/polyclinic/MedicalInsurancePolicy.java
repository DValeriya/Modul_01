package ai173.feskova.polyclinic;

abstract public class MedicalInsurancePolicy {
    private long numberPolicy;
    private String nameOfInsuranceCompany;

    public MedicalInsurancePolicy() {
    }

    public MedicalInsurancePolicy(long numberPolicy, String nameOfInsuranceCompany) {
        this.numberPolicy = numberPolicy;
        this.nameOfInsuranceCompany = nameOfInsuranceCompany;
    }

    public long getNumberPolicy() {
        return numberPolicy;
    }

    public void setNumberPolicy(long numberPolicy) {
        this.numberPolicy = numberPolicy;
    }

    public String getNameOfInsuranceCompany() {
        return nameOfInsuranceCompany;
    }

    public void setNameOfInsuranceCompany(String nameOfInsuranceCompany) {
        this.nameOfInsuranceCompany = nameOfInsuranceCompany;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Number policy: " + numberPolicy + "Name: " + nameOfInsuranceCompany  + super.toString())).toString();
    }
}
