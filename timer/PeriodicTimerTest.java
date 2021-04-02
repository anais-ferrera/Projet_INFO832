package timer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import timer.RandomTimer.randomDistribution;

class PeriodicTimerTest {

	@Test
	void test75() {
		PeriodicTimer pt1= new PeriodicTimer(2);
		assertEquals(true, pt1.hasNext());
	}
	
	@Test
	void test78() {
		PeriodicTimer pt2= new PeriodicTimer(2,5);
		assertEquals(5, pt2.next());
	}
	
	@Test
	void test74() {
		PeriodicTimer pt2= new PeriodicTimer(5);
		assertEquals(5, pt2.next());
	}
	
	@Test
	void test76() {
		PeriodicTimer pt = new PeriodicTimer(1);
		assertEquals(1, pt.getPeriod());
	}


	
	@Test
	void test77() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POSIBILIST,1,1);
		PeriodicTimer ptR1= new PeriodicTimer(1,rd1);
		assertEquals(1, ptR1.next());
	}
	
	@Test
	void test79() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POSIBILIST,1,1);
		PeriodicTimer ptR1= new PeriodicTimer(1,1,rd1);
		assertEquals(1, ptR1.next());
	}
	

}
