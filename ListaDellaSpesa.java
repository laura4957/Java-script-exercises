import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListaDellaSpesa {

    private List<Map<String, Object>> articoli;
    private Scanner scanner;

    public ListaDellaSpesa() {
        articoli = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ListaDellaSpesa app = new ListaDellaSpesa();
        app.esegui();  // avvia il programma con menu
    }

    // Loop menu
    private void esegui() {
        while (true) {
            mostraMenu();
            int scelta = Integer.parseInt(scanner.nextLine());
            switch (scelta) {
                case 1 -> aggiungiArticolo();
                case 2 -> visualizzaLista();
                case 9 -> {
                    System.out.println("Arrivederci!");
                    return;
                }
                default -> System.out.println("Scelta non valida!");
            }
        }
    }

    private void mostraMenu() {
        System.out.println("\nMENU PRINCIPALE");
        System.out.println("1. Aggiungi articolo");
        System.out.println("2. Visualizza lista");
        System.out.println("9. Esci");
        System.out.print("Scelta: ");
    }

    private void aggiungiArticolo() {
        System.out.print("Inserisci nome articolo: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Inserisci prezzo unitario: ");
        double prezzo = Double.parseDouble(scanner.nextLine());

        System.out.print("Inserisci quantità: ");
        int quantita = Integer.parseInt(scanner.nextLine());

        Map<String, Object> articolo = new HashMap<>();
        articolo.put("nome", nome);
        articolo.put("categoria", categoria);
        articolo.put("prezzo", prezzo);
        articolo.put("quantita", quantita);
        articolo.put("acquistato", false);

        articoli.add(articolo);

        System.out.println("Articolo aggiunto!");
    }

    private void visualizzaLista() {
        if (articoli.isEmpty()) {
            System.out.println("Lista vuota!");
            return;
        }
        System.out.println("\nLISTA DELLA SPESA:");
        int i = 1;
        for (Map<String, Object> a : articoli) {
            System.out.printf("%d. %s - %s €%.2f x %d\n", i,
                a.get("nome"), a.get("categoria"),
                a.get("prezzo"), a.get("quantita"));
            i++;
        }
    }
}