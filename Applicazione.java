import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Applicazione {

    // Lista che contiene tutti gli articoli della spesa.
    // Ogni articolo è una mappa con proprietà (nome, prezzo, quantità...)
    private List<Map<String, Object>> articoli;
    
    // Oggetto Scanner per leggere input da tastiera
    private Scanner scanner;

    public Applicazione() {
        articoli = new ArrayList<>();  // Inizializza lista articoli
        scanner = new Scanner(System.in); // Inizializza scanner
    }

    public static void main(String[] args) {

        // Crea l’applicazione e avvia il programma
        Applicazione app = new Applicazione();
        app.esegui();
    }

    // LOOP MENU, Metodo principale che gestisce il menu in un ciclo infinito
    private void esegui() {
        while (true) {  // Continua finché l'utente non sceglie "Esci"
            mostraMenu();

            try {
        
                int scelta = scanner.nextInt();
                switch (scelta) {
                    case 1 -> aggiungiArticolo();
                    case 2 -> visualizzaLista();
                    case 3 -> rimuoviArticolo();
                    case 4 -> cercaArticolo();
                    case 5 -> marcaAcquistato();
                    case 6 -> calcolaTotale();
                    case 7 -> salvasuFile();
                    case 8 -> caricaDaFile();
                    case 9 -> {
                        System.out.println("\n✓ Arrivederci!");
                        return;
                    }
                    default -> System.out.println("❌ Scelta non valida!");
                }

            } catch (NumberFormatException e) {
                // L'utente ha scritto qualcosa che non è un numero 
                System.out.println("❌ Inserisci un numero valido!");
            }
        }
    }
    // Permette di aggiungere un nuovo articolo alla lista
    private void mostraMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║    GESTIONE LISTA DELLA SPESA        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Aggiungi articolo                 ║");
        System.out.println("║ 2. Visualizza lista                  ║");
        System.out.println("║ 3. Rimuovi articolo                  ║");
        System.out.println("║ 4. Cerca articolo                    ║");
        System.out.println("║ 5. Marca come acquistato             ║");
        System.out.println("║ 6. Calcola totale spesa              ║");
        System.out.println("║ 7. Salva su file                     ║");
        System.out.println("║ 8. Carica da file                    ║");
        System.out.println("║ 9. Esci                              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Scegli (1-9): ");
    }

    private void aggiungiArticolo() {
        System.out.print("Inserisci nome articolo: ");
        String nome = scanner.next();

        System.out.print("Inserisci categoria: ");
        String categoria = scanner.next();

        System.out.print("Inserisci prezzo unitario: ");
        double prezzo = Double.parseDouble(scanner.next());
        System.out.printf("€%.2f\n", prezzo);


        System.out.print("Inserisci quantità: ");
        int quantita = Integer.parseInt(scanner.next());

        Map<String, Object> articolo = new HashMap<>();
        articolo.put("nome", nome);
        articolo.put("categoria", categoria);
        articolo.put("prezzo", prezzo);
        articolo.put("quantita", quantita);
        articolo.put("acquistato", false);

        articoli.add(articolo);

        System.out.println("✓ Articolo aggiunto!");
    }

    private void visualizzaLista() {
        if (articoli.isEmpty()) {
            System.out.println("Lista vuota!");
            return;
        }

        System.out.println("\nLISTA DELLA SPESA:");

        int i = 1;
        for (Map<String, Object> a : articoli) {
            boolean acq = (boolean) a.get("acquistato");
            String box = acq ? "[✓]" : "[ ]";

            System.out.printf("%s %d. %s - %s €%.2f x %d\n",
                box, i, a.get("nome"), a.get("categoria"),
                a.get("prezzo"), a.get("quantita"));
            i++;
        }
    }

    // --- METODI NON ANCORA IMPLEMENTATI ---
    private void rimuoviArticolo() { System.out.println("(Non ancora implementato)"); }
    private void cercaArticolo() { System.out.println("(Non ancora implementato)"); }
    private void marcaAcquistato() { System.out.println("(Non ancora implementato)"); }
    private void calcolaTotale() { System.out.println("(Non ancora implementato)"); }
    private void salvasuFile() { System.out.println("(Non ancora implementato)"); }
    private void caricaDaFile() { System.out.println("(Non ancora implementato)"); }

}     
