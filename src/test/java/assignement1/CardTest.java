package assignement1;

import junit.framework.TestCase;


public class CardTest extends TestCase {

	
    public void testvalidSuits() {
        assertEquals("0", new Card("E", "Z").validSuits("Z"));
	}
	
    public void testvalidSuits1() {
        assertEquals("0", new Card("0", "0").validSuits("0"));
	}

    public void testvalidSuits2() {
        assertEquals("C", new Card("2", "C").validSuits("C"));
        
	}
    public void testvalidSuits3() {
        assertEquals("0", new Card("A", "A").validSuits("A"));
        
	}
    public void testvalidSuits4() {
        assertEquals("0", new Card("A", "A").validSuits(" "));
        
	}
    
    public void testvalidRanks() {
        assertEquals("0", new Card("E", "Z").validRanks("Z"));
	}
	
    public void testvalidRanks1() {
        assertEquals("0", new Card("0", "0").validRanks("0"));
	}

    public void testvalidRanks2() {
        assertEquals("2", new Card("2", "C").validRanks("2"));
        
	}
    public void testvalidRanks3() {
        assertEquals("A", new Card("A", "A").validRanks("A"));
        
	}
    public void testvalidRanks4() {
        assertEquals("0", new Card("A", "A").validRanks(" "));
        
	}
    
    public void testcardToString() {
        assertEquals("2 D", new Card("2", "D").cardToString());
        
	}
    public void testcardEquals() {
        assertEquals(true, new Card("2", "D").equals(new Card("2", "D")));
        
	}
    public void testcardNotEquals() {
        assertEquals(false, new Card("2", "D").equals(new Card("0", "0")));
        
	}
}
