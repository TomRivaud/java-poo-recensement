package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.services.exceptions.LetterEnteredWaitForNb;
import fr.diginamic.recensement.services.exceptions.MaxInferiorToMin;
import fr.diginamic.recensement.services.exceptions.ValeurInconnu;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws LetterEnteredWaitForNb, MaxInferiorToMin, ValeurInconnu;
}
