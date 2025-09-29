import java.util.ArrayList;
import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {
        private ArrayList<T> list;
        private int index;

        ReverseGLLIterator(GenericList.Node<T> head) {
            // Create new iterator
            GLLIterator<T> gllIterator = new GLLIterator<>(head);

            list = new ArrayList<>();

            while (gllIterator.hasNext()) {
                list.add(gllIterator.next());
            }

            index = list.size() - 1;

        }

        @Override
        public boolean hasNext() {
            // returns true if in-bounds
            return index >= 0;
        }

        @Override
        public T next() {
            T next = null;

            // store old item to next
            if (index >= 0) {
                next = list.get(index);
            }

            index -= 1;

            return next;
        }
}
