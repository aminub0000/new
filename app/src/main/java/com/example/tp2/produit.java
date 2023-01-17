package com.example.tp2;

public class produit {
    //attributs
    public String produit;
    public float p_prix;

    //constructeur
    public produit(String p_intitule,
               float p_prix) {
        this.produit = p_intitule;
        this.p_prix = p_prix;
    }
    //getter produit
    public java.lang.String getproduit() {
        return produit;
    }
    //getter prix
    public float getP_prix() {
        return p_prix;
    }

    @Override
    public java.lang.String toString() {
        return "produit :" + produit + '\n' +
                "prix :" + p_prix ;
    }
    public String getproduit_prix()
    {
        return Float.toString(p_prix);
    }
}
