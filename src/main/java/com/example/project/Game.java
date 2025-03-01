package com.example.project;
import java.util.ArrayList;


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
                if (p1Rank == 7) {
                    int p1TopCard = Utility.getTop(p1);
                    int p2TopCard = Utility.getTop(p2);
                    if (p1TopCard < p2TopCard) {
                        return "Player 2 wins!";
                    } else if (p1TopCard > p2TopCard) {
                        return "Player 1 wins!";
                    } else {
                        return "Tie!";
                    }
                }
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
        return "Tie";
    }

    public static void play(){ //simulate card playing
    
    }
        
        

}