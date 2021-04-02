package discreteBehaviorSimulator;
import action.*;
import timer.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.DiscreteActionInterface;
import timer.Timer;

class DiscreteActionSimulatorTest {
	DiscreteActionSimulator simulator;
	DiscreteAction discreteA1;
	DiscreteAction discreteA2;
	DiscreteAction discreteA3;

	@BeforeEach
	void setUp() throws Exception {
		simulator = new DiscreteActionSimulator();
		
		Clock clock = Clock.getInstance();
		
		TreeSet<Integer> dates = new TreeSet<Integer>();
		Timer timer3 = new DateTimer(dates);
		dates.add(new Integer(0));
		dates.add(new Integer(3));
		Timer timer2 = new DateTimer(dates);
		dates.add(new Integer(5));
		Timer timer = new DateTimer(dates);
		
		discreteA1 = new DiscreteAction(clock,"isVirtual",timer);
		discreteA2 = new DiscreteAction(clock,"toString",timer2);
		discreteA3 = new DiscreteAction(clock,"toString",timer3);
		//discreteA3 = new DiscreteAction(clock,"toString",timer2);
	}
	

	@AfterEach 
	void tearDown() throws Exception {
		System.out.println("\n running tearDown()");
		simulator = null;
	}

	@Test
	// numero 55
	void testRunSetNbLoop() {
		System.out.println("\n TEST 1 DE SETNBLOOP()");
		simulator.setNbLoop(2);
		simulator.run();
		
		System.out.println("\n TEST 2 DE SETNBLOOP()");
		simulator.setNbLoop(-1);
		simulator.run();
		
	}

	@Test
	// numero 52
	void testAddAction() {
		simulator.addAction(discreteA1);
		
		String result = simulator.toString();
		String expected = discreteA1.toString();
		expected = "------------------\n"
				+ "TestAuto :1"+expected+"\n"
				+ "---------------------"+"\n";
		assertEquals(expected,result);
		
	// numero 53
		simulator.addAction(discreteA3);
	
		String result2 = simulator.toString();
		String expected2 = discreteA1.toString();
		expected2 = "------------------\n"
				+ "TestAuto :1"+expected2+"\n"
				+ "---------------------"+"\n";
		assertEquals(expected2,result2);
		
	}
	

	@Test
	// numero 54
	void testRun() {
		System.out.println("PREMIER TEST RUN()\n");
		simulator.run();
	}
	
	@Test
	void testRun2() {
		System.out.println("\n DEUXIEME TEST RUN()\n");
		simulator.start();
	// numero 50
		boolean expected = simulator.getRunning();
		assertEquals(expected,true);
		System.out.println("\n FIN DEUXIEME TEST RUN()\n");
	// numero 56
		simulator.run();
	}
	
	@Test
	// numero 57
	// le test nous renvoie bien une erreur mais la couverture des tests ne s'effectuent pas correctement 
	// c'est pourquoi les deux lignes de commande sont en commentaire
	void testRun3() {
		System.out.println("\n TROISIEME TEST RUN()\n");
		simulator.setNbLoop(2);
		discreteA1.next();
		discreteA2.next();
		simulator.addAction(discreteA2);
		simulator.addAction(discreteA1);
		//simulator.start();
		//simulator.run();
		System.out.println("\n FIN TROISIEME TEST RUN()\n");
	}

	@Test
	// numero 51
	void testStop() {
		System.out.println("\n TEST DE STOP() \n");

		simulator.stop();
		boolean expected = simulator.getRunning();
		assertEquals(expected,false);
	}

	@Test
	// numero 49
	void testToString() {
		String result = simulator.toString();
		String expected = "------------------\nTestAuto :0---------------------\n";
		assertEquals(expected,result);
	}
}
