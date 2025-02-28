package com.example.project;
import java.util.ArrayList;


public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Card> allCards; //the current community cards + hand
    String[] suits  = Utility.getSuits();
    String[] ranks = Utility.getRanks();
    
    // DONE
    public Player(){
        hand = new ArrayList<>();
        allCards = new ArrayList<>();
    }

    public ArrayList<Card> getHand(){return hand;}
    public ArrayList<Card> getAllCards(){return allCards;}

    // DONE
    public void addCard(Card c){
        hand.add(c);
        allCards.add(c);
    }

    // returns best hand player has
    public String playHand(ArrayList<Card> communityCards){
        String handType = "";
        for (Card card : communityCards) {
            allCards.add(card);
        }
        sortAllCards();

        return handType;
    }

    // sorts hand from lowest to highest DONE
    public void sortAllCards(){
        for (int i = 1; i < allCards.size(); i++) {
            int idx = i;
            while (idx >= 1 && Utility.getRankValue(allCards.get(idx - 1).getRank()) > Utility.getRankValue(allCards.get(idx).getRank())) {
                if (Utility.getRankValue(allCards.get(idx - 1).getRank()) > Utility.getRankValue(allCards.get(idx).getRank())) {
                    allCards.set(idx, allCards.set(idx - 1, allCards.get(idx)));
                    idx--;
                }
            }
        }
    } 

    // use utility class to compare indexes DONE
    public ArrayList<Integer> findRankingFrequency(){
        ArrayList<Integer> freq = new ArrayList<>();
        for (int i = 0; i < ranks.length; i++) {
            int count = 0;
            for (Card card : allCards) {
                if (Utility.getRankValue(card.getRank()) == Utility.getRankValue(ranks[i])) {
                    count++;
                }
            }
            freq.add(count);
        } 
        return freq; 
    }

    // DONE
    public ArrayList<Integer> findSuitFrequency(){
        ArrayList<Integer> freq = new ArrayList<>();
        for (int i = 0; i < suits.length; i++) {
            int count = 0;
            for (Card card : allCards) {
                if (card.getSuit().equals(suits[i])) {
                    count++;
                }
            }
            freq.add(count);
        } 
        return freq; 
    }
   
    public boolean allSameSuit() {
        ArrayList<Integer> freqOfSuits = findRankingFrequency();
        for (int num : freqOfSuits) {
            if (num == 5) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString(){
        return hand.toString();
    }
}
