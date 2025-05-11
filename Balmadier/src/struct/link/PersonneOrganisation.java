package struct.link;

public class PersonneOrganisation {
    private String origine;
    private String qualificatif;
    private String valeur;
    private String cible;

    public PersonneOrganisation(String origine, String qualificatif, String valeur, String cible) {
        this.origine = origine;
        this.qualificatif = qualificatif;
        this.valeur = valeur;
        this.cible = cible;
    }

    // Getters
    public String getOrigine() { return origine; }
    public String getQualificatif() { return qualificatif; }
    public String getValeur() { return valeur; }
    public String getCible() { return cible; }

    @Override
    public String toString() {
        return String.format(
                "PersonneOrganisation[origine=%s, qualificatif=%s, valeur=%s, cible=%s]",
                origine, qualificatif, valeur, cible
        );
    }
}