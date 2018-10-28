package ai173.feskova.polyclinic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Polyclinic {
    private int number;
    private String address;
    private PatientsCard[] arrayOfPatientCard;

    public Polyclinic(int number, String address) {
        this.number = number;
        this.address = address;
        this.arrayOfPatientCard = new PatientsCard[0];
    }

    public Polyclinic(int number, String address, PatientsCard[] arrayOfPatientCard) {
        this.number = number;
        this.address = address;
        this.arrayOfPatientCard = arrayOfPatientCard;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfPatients() {
        return arrayOfPatientCard.length;
    }

    public PatientsCard getPatientCardByPolicyNumber(long policyNumber) {
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if (arrayOfPatientCard[i].getInsurancePolicy()!=null && arrayOfPatientCard[i].getInsurancePolicy().getNumberPolicy() == policyNumber) {
                return arrayOfPatientCard[i];
            }
        }
        return null;
    }

    public PatientsCard[] getArrayCardPatientsByAddress(String address) {
        PatientsCard[] patients = new PatientsCard[0];
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if (address.equals(arrayOfPatientCard[i].getAddress())) {
                patients = Arrays.copyOf(patients, patients.length + 1);
                patients[patients.length - 1] = arrayOfPatientCard[i];
            }
        }
        return patients;
    }

    public void removeCard(long policyNumber) {
        boolean isFound = false;
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if (isFound) {
                if (i == (arrayOfPatientCard.length - 1)) {
                    this.arrayOfPatientCard = Arrays.copyOf(this.arrayOfPatientCard, arrayOfPatientCard.length - 1);
                } else {
                    arrayOfPatientCard[i] = arrayOfPatientCard[i + 1];
                    continue;
                }
            }
            if (arrayOfPatientCard[i].getInsurancePolicy()!=null && arrayOfPatientCard[i].getInsurancePolicy().getNumberPolicy() == policyNumber) {
                isFound = true;
                if (i == (arrayOfPatientCard.length - 1)) { //Если элемент последний то перезаписваем в масив не элемент меньше
                    this.arrayOfPatientCard = Arrays.copyOf(this.arrayOfPatientCard, arrayOfPatientCard.length - 1);
                    break;
                }
                arrayOfPatientCard[i] = arrayOfPatientCard[i + 1];
            }
        }
    }

    public void addCard(PatientsCard patientsCard) {
        this.arrayOfPatientCard = Arrays.copyOf(this.arrayOfPatientCard, arrayOfPatientCard.length + 1);
        arrayOfPatientCard[arrayOfPatientCard.length - 1] = patientsCard;
    }

    public PatientsCard[] getArrayOfPatientCard() {
        return arrayOfPatientCard;
    }

    public PatientsCard[] getSortArrayCardByAddress() {
        boolean posIsChanged = false;
        do {
            posIsChanged = false;
            for (int i = 0; i < arrayOfPatientCard.length - 1; i++) {
                if (arrayOfPatientCard[i].getAddress().compareTo(arrayOfPatientCard[i+1].getAddress()) > 0) {
                    swapPos(i, i+1);
                    posIsChanged = true;
                }
            }
        }
        while (posIsChanged);
        return arrayOfPatientCard;
    }

    private void swapPos(int i, int j) {
        PatientsCard tmp;
        tmp = arrayOfPatientCard[i];
        arrayOfPatientCard[i] = arrayOfPatientCard[j];
        arrayOfPatientCard[j] = tmp;
    }

    public int getTotalNumberObligatory() {
        int count = 0;
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if(arrayOfPatientCard[i].getInsurancePolicy() instanceof  ObligatoryMedicalInsurancePolicy) {
                count++;
            }
        }
        return count;
    }

    public int getTotalNumberVolontary() {
        int count = 0;
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if(arrayOfPatientCard[i].getInsurancePolicy() instanceof VoluntaryMedicalInsurancePolicy) {
                count++;
            }
        }
        return count;
    }

    public int getTotalNumberPaidPatientsCard() {
        int count = 0;
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if (arrayOfPatientCard[i] instanceof PaidPatientsCard) {
                if (!(arrayOfPatientCard[i].getInsurancePolicy() instanceof VoluntaryMedicalInsurancePolicy)) {
                    if(((PaidPatientsCard)arrayOfPatientCard[i]).getAmountOfMoneyLeftInClinicByPatient() > 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public double getTotalySumTransfers(Date date) {
        double amountMoney = 0;
        for (int i = 0; i < arrayOfPatientCard.length; i++) {
            if (arrayOfPatientCard[i] instanceof PaidPatientsCard) {
                ArrayList<Bill> bills = ((PaidPatientsCard) arrayOfPatientCard[i]).getbillsPerDay(date);
                for (int j = 0; j < bills.size(); j++) {
                    amountMoney += bills.get(j).getAmountOfMedicalServicesForDay();
                }
            }
        }
        return amountMoney;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Name: " + number + "Address: " + address + "Card of Patients: " +arrayOfPatientCard + super.toString())).toString();
    }
}
