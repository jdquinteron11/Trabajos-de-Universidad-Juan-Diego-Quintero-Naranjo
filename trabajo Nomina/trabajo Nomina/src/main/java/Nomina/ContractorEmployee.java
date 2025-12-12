package Nomina;

public class ContractorEmployee extends BasePlusCommissionEmployee {

    public ContractorEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, baseSalary);
    }

    /*
    * TODO: Implementar el metodo earning para un empleado
    *  que tiene un salarion por un contrato
    * y que su comision corresponde a un %5 del valor del contrato
    * y el %3  de la comision sobre el valor de la venta*/
    @Override
    public double earnings() {
        return super.earnings();
    }
}
