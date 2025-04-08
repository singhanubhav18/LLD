package LRU;

public class Node<K,V> {
    K key;
    V value;
    Node<K,V>prev; //Double linked list
    Node <K,V> next;

    public Node(K key,V value){
        this.key=key;
        this.value=value;

    }
}
