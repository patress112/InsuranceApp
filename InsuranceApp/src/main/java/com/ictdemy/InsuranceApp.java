package com.ictdemy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Táto trieda obsahuje základnú logiku aplikácie pre jej spustenie
 * V atribútoch má Scanner pre prijímanie vstupov a ArrayList insuredPeople,
 * ktorý obsahuje inštancie typu InsuredPerson.
 * Pridáme v atribútoch aj inštanciu triedy InsuranceAppOperation, aby sme mohli
 * volať metódy z tejto triedy
 */
public class InsuranceApp {

    /**
     * Atribúty
     */
    private ArrayList<InsuredPerson> insuredPeople;
    public InsuranceAppOperation operation;
    private Scanner scanner;

    /**
     * Konštruktor
     */
    public InsuranceApp() {
        this.insuredPeople = new ArrayList<>();
        this.scanner = new Scanner(System.in, "UTF-8");
        // Musíme inicializovať v konštruktore aj inštanciu operation, aby sme používali jej metódy
        // V parametroch inštancie operation musí byť scanner pre zadávanie vstupu a insuredPeople, s ktorým metódy pracujú
        this.operation = new InsuranceAppOperation(scanner, insuredPeople);
    }

    /**
     * Metóda pre vypísanie úvodného menu spolu s dostupnými voľbami
     * Táto metóda bude privátna pre použitie len v rámci tejto triedy
      */
    private void printMenu() {
        System.out.println("-------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("-------------------------------");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Pridať nového poistenca");
        System.out.println("2 - Vypísať všetkých poistencov");
        System.out.println("3 - Vyhľadať konkrétneho poistenca");
        System.out.println("4 - Koniec");
        System.out.print("Vaše voľba: ");
}

    /**
     * Metóda, ktorá spustí konkrétnu operáciu aplikácie podľa vstupu používateľa
     */
    public void run() {
        // Deklarujeme si premennú pre voľbu
        // Namiesto int použijeme String, ak by náhodou užívateľ zadal slovo alebo nejaký iný znak než číslo. Appka mu vyhodí chybové hlásenie
        String choice = "1";
        // Program bude bežať, kým užívateľ nezadá voľbu 4
        while (!choice.equals("4")) {
            // Zavoláme metódu printMenu() aby sa po každej operácií znovu vypísala úvodná obrazovka (ak užívateľ samozrejme program neukončil)
            printMenu();

            // Pomocou scanneru zistíme vstup od užívateľa
            choice =scanner.nextLine();
            // Použijeme switch pre jednotlivé operácie
            switch (choice) {
                case "1":
                    // Spustí sa metóda pre pridanie nového poistenca
                    operation.addInsuredPerson();
                    break;
                case "2":
                    // Spustí sa meóda pre výpis všetkých poistencov
                    operation.printAllInsuredPeople();
                    break;
                case "3":
                    // Spustí sa metóda pre vyhľadanie konkrétneho poistenca
                    operation.findInsuredPeople();
                    break;
                case "4":
                    // Program sa ukončí
                    System.out.println("Program bol ukončený.");
                    break;
                default:
                    System.out.println("Neplatná voľba, zadajte voľbu znova.");
                    break;
            }
        }
    }
}
