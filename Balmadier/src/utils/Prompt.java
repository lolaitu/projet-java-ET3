package utils;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Prompt {
    private static final Scanner scanner = new Scanner(System.in);

    // For numeric choices from a list
    public static <T> T numericChoice(String message, List<T> options) {
        System.out.println(message);
        Print.List(options, true);

        while (true) {
            System.out.print("Your choice (1-" + options.size() + "): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= options.size()) {
                    return options.get(choice - 1);
                }
            } catch (NumberFormatException e) {
                // Ignore and retry
            }
            System.out.println("❌ Invalid choice, try again.");
        }
    }

    public static <T> List<T> multiNumericChoice(String message, List<T> options) {
        List<T> selections = new ArrayList<>();
        System.out.println(message);
        Print.List(options, true); // Affiche les options avec numérotation
        System.out.println("Entrez les choix un par un (1-" + options.size() + ")");
        System.out.println("Entrez '0' ou 'fin' pour terminer la sélection");

        while (true) {
            System.out.print("Ajouter choix [" + selections.size() + " sélectionné(s)]: ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Conditions de sortie
            if (input.equals("0") || input.equals("fin")) {
                return selections;
            }

            // Traitement du choix
            try {
                int choix = Integer.parseInt(input);
                if (choix >= 1 && choix <= options.size()) {
                    T selection = options.get(choix - 1);
                    if (!selections.contains(selection)) {
                        selections.add(selection);
                        System.out.println("✓ Ajouté : " + selection);
                    } else {
                        System.out.println("⚠️ Déjà sélectionné");
                    }
                } else {
                    System.out.println("❌ Choix invalide, doit être entre 1-" + options.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Veuillez entrer un nombre valide");
            }
        }
    }

    // For text input
    public static String textInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    // For yes/no confirmation
    public static boolean confirm(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("❌ Please answer 'y' or 'n'.");
        }
    }

    // For number input (with optional max value)
    public static int numberInput(String prompt, Integer maxValue) {
        while (true) {
            System.out.print(prompt + ": ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (maxValue == null || number <= maxValue) {
                    return number;
                }
                System.out.println("❌ Number must be ≤ " + maxValue);
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }

    // Overload without max value
    public static int numberInput(String prompt) {
        return numberInput(prompt, null);
    }
}

/** Exemple d'utilisation
 * List<Media> medias = mediaReader.list;
 * Media choix = PromptUtils.numericChoice("Choisissez un média:", medias);
 * System.out.println("Vous avez choisi: " + choix.getNom());
 *
 * boolean confirmer = PromptUtils.confirm("Voulez-vous continuer");
 * if (confirmer) {
 *     // Action si confirmé
 * }
 *
 * String recherche = PromptUtils.textInput("Entrez votre recherche");
 *
 * int age = PromptUtils.numberInput("Quel est votre âge");
 */
