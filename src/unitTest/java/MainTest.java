import org.junit.Test;
import static org.junit.Assert.*;


public class MainTest {
    @Test
    public void TestClass() {
        Main App = new Main();
        int phi = 120;
        int e = 17;

        int[] test = App.eukl(phi,e);

        assertEquals(-7,test[2]);
    }
}
