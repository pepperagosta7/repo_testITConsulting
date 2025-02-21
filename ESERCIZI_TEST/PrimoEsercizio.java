package ESERCIZI_TEST;

import java.util.Scanner;

public class PrimoEsercizio {
    
    public static void main(String[] args){

        Scanner num = new Scanner(System.in); // Scanner per leggere l'input dell'utente

        System.out.println("Inizio dell'intervallo: ");
        int primo = num.nextInt(); // Legge l'inizio dell'intervallo

        System.out.println("Fine dell'intervallo: ");
        int ultimo = num.nextInt(); // Legge la fine dell'intervallo
        int somma = 0; // Variabile per memorizzare la somma dei numeri pari

        // Controlla se l'intervallo è valido
        if (ultimo > primo) {
            // Ciclo per trovare i numeri pari nell'intervallo
            for (int i = primo; i < ultimo; i++) {
                if (i % 2 == 0) {
                    System.out.println(i); // Stampa il numero pari
                    somma += i; // Aggiunge il numero pari alla somma
                }
            }
            System.out.println(somma); // Stampa la somma dei numeri pari
        } else {
            System.out.println("Error."); // Stampa un messaggio di errore se l'intervallo non è valido
        }
       
        num.close(); // Chiude lo scanner
    }
}
