package timer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OneShotTimerTest {

	@Test
	void test1() {
		OneShotTimer ost1 = new OneShotTimer(1);
		assertEquals(true,ost1.hasNext());
	}
	
	@Test
	void test2() {
		OneShotTimer ost1 = new OneShotTimer(1);
		ost1.next();
		assertEquals(false,ost1.hasNext());
	}
	
	@Test
	void test3() {
		OneShotTimer ost1 = new OneShotTimer(0);
		ost1.next();
		ost1.next();
		assertEquals(false,ost1.hasNext());
	}
	
	@Test
	void test5() {
		OneShotTimer ost1 = new OneShotTimer(-1);
		assertEquals(-1,ost1.next());
	}
	
	@Test
	void test4() {
		OneShotTimer ost1 = new OneShotTimer(-1);
		assertEquals(true,ost1.hasNext());
	}
}
