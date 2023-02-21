package hong.combination;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListValuesCombinationTest {

    @Test
    public void combineDimValues() {
        ListValuesCombination combination = new ListValuesCombination();
        List<List<String>> list = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        codes.add("1");
        codes.add("2");
        codes.add("3");
        codes.add("4");
        list.add(codes);
        List<String> codes01 = new ArrayList<>();
        codes01.add("a");
        codes01.add("b");
        list.add(codes01);
        List<String> codes02 = new ArrayList<>();
        codes02.add("①");
        codes02.add("②");
        codes02.add("③");
        list.add(codes02);
        List<String> strings = combination.combineDimValues(list);
        for (String sss : strings) {
            System.out.println(sss);
        }
    }
}