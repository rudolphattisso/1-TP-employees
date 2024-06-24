package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain
{
	public static void main(String[] args) 
	{
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// TODO instanciez 4 objets de la classe "Employee" (une fois celle-ci implémentée)
		LocalDate birthDate = LocalDate.parse("1990-02-25");
		Employee employee1 = new Employee("jlfj15", "NONO", "Laurent", 1500.80, "1996-02-25");
		Employee employee2 = new Employee("jlfj16", "NONO", "Zunon", 15075.60, "1995-02-23");
		Employee employee3 = new Employee("jlfj17", "NONO", "fraqua", 1560.70, "1996-02-24");
		System.out.println(employee1.getFirstName());
		//employee1.setFirstName("robin");
		System.out.println(employee1.getFirstName());
		System.out.println(employee1.toString());
		System.out.println(employee2.NetSalary());
		

        // Tentative de modification avec un matricule correctement formaté
      
		try{
			employee1.setRegistrationNumber("64AZE88");

			employee1.setRegistrationNumber("EEAZE88");

			employee1.setRegistrationNumber("6444433");
	
			employee1.setRegistrationNumber("64AZ");
	
			employee1.setRegistrationNumber("6");
	
			employee1.setRegistrationNumber("");
			
			employee1.setRegistrationNumber("987654");
			
		}catch (Exception e){
			System.out.println("erreur");
		}

        // test des matricules en erreur

		// TODO afficher les informations des employés avec System.out.println
	}
}

