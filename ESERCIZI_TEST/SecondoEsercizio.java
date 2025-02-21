package ESERCIZI_TEST;

import java.util.Scanner;

public class SecondoEsercizio {
    
    static String nome; // Nome dell'utente
    static String password; // Password dell'utente
    static String risposta; // Risposta alla domanda segreta
    static String segreta; // Domanda segreta
    static boolean isRegistered = false; // Indica se l'utente è registrato
    static boolean isLoggedIn = false; // Indica se l'utente è loggato

    public static void main(String[] args){

        Scanner str = new Scanner(System.in); // Scanner per leggere le stringhe
        Scanner num = new Scanner(System.in); // Scanner per leggere i numeri
        boolean running = true; // Variabile per controllare il ciclo del menu
        while (running) {
            // Menu per selezionare l'operazione desiderata
            System.out.println("\nMenu Operazioni:");
            System.out.println("1. registrazione");
            System.out.println("2. login solo se sei registrato");
            System.out.println("3. modifica dati solo se hai fatto il login");
            System.out.println("4. Esci");
            System.out.println("Scelta: ");
                
            int scelta = num.nextInt(); // Legge la scelta dell'utente

            switch (scelta){
                case 1:
                    registrazione(str); // Chiama il metodo di registrazione
                    break;
                case 2:
                    if (isRegistered) {
                        isLoggedIn = login(str); // Chiama il metodo di login se l'utente è registrato
                    } else {
                        System.out.println("Devi registrarti prima di poter fare il login.");
                    }
                    break;
                case 3:
                    if (isLoggedIn) {
                        modificaDati(str); // Chiama il metodo di modifica dati se l'utente è loggato
                    } else {
                        System.out.println("Devi fare il login prima di poter modificare i dati.");
                    }
                    break;
                case 4:
                    System.out.println("sei fuori dal programma");
                    running = false; // Esce dal programma
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }

        str.close(); // Chiude lo scanner per le stringhe
        num.close(); // Chiude lo scanner per i numeri
    }

    public static boolean registrazione(Scanner str){
        // Chiede all'utente il nome
        System.out.println("Come ti chiami?");
        nome = str.nextLine();

        // Chiede all'utente la password
        System.out.println("Qual è la tua password?");
        password = str.nextLine();

        // Chiede all'utente di scegliere una domanda segreta
        System.out.println("Scegli una domanda segreta.");
        segreta = str.nextLine();
        if (!segreta.isEmpty()){
            // Chiede all'utente di fornire una risposta alla domanda segreta
            System.out.println("Dai una risposta");
            risposta = str.nextLine();
        }

        isRegistered = true; // Imposta l'utente come registrato
        return true;
    }

    public static boolean login(Scanner str){
        // Chiede all'utente di inserire il nome
        System.out.println("Inserisci il nome:");
        String nomeLog = str.nextLine();

        // Chiede all'utente di inserire la password
        System.out.println("Inserisci password: ");
        String passLog = str.nextLine();

        // Verifica le credenziali
        if (nomeLog.equals(nome) && passLog.equals(password)){
            System.out.println("Ti sei loggato correttamente");
            return true;
        } else {
            System.out.println("Non sono presenti le credenziali, Registrati prima!");
            return false;
        }
    }

    public static void modificaDati(Scanner str){
        // Chiede all'utente di inserire la risposta alla domanda segreta
        System.out.println("Inserisci la risposta alla domanda segreta se vuoi modificare i dati: ");
        String newRisposta = str.nextLine();

        // Verifica la risposta alla domanda segreta
        if (newRisposta.equals(risposta)){
            // Chiede all'utente di inserire i nuovi dati
            System.out.println("Inserisci il nuovo nome:");
            nome = str.nextLine();
            System.out.println("Inserisci la nuova password:");
            password = str.nextLine();
            System.out.println("Inserisci la nuova domanda segreta:");
            segreta = str.nextLine();
            System.out.println("Inserisci la nuova risposta alla domanda segreta:");
            risposta = str.nextLine();

            System.out.println("I tuoi dati sono stati aggiornati correttamente.");
        } else {
            System.out.println("Risposta alla domanda segreta errata.");
        }
    }
}
