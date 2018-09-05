package fr.gouv.impots.service;

import fr.gouv.impots.domain.Entreprise;


public interface CalculateImpotsService {

    /**
     *
     * @param entreprise represente une entreprise donnée
     * @param chiffreAffaire represente le chiffre d'affaire d'une entreprise donnée
     * @return
     */
    Double calculateImpots(Entreprise entreprise, Double chiffreAffaire);
}
