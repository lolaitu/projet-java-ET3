package reader.entity;

import struct.entity.Personne;
import java.io.IOException;
import reader.Reader;

public class PersonneReader extends Reader<Personne> {

    public PersonneReader() throws IOException {
        super("data/personnes.tsv");
    }

    @Override
    protected Personne parseLine(String[] values) {
        try {
            return new Personne(
                    values[0], // Pas de conversion pour le premier champ (supposé être une String)
                    parseSafeInt(values[1]),
                    parseSafeInt(values[2]),
                    parseSafeInt(values[3]),
                    parseSafeInt(values[4]),
                    parseSafeInt(values[5]),
                    parseSafeInt(values[6]),
                    parseSafeInt(values[7]),
                    parseSafeInt(values[8])
            );
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Erreur: ligne mal formatée, nombre de colonnes insuffisant");
            return null;
        } catch (Exception e) {
            System.err.println("Erreur inattendue lors de la lecture de la ligne");
            return null;
        }
    }

    /**
     * Méthode utilitaire pour convertir une String en int en gérant les cas vides
     * @param value la valeur à convertir
     * @return 0 si value est vide, sinon la valeur convertie en int
     */
    private int parseSafeInt(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion pour la valeur: '" + value + "', utilisation de 0 par défaut");
            return 0;
        }
    }
}
