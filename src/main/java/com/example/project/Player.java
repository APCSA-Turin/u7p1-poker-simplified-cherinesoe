package com.example.project;
import java.util.ArrayList;


public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Card> allCards; //the current community cards + hand
    private boolean handCreated = false;
    private boolean highInComm = false;
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
        if (!handCreated) {
            for (Card card : communityCards) {
                allCards.add(card);
            }
            sortAllCards();
            handCreated = true;
            for (Card card : communityCards) {
                if (allCards.get(4).equals(card)) {
                    highInComm = true;
                }
            }
            
        }
        System.out.println(allCards);
        if (allSameSuit()) {
            if (sequential()) {
                if (allCards.get(0).getRank().equals("10")) {
                    handType = "Royal Flush";
                } else {
                    handType = "Straight Flush";
                }
            } else {
                handType = "Flush";
            }
        } else if (sequential()) {
            handType = "Straight";
        } else if (quad()) {
            handType = "Four of a Kind";
        } else if (triple()) {
            handType = "Three of a Kind";
            if (pair()) {
                handType = "Full House";
            }
        } else if (twoPair()) {
            handType = "Two Pair";
        } else if (pair()) {
            handType = "A Pair";
        } else if (!highInComm){
            handType = "High Card";
        } else {
            handType = "Nothing";
        }

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
        ArrayList<Integer> freqOfSuits = findSuitFrequency();
        for (int num : freqOfSuits) {
            if (num == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean sequential() {
        ArrayList<Integer> freqOfCard = findRankingFrequency();
        boolean seq = false;
        for (int i = 0; i < freqOfCard.size() - 4; i++) {
            int count = 0;
            for (int j = i; j < i + 4; j++) {
                if (freqOfCard.get(j + 1) == 1 && freqOfCard.get(j) == 1) {
                    count++;
                    seq = true;
                }
                if (count == 4) {
                    return true;
                } else {
                    seq = false;
                }
            }
        }
        return seq;
    }

    public boolean quad() {
        ArrayList<Integer> freqOfCard = findRankingFrequency();
        for (int num : freqOfCard) {
            if (num == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean triple() {
        ArrayList<Integer> freqOfCard = findRankingFrequency();
        for (int num : freqOfCard) {
            if (num == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean pair() {
        ArrayList<Integer> freqOfCard = findRankingFrequency();
        for (int num : freqOfCard) {
            if (num == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean twoPair() {
        ArrayList<Integer> freqOfCard = findRankingFrequency();
        int count = 0;
        for (int num : freqOfCard) {
            if (num == 2) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return hand.toString();
    }
}
