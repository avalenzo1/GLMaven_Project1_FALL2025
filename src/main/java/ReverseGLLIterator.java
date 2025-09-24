import java.util.ArrayList;
import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {
        private ArrayList<T> list = dumpList();
        private int index = list.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            T next = null;

            if (index >= 0) {
                next = list.get(index);
            }

            index -= 1;

            return next;
        }
}
