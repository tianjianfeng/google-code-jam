package qualification2012.speaking_in_tongues;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

class TestTongues {

	@Test
	public void testTranslate1() throws Exception {
			String output = 'our language is impossible to understand'
		
		assertEquals(output, new SpeakingInTongues().translate(input))
	}
}
