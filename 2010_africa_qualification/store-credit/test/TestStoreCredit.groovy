import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestStoreCredit {

	
	@Before
	public void setUp() {
	}
	
	@Test
	public void threeItemsAndTheFirstTwoPriceSumToTheCredit() {
		int credit = 100;
		List itemPrice = [25, 75, 5]
		
		assertEquals([1, 2], new StoreItem().getTwoItemsForCredit(credit, itemPrice));
	}
	
	@Test
	public void threeItemsAndTheLastTwoPriceSumToTheCredit() throws Exception {
		int credit = 100;
		List itemPrice = [5, 75, 25];
		assertEquals([2, 3], new StoreItem().getTwoItemsForCredit(credit, itemPrice));
	}
	
	@Test
	public void threeItemsAndFirstAndThirdPriceSumToTheCredit() throws Exception {
		int credit = 100;
		List itemPrice = [75, 5, 25];
		assertEquals([1, 3], new StoreItem().getTwoItemsForCredit(credit, itemPrice));
	}
	
	@Test
	public void testCase2() throws Exception {
		int credit = 200;
		List itemPrice = [150, 24, 79, 50, 88, 345, 3]
		assertEquals([1, 4], new StoreItem().getTwoItemsForCredit(credit, itemPrice));
	}
	
	@Test
	public void testCase3() throws Exception {
		int credit = 8;
		List itemPrice = [2, 1, 9, 4, 4, 56, 90, 3];
		assertEquals([4, 5], new StoreItem().getTwoItemsForCredit(credit, itemPrice));
	}
	
}
