package fr.gouv.impots.service.impl;

import fr.gouv.impots.domain.Entreprise;
import fr.gouv.impots.exceptions.InvalidCAException;
import fr.gouv.impots.service.CalculateImpotsService;

public class CalculateImpotsServiceImpl implements CalculateImpotsService {


    public Double calculateImpots(Entreprise entreprise, Double ca) {
        if (ca == null || ca.doubleValue() < 0) {
            throw new InvalidCAException(String.format("Illegal chiffre d'affaire. Value is %s", ca));
        }
        return entreprise.getTauxImposition() * ca;
    }
}
