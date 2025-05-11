package struct.entity;

public class Organisation {
    String Nom;
    String commentaire;

    public Organisation(String nom, String com){
        Nom =nom;
        commentaire = com;
    }

    public String getNom() {
        return Nom;
    }

    public String getCommentaire() {
        return commentaire;
    }

    @Override
    public String toString() {
        return Nom + (commentaire != null && !commentaire.isEmpty()
                ? " (" + commentaire + ")" : "");
    }
}
