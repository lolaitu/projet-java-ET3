package utils;

import java.util.List;

public class Print {
    public static <T> void List(List<T> list, boolean numbered) {  // Paramètre renommé et type générique ajouté
        if (list == null || list.isEmpty()) {  // Gestion des cas null/vide
            System.out.println("Il n'y a pas de contenu");
            return;
        }

        if (!numbered) {
            for (T item : list) {
                System.out.println(item);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, list.get(i));  // Utilisation de la liste passée en paramètre
            }
        }
    }

    // Surcharge pour l'affichage non numéroté par défaut
    public static <T> void List(List<T> list) {
        List(list, false);
    }
}
