package ai173.feskova;


import ai173.feskova.polyclinic.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Polyclinic polyclinic = new Polyclinic(123, "M.G", new PatientsCard[] {
                new PaidPatientsCard("Lera", "Dulevets"),
                new SocialPatientsCard("Jenya", "Surname", "M.D", new VoluntaryMedicalInsurancePolicy()),
                new PaidPatientsCard("Test", "Tet2", "M.D", new ObligatoryMedicalInsurancePolicy(), new ArrayList<>(List.of(
                        new Bill(new Date(2018, 2, 1), 1000, Bill.TypeOfMedicalService.ophthalmology),
                        new Bill(new Date(2018, 3, 2), 3000, Bill.TypeOfMedicalService.surgery))
                )),
                new SocialPatientsCard("Tets", "test", "tesT", new VoluntaryMedicalInsurancePolicy())
        });

        System.out.println("Test getTotalNumberPaidPatientsCard: " + (polyclinic.getTotalNumberPaidPatientsCard() == 1));
        System.out.println("Test getTotalySumTransfers: " + (polyclinic.getTotalySumTransfers(new Date(2018,2, 1)) == 1000));
        ((PaidPatientsCard) polyclinic.getArrayOfPatientCard()[2]).addBill(new Bill(new Date(2018,2,1), 1000, Bill.TypeOfMedicalService.ophthalmology));
        System.out.println("Test getTotalySumTransfers: " + (polyclinic.getTotalySumTransfers(new Date(2018,2, 1)) == 2000));

        polyclinic.getArrayOfPatientCard()[3].getInsurancePolicy().setNumberPolicy(231);
        polyclinic.removeCard(231);
        System.out.println("Test removeByNumber: " + (polyclinic.getArrayOfPatientCard().length == 3));

        System.out.println("Test getArrayCardPatientsByAddress: " + (polyclinic.getArrayCardPatientsByAddress("M.D").length == 2));

        polyclinic.getArrayOfPatientCard()[2].getInsurancePolicy().setNumberPolicy(321);
        System.out.println("Test getPatientCardByPolicyNumber: " + (polyclinic.getPatientCardByPolicyNumber(321).getName().compareTo( "Test") == 0));

        polyclinic.addCard(new SocialPatientsCard("test", "test", "A.B"));
        polyclinic.addCard(new SocialPatientsCard("test", "test", "Z.B"));
        PatientsCard[] patientsCards = polyclinic.getSortArrayCardByAddress();
        for (PatientsCard patientsCard : patientsCards) {
            System.out.println(patientsCard.getAddress());
        }

        System.out.println("Test getTotalNumberObligatory " + (polyclinic.getTotalNumberObligatory() == 1));
        System.out.println("Test getTotalNumberVoluntary " + (polyclinic.getTotalNumberVolontary() == 1));

        PaidPatientsCard paidPatientsCard = new PaidPatientsCard("test", "test", "sdfdf", new ObligatoryMedicalInsurancePolicy(),
                new ArrayList<>(List.of(new Bill(new Date(2018,2,3), 2000, Bill.TypeOfMedicalService.stomatology),
                        new Bill(new Date(2018,4,5), 4000, Bill.TypeOfMedicalService.ophthalmology))));
        System.out.println("Test getAmountOfMoneyLeftInClinicByPatient " + (paidPatientsCard.getAmountOfMoneyLeftInClinicByPatient() == 6000));
    }

}