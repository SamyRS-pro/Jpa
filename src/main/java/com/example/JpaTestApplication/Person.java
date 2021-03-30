package com.example.JpaTestApplication;

public class Person {

    private String Nom;
    private String Prenom;
    private String Age;

    public Person() {
        super();
    }

    public Person(String Nom, String Prenom) {
        super();
        this.Nom = Nom;
        this.Prenom=Prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }
}
