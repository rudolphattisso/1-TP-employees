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
		Employee employee1 = new Employee("jlfj15", "NONO", "Laurent", 1500.0);
		System.out.println(employee1.getFirstName());
		employee1.setFirstName("robin");
		System.out.println(employee1.getFirstName());
		System.out.println(employee1.toString());
		// TODO afficher les informations des employés avec System.out.println
	}
}

