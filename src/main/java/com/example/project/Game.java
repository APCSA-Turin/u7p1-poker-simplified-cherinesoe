package com.example.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    public static String determineWinner(Player p1, Player p2, String p1Hand, String p2Hand, ArrayList<Card> communityCards){
        int p1Rank = Utility.getHandRanking(p1Hand);
        int p2Rank = Utility.getHandRanking(p2Hand);

        if (p1Rank > p2Rank) {
            return "Player 1 wins!";
        } else if (p1Rank < p2Rank) {
            return "Player 2 wins!";
        } else {
            if (p1Rank == p2Rank) {
                if (p1Rank == 7 || p1Rank == 3 || p1Rank == 2) {
                    int p1TopCard = Utility.getTop(p1);
                    int p2TopCard = Utility.getTop(p2);
                    if (p1TopCard < p2TopCard) {
                        return "Player 2 wins!";
                    } else if (p1TopCard > p2TopCard) {
                        return "Player 1 wins!";
                    } else {
                        return "Tie!";
                    }
                } else {
                    int p1Total = Utility.getTotalValue(p1);
                    int p2Total = Utility.getTotalValue(p2);
                    if (p1Total < p2Total) {
                        return "Player 2 wins!";
                    } else if (p1Total > p2Total) {
                        return "Player 1 wins!";
                    } else {
                        return "Tie!";
                    }
                }
            }
        }
        return "Tie";
    }

    // ui
    public static void play(){ //simulate card playing
        Scanner scan = new Scanner(System.in);
        boolean playing = false;
        System.out.print("Would you like to play simplified poker? (y/n): ");
        String answer = scan.nextLine();
        if (answer.equals("y")) {
            playing = true;
        } else {
            playing = false;
        }
        while (playing) {
            Deck deck = new Deck();
            deck.initializeDeck();
            System.out.println("Select one of the following: ");
            System.out.println("1: Shuffle Deck");
            System.out.println("2: Draw Cards");
            System.out.println("3: Stop Playing");
            int option = scan.nextInt();
            scan.nextLine();
            if (option == 1) {
                deck.shuffleDeck();
            } else if (option == 2) {
                Player p1 = new Player();
                Player p2 = new Player();

                p1.addCard(deck.drawCard());
                p1.addCard(deck.drawCard());
          
                p2.addCard(deck.drawCard());
                p2.addCard(deck.drawCard());

                ArrayList<Card> communityCards = new ArrayList<>();
                communityCards.add(deck.drawCard());
                communityCards.add(deck.drawCard());
                communityCards.add(deck.drawCard());

                String p1Result = p1.playHand(communityCards);
                String p2Result = p2.playHand(communityCards);

                // prints players and community cards along with winner of game
                System.out.println("Player 1's Hand: " + p1.getHand() + " " + p1.playHand(communityCards));
                System.out.println("Player 2's Hand: " + p2.getHand() + " " + p2.playHand(communityCards));
                System.out.println("Community Cards: " + communityCards);
                String winner = Game.determineWinner(p1, p2, p1Result, p2Result, communityCards);
                System.out.println(winner);
            } else {
                playing = false;
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
    }
        
        

}