// java
package Nomina;
// Fig. 9.7: BasePlusCommissionEmployeeTest.java
// BasePlusCommissionEmployee test program.

import java.util.Scanner;

public class BasePlusCommissionEmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese datos del BasePlusCommissionEmployee:");
        System.out.print("First name: ");
        String first = sc.nextLine();
        System.out.print("Last name: ");
        String last = sc.nextLine();
        System.out.print("Social security number: ");
        String ssn = sc.nextLine();
        System.out.print("Gross sales: ");
        double gross = readDouble(sc);
        System.out.print("Commission rate (ej. 0.04): ");
        double rate = readDouble(sc);
        System.out.print("Base salary: ");
        double base = readDouble(sc);

        // instantiate BasePlusCommissionEmployee object con valores ingresados
        BasePlusCommissionEmployee employee =
                new BasePlusCommissionEmployee(first, last, ssn, gross, rate, base);

        // get base-salaried commission employee data
        System.out.println("\nEmployee information obtained by get methods:\n");
        System.out.printf("%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
        System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());

        // permitir al usuario modificar el salario base (evita valor fijo)
        System.out.print("\nIngrese un nuevo base salary para actualizar (o ingrese el mismo): ");
        double newBase = readDouble(sc);
        employee.setBaseSalary(newBase);

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee.toString());

        sc.close();
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Introduzca un número: ");
            }
        }
    }
}



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
