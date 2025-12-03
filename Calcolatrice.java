public class Calcolatrice {

    public static String Calcola(double num1, double num2, String operatore) {

        if (operatore.equals("+")) {
            return String.valueOf(num1 + num2);

        } else if (operatore.equals("-")) {
            return String.valueOf(num1 - num2);

        } else if (operatore.equals("*")) {
            return String.valueOf(num1 * num2);

        } else if (operatore.equals("/")) {
            if (num2 == 0) {
                return "Errore: divisione per zero";
            }
            return String.valueOf(num1 / num2);

        } else {
            return "Errore: operatore non riconosciuto";
        }
    }

    public static void main(String[] args) {
        System.out.println(Calcola(10, 5, "+"));
        System.out.println(Calcola(3, 5, "-"));
        System.out.println(Calcola(5, 6, "*"));
        System.out.println(Calcola(20, 30, "/"));
        System.out.println(Calcola(36, 0, "/"));
    }
} 