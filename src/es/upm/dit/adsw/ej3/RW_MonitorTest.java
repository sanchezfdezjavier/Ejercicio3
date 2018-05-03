/**
 *
 */
package es.upm.dit.adsw.ej3;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Daniel del Riego San Martín
 *
 */
public class RW_MonitorTest {
    private RW_Monitor monitor;

    @Before
    public void setUp(){
        monitor = new RW_Monitor();
    }
    //test getters
    @Test
    public void test0(){
        assertEquals(0, monitor.getNReadersIn());
        assertEquals(0, monitor.getNWritersIn());
    }
    //test openReading
    @Test
    public void test1(){
        assertEquals(0, monitor.getNReadersIn());
        assertEquals(0, monitor.getNWritersIn());
        monitor.openReading();
        assertEquals(1, monitor.getNReadersIn());
        assertEquals(0, monitor.getNWritersIn());
    }
    //test openWriting
    @Test
    public void test2(){
        assertEquals(0, monitor.getNReadersIn());
        assertEquals(0, monitor.getNWritersIn());
        monitor.openWriting();
        assertEquals(0, monitor.getNReadersIn());
        assertEquals(1, monitor.getNWritersIn());
    }
    //test closeReading
    @Test
    public void test3(){
        monitor.openReading();
        monitor.closeReading();
        assertEquals(0, monitor.getNReadersIn());
        assertEquals(0, monitor.getNWritersIn());
    }
    //test closeWriting
    @Test
    public void test4(){
        monitor.openWriting();
        monitor.closeWriting();
        assertEquals(0, monitor.getNReadersIn());
        assertEquals(0, monitor.getNWritersIn());
    }

    //test openReading2
    @Test
    public void test5(){
        monitor.openReading();
        monitor.openReading();
        assertEquals(2, monitor.getNReadersIn());
    }


    //ow_cr
    @Test(expected = Exception.class)
    public void ow_cr(){
        monitor.openWriting();
        monitor.closeReading();
    }

}