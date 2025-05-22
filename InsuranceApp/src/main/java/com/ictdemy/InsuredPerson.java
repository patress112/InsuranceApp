package com.ictdemy;

/**
 * Táto trieda predstavuje poistenca a ukladá údaje o ňom
 * Má atribúty meno, priezvisko, vek a telefónne číslo (vo formáte String)
 */
public class InsuredPerson {

    /**
     * Atribúty
     */
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    /**
     * Konštruktor
     * @param firstName - meno
     * @param lastName - priezvisko
     * @param age - vek
     * @param phoneNumber - telefónne číslo (typ String)
     */
    public InsuredPerson(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gettery a settery
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Pridaný getter pre výpis mena a priezviska
     * @return - vráti meno a priezvisko v jednom reťazci
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Metódy

    /**
     * Metóda na textový výpis údajov
     * @return - vráti výpis údajov o poistencovi do konzoly
     */
    @Override
    public String toString() {
        // Vo výpise použijeme odtabovanie
        return firstName + " " + lastName + " " + "\t" + age + "\t" + phoneNumber;
    }

}
