package qualification2012.recycle_pair;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

class TestRecyclePair {

//	@Test
	public void test1() throws Exception {
		String input = "1 9"
		assert new RecyclePair().getRecyclePair(input) == 0
	}
//	@Test
	public void test2() throws Exception {
		String input = "10 40"
		assert new RecyclePair().getRecyclePair(input) == 3
	}
	
//	@Test
	public void test3() throws Exception {
		String input = "100 500"
		assert new RecyclePair().getRecyclePair(input) == 156
	}
	@Test
	public void test4() throws Exception {
		String input = "1111 2222"
		assert new RecyclePair().getRecyclePair(input) == 287
	}
}
