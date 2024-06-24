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

	//attributs comme présenté dans le PDF
	private String lastName;
	private String firstName;
	private double salary;
	private LocalDate birthDate;
	private final int socialRate = 30;

	// constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDate) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthDate = LocalDate.parse(birthDate);

	}

	// setters et getters de la classe (permet d'accéder aux
	// attributs privés)


	// getter
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

	// setter

	public void setRegistrationNumber(String registrationNumber)  throws Exception{
		// A ce niveau, tentative de modification du matricule
		// Nous devons VERIFIER le matricule !
		// -----> PROGRAMMATION DEFENSIVE = vérification des paramètres d'entrée ->
		// registrationNumber
		boolean isRegistrationNumber = checkRegistrationNumber(registrationNumber);

		if (isRegistrationNumber == true) {
			// VRAI donc c'est bien un matricule correct :)
			// Modification du matricule
			this.registrationNumber = registrationNumber;
		} else {
			// FAUX donc on fait quelque chose pour traiter ce cas
			// ??? (indice/solution : on jette une exception)
			//Exception = erreur
			throw new Exception("Mauvais format du matricule");
		
		}
	}

	public void setLastname(String lastName) throws Exception{
		this.lastName = lastName;
		boolean isLastname = checkFirstName(lastName);
		if (isLastname = true){
			this.firstName = firstName;
		}else{
			throw new Exception("Nom écrit dans le mauvais format");
		}
		

	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	
	}



	public void setFirstName(String firstName) throws Exception{
		boolean isFirstName = checkFirstName(firstName);
		if (isFirstName = true){
			this.firstName = firstName;
		}else{
			throw new Exception("Mauvais format de prénom");
		}
		

	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	

	/**TODO implémenter
	la méthode"toString()"
	qui renvoie
	une chaîne
	de caractère*
	qui représente
	un objet
	de la
	classe employé*plus d'information sur
	la méthode"toString()"-> https:// codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
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

	/**
	 * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel
	 * correctement formaté ou non
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un matricule, FAUX sinon
	 */
	private boolean checkRegistrationNumber(String inputToCheck) {

		// Vérification de la taille de la chaîne de caractères
		if (inputToCheck.length() != 7) {
			return false;
		}

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isRegistrationNumber = false;

		// Cette première boucle permet de passer en revue TOUS les caractères de la
		// chaîne
		for (int index = 0; index < inputToCheck.length(); index++) {
			// index = longueur de intupToCheck - 1 = 6
			char ch = inputToCheck.charAt(index);
			if (index == 0 || index == 1 || index == 5 || index == 6) {

				// vérification du caractère, s'agit-il d'un chiffre ?
				if (Character.isDigit(ch) == true) {
					isRegistrationNumber = true;
				} else { // attention, ce n'est pas un chiffre
					return false; // return false permet d'arreter aussitôt lorsque la boucle détecte une erreur.
					//elle stockera la variable dans la le retour tout en bas de la fonction.
				}

			} else { // cas de la position 2, 3 ou 4 -> vérification de letter

				// Quelle opération dois-je faire ?
				if (Character.isLetter(ch)) {
					isRegistrationNumber = true;
				} else {
					return false;
				}
			}
		} // fin du FOR, BRAVO !

		return isRegistrationNumber;
	}



	    /**
     * Vérifie qu'une chaîne de caractères passée en paramètre est un prénom
     * 
     * Règles de vérification :
     * Un prénom ne doit pas comporter de chiffres, ni de caractère spéciale tel que '#', '$', '%', '/, '\'
     * 
     * @param inputToCheck La chaîne de caractère à vérifier
     * @return VRAI s'il s'agit d'un prénom correctement formaté, FAUX sinon
     */
    
	
	 private boolean checkFirstName(String inputToCheck) {
    
        // déclaration du booléen qui va stocker le résultat de la vérification
        // VRAI -> la chaîne de caractères passée en paramètre est un matricule correctement formaté
        // FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien formaté
        boolean isFistName= false;

		
	

        for (int index = 0; index < inputToCheck.length(); index++) {
				// index = longueur de intupToCheck en fonction de la taille du prénom
				char ch = inputToCheck.charAt(index);
			// condition disant que si le caractères est different des caractère spéciaciaux le résultat est vrai sinon retourne faux.
			if (ch != '#' || ch !='$'||ch != '/' ||ch != '\'')  {
			isFistName = true;

			}else{
				return false;
			}
				
			if (Character.isLetter(ch)) {
				isFistName = true;
			} else {
				return false;
			}

		}
		return isFistName;
    }

}