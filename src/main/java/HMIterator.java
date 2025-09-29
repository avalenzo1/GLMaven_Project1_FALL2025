import java.util.ArrayList;
import java.util.Iterator;

public class HMIterator<T> implements Iterator<T> {
    MyHashMap<T> myHashMap;
    ArrayList<T> list = new ArrayList<>();
    int currIndex = 0;

    HMIterator(MyHashMap<T> myHashMap) {

        this.myHashMap = myHashMap;

        // Adds all items in map to list
        for (int i = 0; i < this.myHashMap.map.size(); i++) {

            GenericQueue<T> currBucket = this.myHashMap.map.get(i);

            if (currBucket == null) {
                continue;
            }

            Iterator<T> currIterator = currBucket.iterator();

            while (currIterator.hasNext()) {
                list.add(currIterator.next());

            }
        }
    }

    @Override
    public boolean hasNext() {
        if (myHashMap.map.isEmpty()) {
            // if empty, false
            return false;
        } else if (currIndex >= list.size()) {
            // if out-of-bounds, false
            return false;
        } else if (list.get(currIndex) != null) {
            return true;
        }

        return false;
    }

    @Override
    public T next() {
        if (hasNext()) {
            // gets current item
            T curr = list.get(currIndex);
            // increment
            currIndex++;
            return curr;
        }

        return null;
    }
}
