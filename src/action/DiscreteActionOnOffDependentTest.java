package action;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import discreteBehaviorSimulator.Clock;
import timer.DateTimer;
import timer.OneShotTimer;
import timer.Timer;

class DiscreteActionOnOffDependentTest {

	// REFACTORING
	// Test 7'
	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
		Timer timerOn = new OneShotTimer(10);
		Timer timerOff = new OneShotTimer(20);
		DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
		actionOnOff.setLapsTime(10);
		actionOnOff.spendTime(5);
		Integer integer =5;	
	    assertEquals(integer,actionOnOff.getCurrentLapsTime());
	}

	// REFACTORING
	// Test 8'
	@Test
	void testGetCurrentLapsTime() {
		Clock clock = Clock.getInstance();
		Timer timerOn = new OneShotTimer(10);
		Timer timerOff = new OneShotTimer(20);
		DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
		actionOnOff.setLapsTime(10);
		assertEquals(10,actionOnOff.getCurrentLapsTime());
	}
	
	// REFACTORING
	// Test 9'
	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Timer timerOn1 = new OneShotTimer(15);
		Timer timerOff1 = new OneShotTimer(25);
		DiscreteActionOnOffDependent actionOnOff1 = new DiscreteActionOnOffDependent(clock1,"getInstance",timerOn1,"getTime",timerOff1);
		Clock clock2 = Clock.getInstance();
		Timer timerOn2 = new OneShotTimer(10);
		Timer timerOff2 = new OneShotTimer(20);
		DiscreteActionOnOffDependent actionOnOff2 = new DiscreteActionOnOffDependent(clock2,"getInstance",timerOn2,"getTime",timerOff2);

		// 1 - lapstime == nul
		actionOnOff1.setLapsTime(null);
        assertEquals(1,actionOnOff1.compareTo(actionOnOff2));
        
        // 2 - c.getCurrentLapsTime() == null
        actionOnOff1.setLapsTime(3);
        actionOnOff2.setLapsTime(null);
        assertEquals(-1,actionOnOff1.compareTo(actionOnOff2));
        
        // 3 - this.lapsTime > c.getCurrentLapsTime()
        actionOnOff2.setLapsTime(2);
        assertEquals(1,actionOnOff1.compareTo(actionOnOff2));
        
        // 4 - this.lapsTime < c.getCurrentLapsTime()
        actionOnOff1.setLapsTime(1);
        assertEquals(-1,actionOnOff1.compareTo(actionOnOff2));
        
        // 5 - this.lapsTime == c.getCurrentLapsTime()
        actionOnOff1.setLapsTime(0);
        actionOnOff2.setLapsTime(0);
        assertEquals(0,actionOnOff1.compareTo(actionOnOff2));     
	}
	
	// Test 23
		@Test
		void testNextAction() throws NoSuchMethodException, SecurityException {
			Clock clock = Clock.getInstance();
			Timer timerOn = new OneShotTimer(10);
			Timer timerOff = new OneShotTimer(20);
			DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
			actionOnOff.nextAction();
			assertEquals(clock.getClass().getDeclaredMethod("getInstance", new Class<?>[0]),actionOnOff.getMethod());
			actionOnOff.nextAction();
			assertEquals(clock.getClass().getDeclaredMethod("getTime", new Class<?>[0]),actionOnOff.getMethod());
		}
		
		// Test 25
		@Test
		void testGetMethod() throws NoSuchMethodException, SecurityException {
			Clock clock = Clock.getInstance();
			Timer timerOn = new OneShotTimer(10);
			Timer timerOff = new OneShotTimer(20);
			DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
			assertEquals(clock.getClass().getDeclaredMethod("getTime", new Class<?>[0]),actionOnOff.getMethod());
		}
		
		// Test 27
		@Test
		void testGetObject() {
			Clock clock = Clock.getInstance();
			Timer timerOn = new OneShotTimer(10);
			Timer timerOff = new OneShotTimer(20);
			DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
			assertSame(clock,actionOnOff.getObject());
		}
		
		// Test 29
		@Test
		void testNext() throws NoSuchMethodException, SecurityException {
			Clock clock = Clock.getInstance();
			Timer timerOn = new OneShotTimer(10);
			Timer timerOff = new OneShotTimer(20);
			DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
			DiscreteActionInterface result = actionOnOff.next();
			assertEquals(clock.getClass().getDeclaredMethod("getInstance", new Class<?>[0]),result.getMethod());
		}

		
		@Test
		void testHasNext() {
			Clock clock = Clock.getInstance();
			Timer timerOn = new OneShotTimer(10);
			Timer timerOff = new OneShotTimer(20);
			DiscreteActionOnOffDependent actionOnOff = new DiscreteActionOnOffDependent(clock,"getInstance",timerOn,"getTime",timerOff);
			// Test 30
			assertTrue(actionOnOff.hasNext());
			timerOn.next();
			// Test 31
			assertTrue(actionOnOff.hasNext());
			timerOff.next();
			// Test 32
			assertFalse(actionOnOff.hasNext());
		}
		
		@Test
		void testActionOnOffDates() {
			Clock clock = Clock.getInstance();
			// Test 33
			TreeSet<Integer> datesOn1 = new TreeSet<Integer>();
			TreeSet<Integer> datesOff1 = new TreeSet<Integer>();
	        datesOn1.add(new Integer(4));
	        datesOff1.add(new Integer(5));
	        DiscreteActionOnOffDependent actionOnOff1 = new DiscreteActionOnOffDependent(clock,"getInstance",datesOn1,"getTime",datesOff1);
	        assertSame(clock,actionOnOff1.getObject());
	        
	        // Test 34
	        TreeSet<Integer> datesOn2 = new TreeSet<Integer>();
			TreeSet<Integer> datesOff2 = new TreeSet<Integer>();
	        datesOn2.add(new Integer(5));
	        datesOff2.add(new Integer(4));
	        DiscreteActionOnOffDependent actionOnOff2 = new DiscreteActionOnOffDependent(clock,"getInstance",datesOn2,"getTime",datesOff2);
	        assertSame(clock,actionOnOff2.getObject());
	        
        

	
	}

}
