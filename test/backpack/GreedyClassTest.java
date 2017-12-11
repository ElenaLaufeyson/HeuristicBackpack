package backpack;

import org.junit.Test;
import static org.junit.Assert.*;

public class GreedyClassTest {

    @Test
    public void greedyTest() {
        System.out.println("greedy");
        int[] w1 = {47, 14, 23, 42, 34, 39, 13, 16, 43, 9};
        int[] c1 = {11, 37, 16, 42, 10, 2, 25, 30, 35, 26};
        int L = 50;
        GreedyClass greedy1 = new GreedyClass();
        Data.input(w1, c1, L);
        int expResult1 = 11;
        int result1 = greedy1.find();
        assertEquals(expResult1, result1);
        int[] w2 = {35, 32, 38, 12, 37, 31, 21, 43, 19, 7};
        int[] c2 = {39, 1, 49, 13, 50, 39, 42, 32, 5, 39};
        GreedyClass greedy2 = new GreedyClass();
        Data.input(w2, c2, L);
        int expResult2 = 52;
        int result2 = greedy2.find();
        assertEquals(expResult2, result2);
        int[] w3 = {22, 9, 27, 21, 26, 45, 3, 15, 33, 11};
        int[] c3 = {13, 12, 31, 8, 28, 49, 35, 34, 10, 32};
        GreedyClass greedy3 = new GreedyClass();
        Data.input(w3, c3, L);
        int expResult3 = 94;
        int result3 = greedy3.find();
        assertEquals(expResult3, result3);
    }
    
}
