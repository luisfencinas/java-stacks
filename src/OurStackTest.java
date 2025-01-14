import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class OurStackTest {

	@Test
	void testIsEmpty() {
		OurStack<Integer> s = new LinkedStack<>();
		assertTrue(s.isEmpty());
	}

	// Don't forget to make sure peek() and pop() throw EmptyStackException
	@Test
	void testPushAndPeek() {
		OurStack<Integer> s = new LinkedStack<>();
		assertThrows(EmptyStackException.class, () -> {
			s.peek();
		});
		s.push(1);
		s.push(2);
		assertFalse(s.isEmpty());
		assertEquals(2, s.peek());
	}

	@Test
	void testPushAndPop() {
		OurStack<Integer> s = new LinkedStack<>();
		s.push(1);
		s.push(2);
		assertEquals(2, s.pop());
		assertEquals(1, s.pop());
		assertThrows(EmptyStackException.class, () -> {
			s.pop();
		});
	}
	@Test
	void testPushAndPopString() {
		OurStack<String> s = new LinkedStack<>();
		s.push("Taco");
		s.push("Pan");
		assertEquals("Pan", s.pop());
		assertEquals("Taco", s.pop());
		assertThrows(EmptyStackException.class, () -> {
			s.pop();
		});
	}
}

