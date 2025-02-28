package com.example.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.addCard(new Card("3", "♠"));
        player.addCard(new Card("5", "♣"));
        
        // Add community cards (3 cards in total for this example)
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("4", "♠"));
        communityCards.add(new Card("8", "♣"));
        communityCards.add(new Card("A", "♦"));

        player.playHand(communityCards);
        System.out.println(player.getAllCards());
        player.sortAllCards();
        System.out.println(player.findSuitFrequency());
    }
}