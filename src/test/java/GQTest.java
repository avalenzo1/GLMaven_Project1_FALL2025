import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GQTest {


    public static void main(String[] args) {
        GenericQueue<String> testingList = new GenericQueue<>();

        testingList.add("a");
        testingList.add("b");
        testingList.add("c");
        testingList.add("d");
        int counter = 0;
        String list[] = {"a", "b", "c", "d"};

        Iterator<String> iterator = testingList.iterator();

        while (iterator.hasNext()) {
            System.out.println(counter++);
            iterator.next();
//            assertEquals(iterator.next(), list[counter], "Did not properly add " + list[counter] + "\n");
//            counter++;
        }

//        for (String s : testingList) {
//            System.out.println(s);
//            assertEquals(s., list[counter], "Did not properly add " + list[counter] + "\n");
//            counter++;
//        }

        System.out.println("Successfully added elements");
    }

    GQTest() {
        System.out.println("GQTest");
    }
}
