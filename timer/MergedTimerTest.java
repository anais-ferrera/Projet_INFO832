package timer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergedTimerTest {

	@Test
	void test80a() {
		OneShotTimer ost1 = new OneShotTimer(1);
		OneShotTimer ost2 = new OneShotTimer(2);
		MergedTimer m1 = new MergedTimer(ost1,ost2);
		assertEquals(true,m1.hasNext());
	}

	@Test
	void test80b() {
		OneShotTimer ost1 = new OneShotTimer(1);
		OneShotTimer ost2 = new OneShotTimer(2);
		MergedTimer m1 = new MergedTimer(ost1,ost2);
		assertEquals(3,m1.next());
	}
	
	@Test
	void test80c() {
		OneShotTimer ost1 = new OneShotTimer(1);
		MergedTimer m1 = new MergedTimer(ost1,ost1);
		assertEquals(2,m1.next());
	}
	
	@Test
	void test80d() {
		OneShotTimer ost1 = new OneShotTimer(1);
		MergedTimer m1 = new MergedTimer(ost1,ost1);
		assertEquals(true,m1.hasNext());
	}
	
	@Test
	void test80e() {
		OneShotTimer ost1 = new OneShotTimer(1);
		MergedTimer m1 = new MergedTimer(ost1,ost1);
		m1.next();
		assertEquals(2,m1.next());
	}
	
	@Test
	void test84() {
		OneShotTimer ost1 = new OneShotTimer(1);
		PeriodicTimer pt = new PeriodicTimer(2);
		// ligne que l'on veut tester :
		// MergedTimer mt = new MergedTimer(ost1, MergedTimer(ost1, pt));
		MergedTimer mt = new MergedTimer(ost1, pt);
		assertEquals(4,mt.next());
	}
	
}
