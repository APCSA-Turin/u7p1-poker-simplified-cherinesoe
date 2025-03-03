package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

// EXTRA CREDIT
public class Deck{
    private ArrayList<Card> cards;
    String[] suits  = Utility.getSuits();
    String[] ranks = Utility.getRanks();

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public void initializeDeck(){ //hint.. use the utility class
        
    }

    public void shuffleDeck(){ //You can use the Collections library or another method. You do not have to create your own shuffle algorithm
        
    }

    public Card drawCard(){
       return new Card("","");
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

   


}