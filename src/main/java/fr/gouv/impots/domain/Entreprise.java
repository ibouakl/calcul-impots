package fr.gouv.impots.domain;

public abstract class Entreprise {

    private final Siret siret;
    private final String denomination;
    private final EntrepriseType type;

    public Entreprise(String siret, String denomination, EntrepriseType type) {
        this.siret = new Siret(siret);
        this.denomination = denomination;
        this.type = type;
    }

    /**
     * Taux imposition pour une entreprise. chaque type d'entreprise a son propre taux
     *
     * @return
     */
    public abstract Double getTauxImposition();

    public Siret getSiret() {
        return siret;
    }

    public String getDenomination() {
        return denomination;
    }

    public EntrepriseType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entreprise that = (Entreprise) o;

        return siret != null ? siret.equals(that.siret) : that.siret == null;
    }

    @Override
    public int hashCode() {
        return siret != null ? siret.hashCode() : 0;
    }
}
