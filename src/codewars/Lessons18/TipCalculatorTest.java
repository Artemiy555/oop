package codewars.Lessons18;

import org.junit.Test;
import static org.junit.Assert.*;

public class TipCalculatorTest {

    @Test
    public void test1() {
        assertEquals(1.5, TipCalculator.calculateTip(30, "poor"));
    }

    @Test
    public void test2() {
        assertEquals(5, TipCalculator.calculateTip(20, "Excellent"));
    }


    @Test
    public void test3() {
        assertEquals(0, TipCalculator.calculateTip(107.65, "GReat"));
    }
}