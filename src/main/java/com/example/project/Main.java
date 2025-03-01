package com.example.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.addCard(new Card("3", "♠"));
        player.addCard(new Card("6", "♦"));
        
        // Community Cards
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("5", "♣"));
        communityCards.add(new Card("2", "♠"));
        communityCards.add(new Card("A", "♠"));

        System.out.println(player.playHand(communityCards));
    }
}