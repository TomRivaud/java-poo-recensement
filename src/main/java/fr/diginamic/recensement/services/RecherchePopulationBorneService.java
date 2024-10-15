package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exceptions.LetterEnteredWaitForNb;
import fr.diginamic.recensement.services.exceptions.MaxInferiorToMin;
import fr.diginamic.recensement.services.exceptions.ValeurInconnu;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws LetterEnteredWaitForNb, MaxInferiorToMin, ValeurInconnu {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		if(!NumberUtils.isCreatable(choix) || choix == ""){
			throw new LetterEnteredWaitForNb("Veuillez renseigner des chiffres !");
		}

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		if(!NumberUtils.isCreatable(saisieMin) || saisieMin == "" || Integer.parseInt(saisieMin) < 0){
			throw new LetterEnteredWaitForNb("Veuillez renseigner des chiffres ! ");
		}


		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		if(!NumberUtils.isCreatable(saisieMax) || saisieMax == ""|| Integer.parseInt(saisieMin) < 0){
			throw new LetterEnteredWaitForNb("Veuillez renseigner des chiffres !");
		} else if (Integer.parseInt(saisieMax) < Integer.parseInt(saisieMin)) {
			throw new MaxInferiorToMin("Le max doit être supérieur au min !");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
			else {
				throw new ValeurInconnu("Le code département n'existe pas !");
			}
		}
	}

}
