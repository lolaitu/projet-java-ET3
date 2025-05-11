package reader.linker;

import struct.link.OrganisationOrganisation;
import java.io.IOException;
import reader.Reader;

public class OrganisationOrganisationReader extends Reader<OrganisationOrganisation> {

    public OrganisationOrganisationReader() throws IOException {
        super("data/organisation-organisation.tsv");
    }

    @Override
    protected OrganisationOrganisation parseLine(String[] values) {
        return new OrganisationOrganisation(
                values[1],
                values[2],
                values[3],
                values[4]
        );
    }
}