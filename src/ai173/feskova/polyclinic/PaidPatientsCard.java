package ai173.feskova.polyclinic;

import java.util.ArrayList;
import java.util.Date;

public class PaidPatientsCard extends PatientsCard {
    private ArrayList<Bill> moneyLeftInClinicByPatient;

    public PaidPatientsCard(String name, String surname) {
        super(name, surname);
        moneyLeftInClinicByPatient = new ArrayList<>(0);
    }

    public PaidPatientsCard(String name, String surname, String address) {
        super(name, surname, address);
        moneyLeftInClinicByPatient = new ArrayList<>(0);
    }

    public PaidPatientsCard(String name, String surname, String address, MedicalInsurancePolicy insurancePolicy) {
        super(name, surname, address, insurancePolicy);
        moneyLeftInClinicByPatient = new ArrayList<>(0);
    }

    public PaidPatientsCard(String name, String surname, String address, MedicalInsurancePolicy insurancePolicy, ArrayList<Bill> moneyLeftInClinicByPatient) {
        super(name, surname, address, insurancePolicy);
        this.moneyLeftInClinicByPatient = moneyLeftInClinicByPatient;
    }

    public ArrayList<Bill> getMoneyLeftInClinicByPatient() {
        return moneyLeftInClinicByPatient;
    }

    public void setMoneyLeftInClinicByPatient(ArrayList<Bill> moneyLeftInClinicByPatient) {
        this.moneyLeftInClinicByPatient = moneyLeftInClinicByPatient;
    }

    public double getAmountOfMoneyLeftInClinicByPatient() {
        double sum = 0;
        for (int i = 0; i < moneyLeftInClinicByPatient.size(); i++) {
            sum += moneyLeftInClinicByPatient.get(i).getAmountOfMedicalServicesForDay();
        }
        return sum;
    }

    public ArrayList<Bill>  getbillsPerDay (Date date) {
        ArrayList<Bill> bills = new ArrayList<>(0);
        for (int i = 0; i < moneyLeftInClinicByPatient.size(); i++) {
            if (moneyLeftInClinicByPatient.get(i).getDate().compareTo(date) == 0) {
                bills.add(moneyLeftInClinicByPatient.get(i));
            }
        }
        return bills;
    }

    public  void addBill(Bill bill) {
        moneyLeftInClinicByPatient.add(moneyLeftInClinicByPatient.size(), bill);
    }

    public void removeBill(Date date, double sum) {
        for (int i = 0; i < moneyLeftInClinicByPatient.size(); i++) {
            if (moneyLeftInClinicByPatient.get(i).getDate().compareTo(date) == 0 &&
                    moneyLeftInClinicByPatient.get(i).getAmountOfMedicalServicesForDay() == sum) {
                moneyLeftInClinicByPatient.remove(moneyLeftInClinicByPatient.get(i));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof PaidPatientsCard
                && ((PaidPatientsCard) obj).moneyLeftInClinicByPatient.equals(moneyLeftInClinicByPatient);
    }

    @Override
    public int hashCode() {
        final int number = 123456;
        return super.hashCode()^moneyLeftInClinicByPatient.hashCode()^number;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Class PaidPatientsCard Money left in clinic by patient: " + moneyLeftInClinicByPatient  + super.toString())).toString();
    }
}