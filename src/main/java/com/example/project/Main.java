package com.example.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        
        player1.addCard(new Card("7", "♠"));
        player1.addCard(new Card("10", "♠"));
  
        player2.addCard(new Card("A", "♠"));
        player2.addCard(new Card("3", "♠"));

        
        // Community cards that could help form the flush
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("J", "♠")); // Player 1 completes the flush with this card
        communityCards.add(new Card("J", "♥"));
        communityCards.add(new Card("Q", "♠"));
        
        // Player results after playing the hand
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);

        // Determine the winner
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        System.out.println(winner);
    }
}