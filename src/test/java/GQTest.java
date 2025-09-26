import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class GQTest {


    public static void main(String[] args) {
        GenericQueue<String> testingList = new GenericQueue<>();

        testingList.add("a");
        testingList.add("b");
        testingList.add("c");
        testingList.add("d");
        int counter = 0;
        String[] list = {"a", "b", "c", "d"};

        Iterator<String> iterator = testingList.iterator();

        // Have to test both while and for loop iteration.
        while (iterator.hasNext()) {
            assertEquals(iterator.next(), list[counter], "Did not properly add " + list[counter] + "\n");
            counter++;
        }

        counter = 0;

        for (String s : testingList) {
            assertEquals(s, list[counter], "Did not properly add " + list[counter] + "\n");
            counter++;
        }

        // dumpList()

        // Testing that getLength and getHead work as is.
        assertEquals(4, testingList.getLength(), "Incorrect list length.");
        assertEquals("a", testingList.getHead().data, "Did not properly add a\n");

        // Test for most methods in GenericList

        // get
        // set
        // print()

        // Test for most

        // TODO: write test for setLength();

        testingList.enqueue("f");
        testingList.enqueue("1");

        for (String s : testingList) {
            System.out.println(s);
        }

        System.out.println(testingList.get(1));
        System.out.println("TESTINGTESTING!!!");

        assertEquals("1", testingList.get(5), "Did not properly enqueue\n");
        assertEquals("a", testingList.dequeue(), "Deque did not return right removed element a");
        assertEquals("b", testingList.dequeue(), "Deque did not return right removed element b");
        assertEquals("c", testingList.dequeue(), "Deque did not return right removed element c");
        assertEquals("d", testingList.dequeue(), "Deque did not return right removed element d");
        String DequeuedVariable = testingList.dequeue();
        assertEquals("f" ,DequeuedVariable , "Deque did not return right removed element f, returned " + DequeuedVariable + "\n");
        assertEquals("1", testingList.dequeue(), "Deque did not return right removed element 1");
        assertNull(testingList.dequeue(), "Queue is empty but did not return null");

        assertEquals( 0, testingList.getLength(), "wrong length for deque, length is actually" + testingList.getLength() + " \n");


        System.out.println("Successfully added elements");
    }

    GQTest() {
        System.out.println("GQTest");
    }
}
