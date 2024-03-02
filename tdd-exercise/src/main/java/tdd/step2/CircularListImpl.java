package tdd.step2;

import java.util.*;

public final class CircularListImpl implements CircularList {

    private List<Integer> storage;
    private Optional<Integer> position = Optional.empty();

    private enum Direction {
        FORWARD,
        BACKWARDS,
    }

    private final class CircularListIterator implements Iterator {

        private CircularListImpl list;
        private Optional<Integer> position = Optional.empty();
        private Direction direction;


        private CircularListIterator(CircularListImpl list, Direction direction) {
            this.list = list;
            this.direction = direction;
        }

        @Override
        public boolean hasNext() {
            return !this.list.isEmpty();
        }

        @Override
        public Object next() {
            if(this.position.isEmpty()) {
                if(this.direction == Direction.FORWARD) {
                    this.position = Optional.of(-1);
                } else {
                    this.position = Optional.of(0);
                }
            }
            return this.skip();
        }

        private int skip() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            if(this.position.isEmpty()) {
                throw new IllegalStateException("skip() was called with an uninitialised position!");
            }
            int skip = this.direction == Direction.FORWARD ? 1 : -1;
            this.position = Optional.of(positiveModulo(position.get() + skip, this.list.size()));
            return this.list.get(this.position.get());
        }

    }

    public CircularListImpl() {
        this.storage = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.storage.add(element);
    }

    @Override
    public int size() {
        return this.storage.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new CircularListIterator(this, Direction.FORWARD);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new CircularListIterator(this, Direction.BACKWARDS);
    }

    private static int positiveModulo(int x, int n) {
        return (x % n + n) % n;
    }

    private int get(int position) {
        return this.storage.get(position);
    }
}
