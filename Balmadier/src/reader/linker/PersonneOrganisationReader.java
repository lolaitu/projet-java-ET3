package reader.linker;

import struct.link.PersonneOrganisation;
import java.io.IOException;
import reader.Reader;

public class PersonneOrganisationReader extends Reader<PersonneOrganisation> {

    public PersonneOrganisationReader() throws IOException {
        super("data/personne-organisation.tsv");
    }

    @Override
    protected PersonneOrganisation parseLine(String[] values) {
        return new PersonneOrganisation(
                values[1],
                values[2],
                values[3],
                values[4]
        );
    }
}