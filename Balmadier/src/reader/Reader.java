package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader<T> {
    public ArrayList<T> list = new ArrayList<T>();
    private final String filePath;

    protected Reader(String filePath) throws IOException {
        this.filePath = filePath;
        readTsv();
    }

    /**
     * Lit le fichier TSV et retourne une liste d'objets
     */
    protected void readTsv() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                // Ignorer l'en-tête
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split("\t", -1);
                T object = parseLine(values);
                if (object != null) {
                    list.add(object);
                }
            }
        }
    }

    /**
     * Méthode abstraite à implémenter par les sous-classes pour convertir une ligne en objet
     */
    protected abstract T parseLine(String[] values);
}