package reader.linker;

import struct.link.OrganisationMedia;
import java.io.IOException;
import reader.Reader;

public class OrganisationMediaReader extends Reader<OrganisationMedia> {

    public OrganisationMediaReader() throws IOException {
        super("data/organisation-media.tsv");
    }

    @Override
    protected OrganisationMedia parseLine(String[] values) {
        return new OrganisationMedia(
                values[1],
                values[2],
                values[3],
                values[4]
        );
    }
}