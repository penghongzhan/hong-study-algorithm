package class04;

import static org.junit.Assert.*;

import org.junit.Test;

public class Code03_ReversePair_HongTest {

    @Test
    public void Code03_ReversePair_HongTest() {
        int[] data = {7, 5, 6, 4};
//        int[] data = {4, 6, 5, 7};


        long start = System.currentTimeMillis();
        int i1 = Code03_ReversePair.reversPairNumber(data);
        System.out.println("m2: " + (System.currentTimeMillis() - start));
        System.out.println(i1);

        start = System.currentTimeMillis();
        Code03_ReversePair_Hong hong = new Code03_ReversePair_Hong();
        int i = hong.reversePairs(data);
        System.out.println("m1: " + (System.currentTimeMillis() - start));
        System.out.println(i);
    }

}