import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BSTMap<K,V> implements Map61B<K,V>{
    int size;



    public BSTMap(){

    }


    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super K> action) {
        Map61B.super.forEach(action);
    }

    @Override
    public Spliterator<K> spliterator() {
        return Map61B.super.spliterator();
    }
}
