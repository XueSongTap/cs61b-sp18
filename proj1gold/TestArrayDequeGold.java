import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {

        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        //test addLast
        for (int i = 0; i < 10; i++) {
            Integer rand = StdRandom.uniform(100);
            sad1.addLast(rand);
            ads1.addLast(rand);
        }

        for (int i = 0; i < 10; i++ ) {
            int actual = ads1.get(i);
            int expect = sad1.get(i);
            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
                            + " not equal to " + expect + "!",
                    expect, actual);
        }

        //test addFirst
        for (int i = 0; i < 10; i++) {
            Integer rand = StdRandom.uniform(100);
            sad1.addFirst(rand);
            ads1.addFirst(rand);
        }
        for (int i = 0; i < 10; i++ ) {
            int actual = ads1.get(i);
            int expect = sad1.get(i);
            assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
                            + " not equal to " + expect + "!",
                    expect, actual);
        }


        // test removeFirst
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();

        for (int i = 0; i < 10; i++ ) {
            actualList.add(ads1.removeFirst());
            expectList.add(sad1.removeFirst());
        }
        int actualSize = actualList.size();


        for (int i = 0; i < 10; i++) {

        }
    }
}
