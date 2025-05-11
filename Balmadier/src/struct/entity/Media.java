package struct.entity;

public class Media {
    String Nom;
    String Type;
    String Periodicite;
    String Echelle;
    String Prix;
    boolean Disparu;

    public Media(String nom, String type, String periodicite, String echelle, String prix, boolean disparu){
        Nom = nom;
        Type = type;
        Periodicite = periodicite;
        Echelle = echelle;
        Prix = prix;
        Disparu = disparu;
    }

    public String getNom() {
        return Nom;
    }

    public String getType() {
        return Type;
    }

    public String getPeriodicite() {
        return Periodicite;
    }

    public String getEchelle() {
        return Echelle;
    }

    public String getPrix() {
        return Prix;
    }

    public boolean isDisparu() {
        return Disparu;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s",
                Nom,
                Type.isEmpty() ? "" : " (" + Type + ")",
                Periodicite.isEmpty() ? "" : " - " + Periodicite,
                Echelle.isEmpty() ? "" : " - " + Echelle,
                Prix.isEmpty() ? "" : " - " + Prix,
                Disparu ? " [Disparu]" : ""
        );
    }
}
