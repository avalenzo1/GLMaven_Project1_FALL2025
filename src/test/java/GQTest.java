import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class GQTest {


    public static void main(String[] args) {
        GenericQueue<String> testingList = new GenericQueue<>();
        GenericQueue<String> emptyList = new GenericQueue<>();

        testingList.add("a");
        testingList.add("b");
        testingList.add("c");
        testingList.add("d");
        int counter = 0;
        String[] list = {"a", "b", "c", "d"};

        // ITERATOR TESTS

        // Non-empty list

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

        // Empty List
        Iterator<String> emptyIterator = emptyList.iterator();

        while (emptyIterator.hasNext()) {
            System.out.println("An empty iterator should not run this print stmt!");
            System.out.println(emptyIterator.next());
        }

        for (String s : emptyList) {
            System.out.println("Should not run also for forEach!");
        }

        // descendingIterator
        Iterator<String> descendingIterator = testingList.descendingIterator();
        Iterator<String> descendingIteratorEmpty = emptyList.descendingIterator();

        counter = list.length - 1;

        while (descendingIterator.hasNext()) {
            assertEquals(list[counter],  descendingIterator.next(), "Did not properly add " + list[counter] + "\n");
            counter--;
        }

        while (descendingIteratorEmpty.hasNext()) {
            System.out.println("An empty descending iterator should not run this print stmt!");
        }

        // dumpList()

        ArrayList<String> arrayDump = testingList.dumpList();
        ArrayList<String> emptyArrayDump = emptyList.dumpList();

        for (int i = 0; i < arrayDump.size(); i++) {
            assertEquals(list[i], arrayDump.get(i), "dumpArray not working");
        }

        for (int i = 0; i < emptyArrayDump.size(); i++) {
            System.out.println("This should never run since this is an empty list!");
        }

        // Testing that getLength and getHead work as is.
        assertEquals(4, testingList.getLength(), "Incorrect list length.");
        assertEquals("a", testingList.getHead().data, "Did not properly add a\n");

        // Test for most methods in GenericList

        // get
        assertEquals("c", testingList.get(2), "Wrong output for get testing\n");
        // set

        // setting non existem index item to something
        testingList.set(24, "sdgsdgsdg");

        // set head

        assertEquals("a", testingList.set(0, "tf"), "Wrong output a for set testing\n");
        assertEquals("tf", testingList.set(0, "a"), "Wrong output tf for set testing\n");

        // set middle index
        testingList.print();
        assertEquals("b", testingList.set(1, "code"), "Wrong output b for set testing\n");
        assertEquals("code", testingList.set(1, "b"), "Wrong output code for set testing\n");

        // set tail
        assertEquals("d", testingList.set(3, "laborer"), "Wrong output d for set testing\n");
        assertEquals("laborer", testingList.set(3, "d"), "Wrong output laborer for set testing\n");

        // print()
        //Empty list print testing
        emptyList.print();
        System.out.println("Should print out Empty List\n");

        testingList.print();
        System.out.println("Should print out a\n b\n c\n d\n");
        // full list print testing

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
