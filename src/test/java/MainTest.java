import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testGGT() {
        long a = 13;
        long b = 17;

        long test = Main.ggT(a,b);
        assertEquals(1, test);
    }

    @Test
    public void testIsPrime() {
        long a = 9;

        boolean test = Main.isPrime(a);
        assertEquals(false, test);
    }
    @Test
    public void testIsPrime2() {
        long a = 13;

        boolean test = Main.isPrime(a);
        assertEquals(true, test);
    }

    @Test
    public void testEukl() {
        long phi = 120;
        long e = 17;

        long[] test = Main.eukl(phi, e);
        assertEquals(-7, test[2]);
    }

    @Test
    public void testEukl2() {
        long phi = 262548;
        long e = 1721;

        long[] test = Main.eukl(phi, e);
        assertEquals(1373, test[2]);
    }

}