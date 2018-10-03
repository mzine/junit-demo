package assignement1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

	public static ArrayList<Card> cardsList;
	
	public final static String TEN   = "10";
    public final static String JACK  = "J";
    public final static String QUEEN = "Q";
    public final static String KING  = "K";
    public final static String ACE   = "A";
	
    public Hand(String path) {
        ReadFile file = new ReadFile(path);
        String fileContent = file.getData();
        String[] CardsNames = fileContent.split(" ");
        ArrayList<Card> cards = new ArrayList<Card>();
        
        for(int i = 0; i < CardsNames.length; i++) {
        	
            String suit = CardsNames[i].substring(0, 1);
            String rank = CardsNames[i].substring(1);
            
            Card cd = new Card(rank, suit);
            cards.add(cd);
        }
        boolean valid = (cardsList.size() == 5);
    	if(valid)
    		this.cardsList = cardsList;
        
    }
    
    public Hand(ArrayList<Card> cardsList) {
    	boolean valid = (cardsList.size() == 5);
    	if(valid)
    		this.cardsList = cardsList;
    }
    
    
    public boolean isRoyalFlush() {
        
		for(int i= 0; i< cardsList.size(); i++) {
			if(cardsList.get(i).equals(TEN) || cardsList.get(i).equals(JACK) || cardsList.get(i).equals(QUEEN)
					||cardsList.get(i).equals(KING) || cardsList.get(i).equals(ACE))
				return true;
		}
		
		return false;
        
    }
    
    public static void main(String[] args) {
    	
    	
    	Hand hd = new Hand("src/main/resources/assignement1/test.txt");
        
        
        for(int i = 0; i<cardsList.size();i++) {
        	System.out.println(cardsList.get(i).cardToString());
        }
    }
    
    
}