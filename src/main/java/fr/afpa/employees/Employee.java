package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee {
	/**
	 * Matricule de l'employé
	 */
	private String registrationNumber;

	// TODO compléter les attributs comme présenté dans le PDF
	private String lastName;
	private String firstName;
	private double salary;
	private LocalDate birthDate;
	private final int socialRate = 30;

	// TODO compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDate) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthDate = LocalDate.parse(birthDate);

	}

	// TODO implémenter les setters et getters de la classe (permet d'accéder aux
	// attributs privés)
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * TODO implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	 * qui représente un objet de la classe employé
	 * plus d'information sur la méthode "toString()" ->
	 * https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
	 */
	@Override
	public String toString() {// réimplémentationde la classe to string.
		return "Employee [registrationNumber=" + registrationNumber + ", lastName=" + lastName + ", firstName="
				+ firstName + ", salary=" + salary + ", birthDate=" + birthDate + ", Salaire Net=" + NetSalary() + "]";
	}

	public double NetSalary() {

		return this.salary - (this.salary * (this.socialRate / 100.0));
	}

	// à commenter correctement!!!!!!!!!!!
	public long DayBeforeBirthdate() {
		LocalDate currenDate = LocalDate.now();
		LocalDate nextBirthDate = this.birthDate.withYear(currenDate.getYear());

		if (nextBirthDate.isBefore(currenDate) || nextBirthDate.isEqual(currenDate)) {
			nextBirthDate = nextBirthDate.plusYears(1);
		}

		return ChronoUnit.DAYS.between(currenDate, nextBirthDate);

	}

	/**
	 * objectif vérifier la validité du matricule
	 * Le matricule est une valeur composée de 7 caractères observant les règles
	 * suivantes
	 * nnXXXnn où n est un chiffre et X un caractère alphabétique (par exemple, le
	 * matricule « 11A 22 »
	 * est correct,« Y5 22 » est incorrect).
	 * Dans un premier temps, cette contrainte ne sera pas prise en compte.
	 * 
	 * Le nom et le prénom :
	 * le doit pas être vide et ne doit pas contenir de chiffres
	 * Le format de la date :
	 */

	private boolean checkRegistrationNumber(String inputTocheck) {

		String inputToCheck = "12xxx65";
		
		boolean checkRegistrationNumber = false;

		for (int index = 0; index < inputToCheck.length(); index++) {// index = longueur de intupToCheck - 1 = 6
			char ch = inputToCheck.charAt(index);
			if (index == 0 || index == 1 || index == 5 || index == 6) {
				if (Character.isDigit(ch)) {
					return true;
				}
			} else {
				return false;
			}
		}
		for (int index = 0; index < inputToCheck.length(); index++) { // pourquoi est ton obligé de re - déclarer la variable index ici??
			char ch2 = inputToCheck.charAt(index);
			if (index == 2 || index ==3 || index == 4){
				if (Character.isLetter(ch2)){
					return true;
				}
				else return false;
			}

		}
		return checkRegistrationNumber;
	}
}
