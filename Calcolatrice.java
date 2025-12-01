public class Calcolatrice {

    public static String Calcolatrice(double num1, double num2, String operatore) {

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
        System.out.println(Calcolatrice(10, 5, "+"));
        System.out.println(Calcolatrice(3, 5, "-"));
        System.out.println(Calcolatrice(5, 6, "*"));
        System.out.println(Calcolatrice(20, 30, "/"));
        System.out.println(Calcolatrice(36, 0, "/"));
    }
}