package LRU;

public class LruMain {
    public static void main(String[] args) {
        LruCache<Integer,String>cache=new LruCache<>(3);
        cache.put(1,"A");
        cache.put(2,"B");
        cache.put(3,"C");

        System.out.println("Cache contents:");
        cache.printCache();

        System.out.println("Accessing key 1:");
        cache.get(1);
        cache.printCache();

        System.out.println("inserting the  key 4:");
        cache.put(4,"D");
        System.out.println("-----------------------------------");
        cache.printCache();



    }



}
