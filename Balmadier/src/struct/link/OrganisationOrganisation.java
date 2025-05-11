package struct.link;

public class OrganisationOrganisation {
    String Origine;
    String Qualificatif;
    String Valeur;
    String Cible;

    public OrganisationOrganisation(String origine, String qualificatif, String valeur, String cible) {
        Origine = origine;
        Qualificatif = qualificatif;
        Valeur = valeur;
        Cible = cible;
    }

    public String getCible() {
        return Cible;
    }

    public String getOrigine() {
        return Origine;
    }

    public String getQualificatif() {
        return Qualificatif;
    }

    public String getValeur() {
        return Valeur;
    }

    @Override
    public String toString() {
        return "OrganiastionOrganisation{" +
                "Origine='" + Origine + '\'' +
                ", Qualificatif='" + Qualificatif + '\'' +
                ", Valeur='" + Valeur + '\'' +
                ", Cible='" + Cible + '\'' +
                '}';
    }
}
