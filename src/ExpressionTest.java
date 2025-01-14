import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class ExpressionTest {

	Expressions e = new Expressions();

	@Test
	void testValueOf() {
		assertEquals(15, e.valueOf("2 3 + 3 *"));
		assertThrows(EmptyStackException.class, () -> {
			e.valueOf("");
		});
		assertThrows(EmptyStackException.class, () -> {
			e.valueOf("3 + +");
		});
		assertEquals(2, e.valueOf("2 2 * 2 /"));
		assertEquals(3, e.valueOf("1 2 * 3 - 4 +"));
		assertEquals(-5, e.valueOf("-12 7 +"));
		assertEquals(2, e.valueOf("2 3 4 + 2 / * 4 %"));
		assertEquals(12, e.valueOf("2 3 * 4 2 / *"));
		assertEquals(-16, e.valueOf("3 4 - 5 3 * -"));

	}

	@Test
	void testInToPost() {
		assertEquals("2 3 4 + 2 / * 4 %", e.inToPost(" 2 * ( ( 3 + 4 ) / 2 ) % 4"));
		assertEquals("-12 7 +", e.inToPost("-12 + 7"));
		assertEquals("4 2 3 6 * - +", e.inToPost("4 + ( 2 - ( 3 * 6 ) )"));
		assertEquals("4 2 + 3 6 * -", e.inToPost("4 + 2 - 3 * 6"));
		assertEquals("1 2 * 3 - 4 +", e.inToPost("1 * 2 - 3 + 4"));
		assertEquals("3 4 5 + *", e.inToPost("3 * ( 4 + 5 )"));
		assertEquals("1 2 - 3 3 * 4 / +", e.inToPost("1 - 2 + 3 * 3 / 4"));
		assertEquals(2, e.valueOf("1 2 + 3 4 - +"));
	}

}
