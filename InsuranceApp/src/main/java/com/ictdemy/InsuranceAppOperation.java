package com.ictdemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * V tejto triede sú operácie pre prácu s dátami a vstupmi od užívateľa
 */
public class InsuranceAppOperation {

    /**
     * Atribúty
     */
    private Scanner scanner;
    private List<InsuredPerson> insuredPeople;

    /**
     * Konštruktor
     * Keďže v metódach addInsuredPerson a listAllInsuredPeople pristupujeme k premenným
     * scanner a insuredPeople, musíme ich inicializovať v konštruktore
     */
    public InsuranceAppOperation(Scanner scanner, ArrayList<InsuredPerson> insuredPeople) {
        this.scanner = scanner;
        this.insuredPeople = insuredPeople;
    }

    /**
     * Metóda pre pridanie poistenca
     */
    public void addInsuredPerson() {
        // Zistíme atribúty pre vytvorenie pojistenca. Použijeme trim() metódu, aby sme osekali prípadné medzery, ktoré môže užívateľ pred a za slovom zadať, inak by sme mohli mať problémy s výpisom aj vyhľadávaním
        // Pre validáciu vstupov použijeme cyklus do - while (ten sa vždy vykoná aspoň raz)
        String firstName;
        do {
            // Užívateľ zadá meno
            System.out.println("Zadajte meno poistenca: ");
            // Meno orežeme o prípadné medzery
            firstName = scanner.nextLine().trim();
            // Ak je splnená podmienka (meno je prázdne), vypíšeme hlášku. Ak nie, tak program pokračuje k zadaniu priezviska
            if (firstName.isEmpty()) {
                System.out.println("Nezadali ste meno poistenca, zadajte ho znova, prosím...");
            }
        } while (firstName.isEmpty());

        String lastName;
        do {
            // Užívateľ zadá priezvisko
            System.out.println("Zadajte priezvisko: ");
            // Priezvisko orežeme tiež o prípadné medzery
            lastName = scanner.nextLine().trim();
            // Ak je splnená podmienka (priezvisko je prázdne), vypíšeme hlášku. Ak nie, tak program pokračuje k zadaniu veku
            if (lastName.isEmpty()) {
                System.out.println("Nezadali ste priezvisko poistenca, zadajte ho znova, prosím:");
            }
        } while (lastName.isEmpty());

        // Užívateľ zadá vek
        int age;
        do {
            System.out.println("Zadajte věk: ");
            age = Integer.parseInt(scanner.nextLine());
            if (age < 0 || age >= 130) {
                System.out.println("Neplatný vek, zadajte ho prosím znova:");
            }
        } while (age < 0 || age >= 130);

        // Užívateľ zadá telefónne číslo
        String phoneNumber;
        do {
            System.out.println("Zadajte telefonní číslo: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) {
                System.out.println("Nezadali ste platné telefónne číslo, zadajte ho prosím znova:");
            }
        } while (phoneNumber.isEmpty());

        // Keď sme získali všetky dáta, cez konštruktor vytvoríme poistenca pomocou získaných parametrov a pridáme ho do ArrayListu
        insuredPeople.add(new InsuredPerson(firstName, lastName, age, phoneNumber));
        System.out.println("Poistenec " + firstName + " " + lastName + " bol pridaný do databázy, pokračujte ľubovoľnou klávesou...");
    }

    /**
     * Metóda pre výpis všetkých poistencov
     */
    public void printAllInsuredPeople() {
        // Zistíme, či je v ArrayListe aspoň jeden poistenec, ak nie, vypíšeme hlášku
        if (insuredPeople.isEmpty()) {
            System.out.println("V zozname nie je žiadny poistenec.");
        }
        // Ak ArrayList nie je prázdny, pokračujeme vo výpise
        else {
            System.out.println("Zoznam všetkých poistencov: ");

            // Aby výpis vyzeral krajšie, nastavíme šírku stĺpca s menom a priezviskom na dĺžku najdlhšieho reťazca v ArrayListe insuredPeople
            // Inicializujeme si premennú pre maximálnu dĺžku

            int maxNameLength = 0;
            for (InsuredPerson person : insuredPeople) {
                // Nastavíme maximálnu dĺžku mena na dĺžku najdlhšieho mena v ArrayListe insuredPeople
                // Math.max vráti väčšiu z dvoch hodnôt. Ak je dĺžka aktuálneho mena väčšia ako súčasná hodnota maxNameLength, tak sa hodnota v maxNameLength aktualizuje. Prejdením celého ArrayListu tak bude v tejto premennej uchovaná dĺžka najdlhšieho mena
                maxNameLength = Math.max(maxNameLength, person.getFullName().length());
            }

            System.out.println("Zoznam všetkých poistencov: ");
            // Vypíšeme poistencov (aj s krajším zarovnaním)
            for (InsuredPerson person : insuredPeople) {
                // Získame meno poistenca
                String name = person.getFullName();

                // Pridáme medzery tak, aby všetky mená mali rovnakú dĺžku + 2 medzery navyše
                while (name.length() < maxNameLength + 2) {
                    name = name + " ";
                }

                // Výpis so správnym zarovnaním
                System.out.println(name + "\t" + person.getAge() + "\t" + person.getPhoneNumber());
            }
        }
    }

    /**
     * Metóda pre nájdenie konkŕetneho poistenca
     */
    public void findInsuredPeople () {
        // Skontrolujeme, či je ArrayList prázdny, ak áno, vypíšeme hlášku a netódu ukončíme
        if (insuredPeople.isEmpty()) {
            System.out.println("V databáze není ješte žádný pojištenec...");
            // Ukončíme metódu pomocou return. Break sa používa len pri cykloch for, while, do-while alebo vo vnútri switchu (v tomto som robil chybu). Keďže if nie je cyklus, ale podmienka, použijeme return
            return;
        }
        // Zistíme meno a priezvisko hľadaného poistenca
        System.out.println("Zadejte jméno pojišteného: ");
        // Ošetríme si orezanie medzier aj pri mene, aj pri priezvisku, ktoré môže užívateľ zadať, aby sme nemali problémy s prípadným vyhľadávaním.
        String firstName = scanner.nextLine().trim();
        System.out.println("Zadejte příjmení: ");
        String lastName = scanner.nextLine().trim();
        // Vytvoríme si premennú boolean s hodnotou false, budeme ju využívať pri hľadaní
        boolean found = false;
        // Použijeme cyklus foreach pre iteráciu ArrayListom insuredPeople
        for (InsuredPerson person : insuredPeople) {
            // Ak getter getFullName nájde (bez ohľadu na veľkosť písmen) užívateľa s hľadaným menom a priezviskom, vypíše ho na nový riadok a premenná found nadobudne hodnotu true a metóda sa ukončí
            if (person.getFullName().equalsIgnoreCase(firstName + " " + lastName)) {
                System.out.println(person);
                found = true;
                break;
            }
        }
        // Ak sa found nerovná true, vypíšeme, že poistenec nebol nájdený
        if (!found) {
            System.out.println("Pojištenec nebyl nalezen");
        }
    }
}


