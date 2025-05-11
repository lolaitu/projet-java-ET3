import lookout.Article;
import reader.entity.MediaReader;
import reader.entity.OrganisationReader;
import reader.entity.PersonneReader;
import reader.linker.OrganisationMediaReader;
import reader.linker.OrganisationOrganisationReader;
import reader.linker.PersonneMediaReader;
import reader.linker.PersonneOrganisationReader;
import struct.link.OrganisationMedia;
import struct.link.OrganisationOrganisation;
import struct.link.PersonneMedia;
import struct.link.PersonneOrganisation;
import utils.Prompt;
import utils.Print;
import utils.Search;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    private final MediaReader media = new MediaReader();
    private final PersonneReader personne = new PersonneReader();
    private final OrganisationReader organisation = new OrganisationReader();
    private final OrganisationOrganisationReader linkOrgaOrga= new OrganisationOrganisationReader();
    private final OrganisationMediaReader linkOrgaMedia = new OrganisationMediaReader();
    private final PersonneMediaReader linkPersoMedia = new PersonneMediaReader();
    private final PersonneOrganisationReader linkPersoOrga = new PersonneOrganisationReader();

    private ArrayList<Article> articles = new ArrayList<>();

    public App() throws IOException {
    }

    public void launch() throws IOException {
        askWichThingsToDo();
        //var mediaSelected = Prompt.numericChoice("choisissez un message", media.list);
        //System.out.println(mediaSelected);
    }

    private void askWichThingsToDo() throws IOException {
        switch (Prompt.numberInput("Voir les entités (1), suivre une entité (2), publier ou diffuser (3), enregistrer un rachat (4) | (0) pour quitter", 4)) {
            case 0 -> System.exit(0);
            case 1 -> askWichListOfEntity();
            case 2 -> askWhatToFollow();
            case 3 -> askWhatToPublish();
            case 4 -> askWhatToBuyback();
        }
    }

    private void askWichListOfEntity() throws IOException {
        switch (Prompt.numberInput("Liste des médias (1), personnes(2), organisation(3) ou article(4) | (0) pour revenir au début", 4)) {
            case 1 -> Print.List(media.list);
            case 2 -> Print.List(personne.list);
            case 3 -> Print.List(organisation.list);
            case 4 -> Print.List(articles);
        }
        launch();
    }

    private void askWhatToFollow() throws IOException {
        switch (Prompt.numberInput("Suivre un médias (1), une personnes(2) ou une organisation(3) | (0) pour revenir au début", 3)) {
            case 1 -> {
                var mediaToFollow = Prompt.numericChoice("Quel media suivre ?", media.list);

                System.out.println("\n Personnes qui possède " + mediaToFollow.getNom() + " :");
                Print.List( Search.inList(linkPersoMedia.list, PersonneMedia::getCible, mediaToFollow.getNom()) );

                System.out.println("\n Organisation qui possède ce media " + mediaToFollow.getNom() + " :");
                Print.List( Search.inList(linkOrgaMedia.list, OrganisationMedia::getCible , mediaToFollow.getNom()) );
                System.out.println();
            }
            case 2 -> {
                var personToFollow = Prompt.numericChoice("Quelle personne suivre ?", personne.list);

                System.out.println("\nMédias possédé par " + personToFollow.getNom() + " :");
                Print.List(Search.inList(linkPersoMedia.list, PersonneMedia::getOrigine, personToFollow.getNom()));

                System.out.println("\nOrganisations possédé par " + personToFollow.getNom() + " :");
                Print.List(Search.inList(linkPersoOrga.list, PersonneOrganisation::getOrigine, personToFollow.getNom()));
                System.out.println();
            }
            case 3 -> {
                var orgToFollow = Prompt.numericChoice("Quelle organisation suivre ?", organisation.list);

                System.out.println("\nMédias possédé par " + orgToFollow.getNom() + " :");
                Print.List(Search.inList(linkOrgaMedia.list, OrganisationMedia::getOrigine, orgToFollow.getNom()));

                System.out.println("\nOrganisation possédé par " + orgToFollow.getNom() + " :");
                Print.List(Search.inList(linkOrgaOrga.list, OrganisationOrganisation::getOrigine, orgToFollow.getNom()));

                System.out.println("\nPersonnes qui possède " + orgToFollow.getNom() + " :");
                Print.List(Search.inList(linkPersoOrga.list, PersonneOrganisation::getCible, orgToFollow.getNom()));

                System.out.println("\nOrganisation qui possède " + orgToFollow.getNom() + " :");
                Print.List(Search.inList(linkOrgaOrga.list, OrganisationOrganisation::getCible, orgToFollow.getNom()));
                System.out.println();
            }
        }
        launch();
    }

    private void askWhatToPublish() throws IOException {
        var name = Prompt.textInput("Donner le nom de l'article");
        var selectedMedia = Prompt.multiNumericChoice("Selectionné les médias qui ont publier ", media.list);
        var selectedPersonne = Prompt.multiNumericChoice("Selectionné les personnes concerné par l'article ", personne.list);
        var article = new Article(name, selectedMedia, selectedPersonne);
        articles.add(article);

        var conflictOfInterests = article.conflictOfInterests();
        if (conflictOfInterests.isEmpty()) {
            System.out.println("Il n'y a pas de conflit d'interet");
        } else {
            System.out.println("Il y a des conflits d'interets :");
            Print.List( article.conflictOfInterests() );
        }

        launch();
    }

    private void askWhatToBuyback() throws IOException {
        System.out.println("Pas encore implementé");
        launch();
    }
}
