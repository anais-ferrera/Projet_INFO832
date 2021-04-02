package discreteBehaviorSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

class LogFormatterTest {
    LogFormatter lf;
    Handler h;
    
    @BeforeEach
    void setUp() throws Exception {
        lf = new LogFormatter();
        //h = new Handler();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
	// numero 48
    void testFormatLogRecord() {
        LogRecord lr = new LogRecord(Level.SEVERE,"John");
        String result = lf.format(lr);
        String msOnly = result.substring(17,22);
        double epsilonResult = Double.parseDouble(msOnly);
        
        result =result.substring(0,17)+result.substring(23,result.length()); 
        System.out.println(result);
        
        long timestampMS = System.currentTimeMillis();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SS");
        Date resultdate = new Date(timestampMS);
        String r = date_format.format(resultdate);
        String msOnlyExpected = r.substring(17,22);
        double epsilonExpected = Double.parseDouble(msOnlyExpected);
        
        assertTrue(Math.abs(epsilonResult-epsilonExpected)<0.05);
        String expected =r.substring(0,17)+": SEVERE\r\n"
                + "John\r\n";
        assertEquals(expected,result);
    }
}
