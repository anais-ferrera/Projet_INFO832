package discreteBehaviorSimulator;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ClockTest {

	private Clock clock;
	private Observer obs;
	
	private int nextJ;
	private ReentrantReadWriteLock lock;
	
	@BeforeEach
	void setUp() throws Exception {
		clock = Clock.getInstance();
		obs = new Observer(10);
	}

	@Test 
	// numero 35
	void testGetInstance() {
		Clock result = Clock.getInstance();
		Clock expected = clock;
		assertEquals(expected, result);
	}

	@Test
	// numero 36
	void testAddObserver() {
		clock.addObserver(obs);
		clock.setNextJump(5);
		int result = obs.getTime();
		int expected = 15;
		assertEquals(expected, result);
	}
	
	@Test
	// numero 37
	void testRemoveObserver() {
		clock.addObserver(obs);
		clock.removeObserver(obs);
		clock.setNextJump(5);
		int result = obs.getTime();
		int expected = 10;
		assertEquals(expected, result);
	}
	
	@Test
	// numero 38
	void testIsVirtual() {
		clock.setVirtual(true);
		Boolean expected = true;
		Boolean result = clock.isVirtual();
		assertEquals(expected, result);
	}

	@Test
	// numero 39
	void testSetVirtual() {
		clock.setVirtual(false);
		assertEquals(clock.isVirtual(),false);
	}
	
	@Test
	// numero 40
	void testSetNextJump() {
		try {
			clock.setNextJump(nextJ);
			
		}
		catch(Exception e) {
			fail("there is a exception : " + e);
		}
		assertTrue(true);
		
	}

	@Test
	// numero 41
	void testIncrease() throws Exception {
		clock.addObserver(obs);
		clock.setNextJump(7);
		clock.increase(7);
		int result = obs.getTime();
		int expected = 7;
		assertEquals(expected, result);
	
	// numero 42
		boolean result2 = false;
		try {
			clock.increase(3);
		}
		catch(Exception e) {
			result2 = true;
		}
		assertEquals(result2,true);	

	}

	@Test
	// numero 43
	void testGetTime() {
		//si c'est virtual alors retourne time
		clock.setVirtual(true);
		long result = clock.getTime();
		long expected = 0;
		assertEquals(expected, result);
	
	// numero 44
		//sinon cela retourne Date().getTime()
		clock.setVirtual(false);
		long result2 = clock.getTime();
		long expected2 = new Date().getTime();
		assertEquals(expected2, result2);

	}

	@Test
	// numero 45 et 46
	void testUnlockReadAccess() {
		//clock.lockReadAccess();
		//clock.unlockReadAccess();
	

		clock.unlockReadAccess();
	}


	@Test
	// numero 47
	void testToString() {
		String expected = "0";
		String result = clock.toString();
		assertEquals(expected, result);
	}

}