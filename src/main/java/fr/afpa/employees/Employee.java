package fr.afpa.employees;

/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee
{
	/**
	 * Matricule de l'employé
	 */
	private String registrationNumber;

	// TODO compléter les attributs comme présenté dans le PDF
	private String lastName;
	private String firstName;
	private double salary;
	private final int socialRate = 30;

	// TODO compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
	
	}

	// TODO implémenter les setters et getters de la classe (permet d'accéder aux attributs privés)
//
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getLastName() {
			return lastName;
	}
	public String getFirstName() {
				return firstName;
	}			
	public double getSalary() {
				return salary;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setLastname(String lastName)  {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName)  {
		this.firstName = firstName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}




	// TODO implémenter la méthode "toString()" qui renvoie une chaîne de caractère qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" -> https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring

	@Override
	public String toString() {
		return "Employee [registrationNumber=" + registrationNumber + ", lastName=" + lastName + ", firstName="
				+ firstName + ", salary=" + salary + ", socialRate=" + socialRate + "]";
	}

}
