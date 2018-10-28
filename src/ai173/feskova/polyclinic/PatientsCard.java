package ai173.feskova.polyclinic;

abstract public class PatientsCard {
    private String name;
    private String surname;
    private String address;
    private MedicalInsurancePolicy insurancePolicy;

    public PatientsCard(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public PatientsCard(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public PatientsCard(String name, String surname, String address, MedicalInsurancePolicy insurancePolicy) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.insurancePolicy = insurancePolicy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address==null?"":address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MedicalInsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(MedicalInsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof PatientsCard
                && ((PatientsCard) obj).address.equals(address)
                && ((PatientsCard) obj).name.equals(name)
                && ((PatientsCard) obj).surname.equals(surname)
                && ((PatientsCard) obj).insurancePolicy.equals(insurancePolicy);
    }

    @Override
    public int hashCode() {
        final int number = 238257;
        return super.hashCode()^
                (name!=null?name.hashCode():0)
                ^(surname!=null?surname.hashCode():0)
                ^(address!=null?address.hashCode():0)
                ^(insurancePolicy!=null?insurancePolicy.hashCode():0)^number;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Class PatientCard Name: " + name + "Surname: " + surname + "Address: " + address + "InsurancePolicy: " + insurancePolicy + super.toString())).toString();
    }
}
