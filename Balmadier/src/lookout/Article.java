package lookout;

import reader.entity.MediaReader;
import reader.entity.OrganisationReader;
import reader.entity.PersonneReader;
import reader.linker.OrganisationMediaReader;
import reader.linker.OrganisationOrganisationReader;
import reader.linker.PersonneMediaReader;
import reader.linker.PersonneOrganisationReader;
import struct.entity.Media;
import struct.entity.Organisation;
import struct.entity.Personne;
import struct.link.OrganisationMedia;
import struct.link.OrganisationOrganisation;
import struct.link.PersonneMedia;
import struct.link.PersonneOrganisation;
import utils.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Article {
    private String name;
    private List<Media> seenOnMedia;
    private List<Personne> mentionedPerson;

    public Article(String name, List<Media> seenOnMedia, List<Personne> mentionedPerson) {
       this.name = name;
       this.seenOnMedia = seenOnMedia;
       this.mentionedPerson = mentionedPerson;
    }

    public ArrayList<Personne> conflictOfInterests() throws IOException {

        final MediaReader media = new MediaReader();
        final PersonneReader personne = new PersonneReader();
        final OrganisationReader organisation = new OrganisationReader();
        final OrganisationOrganisationReader linkOrgaOrga= new OrganisationOrganisationReader();
        final OrganisationMediaReader linkOrgaMedia = new OrganisationMediaReader();
        final PersonneMediaReader linkPersoMedia = new PersonneMediaReader();
        final PersonneOrganisationReader linkPersoOrga = new PersonneOrganisationReader();

        var result = new ArrayList<Personne>();
        // lien direct
        for (Personne persMent: mentionedPerson) {
            for (PersonneMedia link : Search.inList(linkPersoMedia.list, PersonneMedia::getCible, persMent.getNom()) ) {
                result.addAll( Search.inList(personne.list, Personne::getNom, link.getOrigine()) );
            }
        }

        // organisation ayant un lien avec les differents media
        var orgaLinkedToMedia= new ArrayList<Organisation>();
        for (Personne persMent: mentionedPerson) {
            for (OrganisationMedia link : Search.inList(linkOrgaMedia.list, OrganisationMedia::getCible, persMent.getNom()) ) {
                orgaLinkedToMedia.addAll( Search.inList(organisation.list, Organisation::getNom, link.getOrigine()) );
            }
        }

        var temp1 = new ArrayList<>(orgaLinkedToMedia);
        var temp2 = new ArrayList<>(orgaLinkedToMedia);
        do {
            temp2.clear();
            // chercher les organisations lié au organisation précédente
            for (Organisation orga: temp1) {
                for (OrganisationOrganisation link : Search.inList(linkOrgaOrga.list, OrganisationOrganisation::getCible, orga.getNom()) ) {
                    temp2.addAll( Search.inList(organisation.list, Organisation::getNom, link.getOrigine()) );
                }
            }
            temp1 = temp2;
            orgaLinkedToMedia.addAll(temp2);
        } while (!temp2.isEmpty());

        // personne lier a ces organisation

        for (Organisation orga: orgaLinkedToMedia) {
            for (PersonneOrganisation link : Search.inList(linkPersoOrga.list, PersonneOrganisation::getCible, orga.getNom()) ) {
                result.addAll( Search.inList(personne.list, Personne::getNom, link.getCible()) );
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", seenOnMedia=" + seenOnMedia +
                ", mentionedPerson=" + mentionedPerson +
                '}';
    }
}
