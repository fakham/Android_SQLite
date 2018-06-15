package com.mohammedfakham.tdi_sqlite;

public class User {

    private long m_id;
    private String m_nom;
    private String m_prenom;
    private int m_age;

    public User() {
    }

    public User(long id, String nom, String prenom, int age) {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setAge(age);
    }

    public long getId() {
        return m_id;
    }

    public void setId(long id) {
        this.m_id = id;
    }

    public String getNom() {
        return m_nom;
    }

    public void setNom(String nom) {
        this.m_nom = nom;
    }

    public String getPrenom() {
        return m_prenom;
    }

    public void setPrenom(String prenom) {
        this.m_prenom = prenom;
    }

    public int getAge() {
        return m_age;
    }

    public void setAge(int age) {
        this.m_age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "m_id=" + m_id +
                ", m_nom='" + m_nom + '\'' +
                ", m_prenom='" + m_prenom + '\'' +
                ", m_age=" + m_age +
                '}';
    }
}
