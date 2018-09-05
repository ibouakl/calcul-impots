package fr.gouv.impots.domain;

public class Siret {

    private final String number;

    public Siret(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Siret siret = (Siret) o;

        return number != null ? number.equals(siret.number) : siret.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }


}
