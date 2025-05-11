package reader.entity;

import struct.entity.Organisation;

import java.io.IOException;
import reader.Reader;

public class OrganisationReader extends Reader<Organisation> {

    public OrganisationReader() throws IOException {
        super("data/organisations.tsv");
    }

    @Override
    protected Organisation parseLine(String[] values) {
        try {
            return new Organisation(values[0], values[1]);
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion");
            return null;
        }
    }
}
