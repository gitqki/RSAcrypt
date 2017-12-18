import org.junit.Test;
import static org.junit.Assert.*;


public class MainTest {
    @Test
    public void TestPhiAndE() {
        Main App = new Main();
        long phi = 120;
        long e = 17;

        long[] test = App.eukl(phi,e);

        assertEquals(-7,test[2]);
    }
    public void TestRandomPrime() {
        Main App = new Main();

        long test = App.randPrime(0,100000);

    }
}
