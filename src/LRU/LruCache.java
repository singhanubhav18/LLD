package LRU;

import java.util.HashMap;
import java.util.Map;

public class LruCache <K,V>{
    private final int capacity;//length of Cache to store the value
    private final Map<K,Node<K,V>> cache;
    private final Node<K,V> head;
    private final Node <K,V>tail;


    public LruCache(int capacity) {
        this.capacity = capacity;
        cache=new HashMap<>(capacity);
        head=new Node<>(null,null);
        tail=new Node<>(null,null);
        head.next=tail;
        tail.prev=head;
    }

    private void addToHead(Node <K,V>node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(Node<K,V>node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void moveToHead(Node <K,V>node){
        removeNode(node);
        addToHead(node);
    }

    private Node<K,V>removeTail(){
        Node <K,V>node=tail.prev;
        removeNode(node);
        return node;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node<>(key, value);
            cache.put(key, node);
            addToHead(node);
            if (cache.size() > capacity) {
                Node<K, V> removedNode = removeTail();
                cache.remove(removedNode.key);
            }
        }
    }


    public synchronized V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void printCache() {
        Node<K, V> current = head.next;
        while (current != tail) {
            System.out.println("Key: " + current.key + ", Value: " + current.value);
            current = current.next;
        }
    }

}
