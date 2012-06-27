package qualification2012.googler_dance;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

class TestDance {

	@Test
	public void testDance1() throws Exception {
		String input = "3 1 5 15 13 11"
		int result = 3
		assert new GoogleDance().getMax(input) == result
	}
	@Test
	public void testDance2() throws Exception {
		String input = "3 0 8 23 22 21"
		int result = 2
		assert new GoogleDance().getMax(input) == result
	}
	@Test
	public void testDance3() throws Exception {
		String input = "2 1 1 8 0"
		int result = 1
		assert new GoogleDance().getMax(input) == result
	}
	@Test
	public void testDance4() throws Exception {
		String input = "6 2 8 29 20 8 18 18 21"
		int result = 3
		assert new GoogleDance().getMax(input) == result
	}
}
