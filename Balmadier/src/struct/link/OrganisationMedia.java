package struct.link;

public class OrganisationMedia {
    private String origine;
    private String qualificatif;
    private String valeur;
    private String cible;

    public OrganisationMedia(String origine, String qualificatif, String valeur, String cible) {
        this.origine = origine;
        this.qualificatif = qualificatif;
        this.valeur = valeur;
        this.cible = cible;
    }

    // Getters
    public String getOrigine() {
        return origine;
    }

    public String getQualificatif() {
        return qualificatif;
    }

    public String getValeur() {
        return valeur;
    }

    public String getCible() {
        return cible;
    }

    @Override
    public String toString() {
        return "OrganisationMedia{" +
                "origine='" + origine + '\'' +
                ", qualificatif='" + qualificatif + '\'' +
                ", valeur='" + valeur + '\'' +
                ", cible='" + cible + '\'' +
                '}';
    }
}