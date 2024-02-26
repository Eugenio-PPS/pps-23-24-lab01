package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> storage;
    private Optional<Integer> position = Optional.empty();

    public CircularListImpl() {
        this.storage = new ArrayList<Integer>();
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

    private static int positiveModulo(int x, int n) {
        return (x % n + n) % n;
    }

    private Optional<Integer> skip(int skip) {
        if(this.isEmpty()) {
            return Optional.empty();
        } else {
            this.position = Optional.of(positiveModulo(position.get() + skip, this.storage.size()));
            return Optional.of(this.storage.get(this.position.get()));
        }

    }

    @Override
    public Optional<Integer> next() {
        if(this.position.isEmpty()) {
            this.position = Optional.of(-1);
        }
        return skip(1);
    }

    @Override
    public Optional<Integer> previous() {
        if(this.position.isEmpty()) {
            this.position = Optional.of(0);
        }
        return skip(-1);
    }

    @Override
    public void reset() {

    }
}
