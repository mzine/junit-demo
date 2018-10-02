package assignement1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
	
	private final String ranks;
    private final String suits;
    
    public String getRank() {
		return ranks;
	}

	public String getSuit() {
		return suits;
	}

	public Card(String rank, String suit) {
    	this.ranks = validRanks(rank);
    	this.suits = validSuits(suit);
    }

	public String validSuits(String suit) {
		List<String> suitsCards = new ArrayList<String>();
		suitsCards = Arrays.asList("C", "D", "H", "S");
		if(suitsCards.contains(suit))
			return suit;
		return "0";
	}
	
	public String validRanks(String rank) {
		List<String> ranksCards = new ArrayList<String>();
		ranksCards = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
		if(ranksCards.contains(rank))
			return rank;
		return "0";
	}

	public String cardToString() {
        return this.ranks + " " + this.suits;
    }
}
