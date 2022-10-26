package uz.pdp.array;

import java.util.Arrays;

public class DynamicArray<T> {
    private int initialCapacity;
    T[] objects;
    private int size = 0;


    public DynamicArray() {
        initialCapacity = 10;
        objects = (T[]) (new Object[initialCapacity]);
    }

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        objects = (T[]) (new Object[initialCapacity]);;
    }


    public void add(T newElement) {
        if (size == objects.length) {
            doublingArray();
        }
        objects[size] = newElement;
        size++;
    }

    public void add(T newElement, int index) {
        if (size == objects.length) {
            doublingArray();
        }
        if (index >= size) {
            objects[size] = newElement;
        } else {
            for (int i = size - 1; i >= index; i--) {
                objects[i + 1] = objects[i];
            }
            objects[index] = newElement;
        }

        size++;
    }


    public int size() {
        return size;
    }

    public boolean remove(int index) {
        if (index>-1&&index < size) {
            for (int i = index; i < size; i++) {
                objects[i] = objects[i + 1];
            }
            size--;
            if (size < objects.length / 2) {
                doubleShortening();
            }
            return true;
        }
        return false;
    }
    public boolean remove(T o) {
        return   remove(indexOf(o));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T o) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals( o)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        objects = (T[]) (new Object[initialCapacity]);
        size = 0;
    }

    public T get(int index) {
        if (index > size) {
            System.err.println(index+" is out of range");
            System.err.println("Max index is "+(size-1));
            return null;
        }
        return objects[index];
    }

    public T set(int index, T newElement) {
        if (index > size) {
            System.err.println(index+" is out of range");
            System.err.println("Max index is "+(size-1));
            return null;
        }
        T res = objects[index];
        objects[index] = newElement;
        return res;
    }

    public int indexOf(T o) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(o)){
                return i;
            }
        }
        return -1;
    }
    public int lastindexOf(T o) {
        for (int i = size-1; i >=0; i--) {
            if (objects[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    private void doublingArray() {
        T[] temp = Arrays.copyOf(objects, objects.length);
        objects =(T[]) (new Object[size * 2]);
        System.arraycopy(temp, 0, objects, 0, temp.length);
    }

    private void doubleShortening() {
        T[] temp = Arrays.copyOf(objects, size);
        objects = (T[]) (new Object[objects.length / 2]);
        System.arraycopy(temp, 0, objects, 0, temp.length);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(objects[i]);
            result.append(", ");
        }
        result.append("\b\b");

        result.append(']');
        return result.toString();
    }
}
