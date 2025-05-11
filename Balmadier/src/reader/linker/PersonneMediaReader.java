package reader.linker;

import struct.link.PersonneMedia;
import java.io.IOException;
import reader.Reader;

public class PersonneMediaReader extends Reader<PersonneMedia> {

    public PersonneMediaReader() throws IOException {
        super("data/personne-media.tsv");
    }

    @Override
    protected PersonneMedia parseLine(String[] values) {
        return new PersonneMedia(
                values[1],
                values[2],
                values[3],
                values[4]
        );
    }
}