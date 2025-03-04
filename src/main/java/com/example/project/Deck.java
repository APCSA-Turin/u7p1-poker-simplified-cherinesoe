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

    // adds one of every rank and suit to cards
    public void initializeDeck(){ 
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                cards.add(new Card(ranks[j], suits[i]));
            }
        }
    }
    
    // randomly rearranges deck of cards
    public void shuffleDeck(){ //You can use the Collections library or another method. You do not have to create your own shuffle algorithm
        Collections.shuffle(cards);
    }

    // generates random card from deck and then removes it
    public Card drawCard(){
        int randCard = (int) (Math.random() * cards.size());
        Card card = cards.get(randCard);
        cards.remove(randCard);
        return card;
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

   


}