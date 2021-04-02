package timer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import timer.RandomTimer.randomDistribution;

class RandomTimerTest {

	@Test
	void test1() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.EXP,1);
		assertEquals(2,rd1.next());
	}
	
	@Test
	void test2() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POISSON,10);
		assertEquals(2,rd1.next());
	}
	
	//Construction distrib,param avec autre que poisson et EXP // it works
	@Test
	void test3() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.GAUSSIAN,10);
		assertEquals(2,rd1.next());
	}
	
	//Construction distrib,int,int avec autre que possibilistou gauss //it works
	@Test
	void test4() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POISSON,10,10);
		assertEquals(2,rd1.next());
	}
	
	@Test
	void test5() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.GAUSSIAN,1,10);
		assertEquals(2,rd1.next());
	}
	
	@Test
	void test6() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POSIBILIST,2,8);
		assertEquals(2,rd1.next());
	}
	
	@Test
	void test7() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POSIBILIST,1,10);
		assertEquals(randomDistribution.POSIBILIST.name(),rd1.getDistribution());
	}
	
	@Test
	void test8() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.POSIBILIST,1,10);
		assertEquals(1,rd1.getDistributionParam());
	}
	
	@Test
	void test9() throws Exception {
		RandomTimer rd1 = new RandomTimer(randomDistribution.EXP,10);
		assertEquals(1,rd1.getDistributionParam());
	}
	
}
