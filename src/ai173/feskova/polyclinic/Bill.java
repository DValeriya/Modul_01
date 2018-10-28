package ai173.feskova.polyclinic;

import java.util.Date;

public class Bill {
    private Date date;
    private double amountOfMedicalServicesForDay;
    public enum TypeOfMedicalService {stomatology, endocrinology, surgery,professionalExamination, ophthalmology};
    private TypeOfMedicalService typeOfMedicalService;

    public Bill(Date date, double amountOfMedicalServicesForDay, TypeOfMedicalService typeOfMedicalService) {
        this.date = date;
        this.amountOfMedicalServicesForDay = amountOfMedicalServicesForDay;
        this.typeOfMedicalService = typeOfMedicalService;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmountOfMedicalServicesForDay() {
        return amountOfMedicalServicesForDay;
    }

    public void setAmountOfMedicalServicesForDay(double amountOfMedicalServicesForDay) {
        this.amountOfMedicalServicesForDay = amountOfMedicalServicesForDay;
    }

    public TypeOfMedicalService getTypeOfMedicalService() {
        return typeOfMedicalService;
    }

    public void setTypeOfMedicalService(TypeOfMedicalService typeOfMedicalService) {
        this.typeOfMedicalService = typeOfMedicalService;
    }

    @Override
    public String toString() {
        return (new StringBuilder("Date:" + date + "Amount of medical services for day: " + amountOfMedicalServicesForDay + "Type of medical service: " + typeOfMedicalService + super.toString())).toString();
    }
}
