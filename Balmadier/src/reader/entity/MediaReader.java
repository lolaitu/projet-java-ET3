package reader.entity;

import reader.Reader;
import struct.entity.Media;

import java.io.IOException;

public class MediaReader extends Reader<Media> {

    public MediaReader() throws IOException {
        super("data/medias.tsv");
    }

    @Override
    protected Media parseLine(String[] values) {
        try {
            return new Media(values[0], values[1], values[2], values[3], values[4], values[5].equals("checked"));
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion");
            return null;
        }
    }
}
