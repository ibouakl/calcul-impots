package fr.gouv.impots;

import fr.gouv.impots.domain.AutoEntreprise;
import fr.gouv.impots.domain.Entreprise;
import fr.gouv.impots.domain.EntrepriseType;
import fr.gouv.impots.domain.SASEntreprise;
import fr.gouv.impots.exceptions.InvalidCAException;
import fr.gouv.impots.service.CalculateImpotsService;
import fr.gouv.impots.service.impl.CalculateImpotsServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class CalculateImpotsServiceImplTest {


    private CalculateImpotsService calculateImpotsService;

    @Before
    public void init() {
        this.calculateImpotsService = new CalculateImpotsServiceImpl();
    }

    @Test
    public void calculate_impots_for_auto_entreprise_should_work_correctly() {
        // Given
        Entreprise autoEntreprise = new AutoEntreprise("304 823 048 11027", "fake denomination AutoEntreprise");
        assertThat(autoEntreprise.getType()).isEqualTo(EntrepriseType.AUTO_ENTREPRISE);

        // When
        Double actualResult = calculateImpotsService.calculateImpots(autoEntreprise, 10000.0);

        // Then
        assertThat(actualResult).isEqualTo(2500);

    }

    @Test
    public void calculate_impots_for_auto_entreprise_should_work_correctly_if_ca_is_zero() {
        // Given
        Entreprise autoEntreprise = new AutoEntreprise("304 823 048 11027", "fake denomination AutoEntreprise");
        assertThat(autoEntreprise.getType()).isEqualTo(EntrepriseType.AUTO_ENTREPRISE);

        // When
        Double actualResult = calculateImpotsService.calculateImpots(autoEntreprise, 0.0);

        // Then
        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    public void calculate_impots_for_auto_entreprise_should_throw_exception_if_CA_is_null() {
        // Given
        Entreprise autoEntreprise = new AutoEntreprise("304 823 048 11027", "fake denomination AutoEntreprise");
        assertThat(autoEntreprise.getType()).isEqualTo(EntrepriseType.AUTO_ENTREPRISE);
        // When
        try {
            calculateImpotsService.calculateImpots(autoEntreprise, null);
            fail("Error - expected InvalidCAException to be throwed");
        } catch (InvalidCAException e) {
            // Then
            assertThat(e.getMessage()).contains("Illegal chiffre d'affaire. Value is null");
        }
    }

    @Test
    public void calculate_impots_for_auto_entreprise_should_throw_exception_if_CA_is_negative() {
        // Given
        Entreprise autoEntreprise = new AutoEntreprise("304 823 048 11027", "fake denomination AutoEntreprise");
        assertThat(autoEntreprise.getType()).isEqualTo(EntrepriseType.AUTO_ENTREPRISE);
        // When
        try {
            calculateImpotsService.calculateImpots(autoEntreprise, -1000.0);
            fail("Error - expected InvalidCAException to be throwed");
        } catch (InvalidCAException e) {
            // Then
            assertThat(e.getMessage()).contains("Illegal chiffre d'affaire. Value is -1000.0");
        }
    }

    @Test
    public void calculate_impots_for_SAS_entreprise_should_work_correctly() {
        // Given
        Entreprise sasEntreprise = new SASEntreprise("304 823 048 11022", "fake denomination SASEntreprise", "Fake Address");
        assertThat(sasEntreprise.getType()).isEqualTo(EntrepriseType.SAS);

        // When
        Double actualResult = calculateImpotsService.calculateImpots(sasEntreprise, 10000.0);

        // Then
        assertThat(actualResult).isEqualTo(3300);
    }

    @Test
    public void calculate_impots_for_SAS_entreprise_should_work_correctly_if_ca_is_zero() {
        // Given
        Entreprise sasEntreprise = new SASEntreprise("304 823 048 11022", "fake denomination SASEntreprise", "Fake Address");
        assertThat(sasEntreprise.getType()).isEqualTo(EntrepriseType.SAS);

        // When
        Double actualResult = calculateImpotsService.calculateImpots(sasEntreprise, 0.0);

        // Then
        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    public void calculate_impots_for_SAS_entreprise_should_throw_exception_if_CA_is_null() {
        // Given
        Entreprise sasEntreprise = new SASEntreprise("304 823 048 11022", "fake denomination SASEntreprise", "Fake Address");
        assertThat(sasEntreprise.getType()).isEqualTo(EntrepriseType.SAS);

        // When
        try {
            calculateImpotsService.calculateImpots(sasEntreprise, null);
            fail("Error - expected InvalidCAException to be throwed");
        } catch (InvalidCAException e) {
            assertThat(e.getMessage()).contains("Illegal chiffre d'affaire. Value is null");
        }
    }

    @Test
    public void calculate_impots_for_SAS_entreprise_should_throw_exception_if_CA_is_negative() {
        // Given
        Entreprise sasEntreprise = new SASEntreprise("304 823 048 11022", "fake denomination SASEntreprise", "Fake Address");
        assertThat(sasEntreprise.getType()).isEqualTo(EntrepriseType.SAS);

        // When
        try {
            calculateImpotsService.calculateImpots(sasEntreprise, -1000.0);
            fail("Error - expected InvalidCAException to be throwed");
        } catch (InvalidCAException e) {
            assertThat(e.getMessage()).contains("Illegal chiffre d'affaire. Value is -1000.0");
        }
    }
}
