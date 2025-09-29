import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class HMTest {
    public static void main(String[] args) {
        MyHashMap<String> myHashMap = new MyHashMap<>("Cozmo", "Value1");

        assertEquals(1, myHashMap.size(), "Incorrect size");
        assertFalse(myHashMap.isEmpty());

        myHashMap.put("omzoC", "Value2");

        assertEquals("Value1", myHashMap.get("Cozmo"), "Incorrect value");
        assertEquals("Value2", myHashMap.get("omzoC"), "Incorrect value");

        assertEquals(2, myHashMap.size(), "Incorrect size");

        assertTrue(myHashMap.contains("Cozmo"), "Incorrect value for contains");
        assertFalse(myHashMap.contains("Cozmo!!??"), "Incorrect value for contains");

        assertEquals("Value1", myHashMap.replace("Cozmo", "Value3"), "Incorrect value");
        assertEquals("Value2", myHashMap.replace("omzoC", "Value4"), "Incorrect value");
        assertNull(myHashMap.replace("omzoC!", "Value4"), "Incorrect value - nonexistent key");

        System.out.println("\n\n\n");
        myHashMap.put("key1", "Value5");
        myHashMap.put("key1", "Value6");
        myHashMap.put("key1", "Value7");


        myHashMap.put("key2", "Value8");
        myHashMap.put("key2", "Value9");


        myHashMap.put("key3", "Value10");
        myHashMap.put("key3", "Value11");
        myHashMap.put("key3", "Value12");
        myHashMap.put("key3", "Value13");
        myHashMap.put("key3", "Value14");

        HMIterator<String> hmIterator = new HMIterator<>(myHashMap);
        while (hmIterator.hasNext()) {
            System.out.println(hmIterator.next());
        }
    }

    HMTest() {
        System.out.println("HMTest");
    }
}

// deux visages