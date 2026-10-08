import java.util.*;

public class Task5 {
    public static void main(String[] args) {

        // 1. Collection / List
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("C");
        list.add("Java");

        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Contains Java: " + list.contains("Java"));
        System.out.println("Element at index 1: " + list.get(1));

        list.set(1, "C++");
        System.out.println("After set: " + list);

        list.remove("C");
        System.out.println("After remove: " + list);

        // 2. Set
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // Duplicate will not be added

        System.out.println("\nSet: " + set);
        System.out.println("Contains 20: " + set.contains(20));
        System.out.println("Set Size: " + set.size());

        // 3. SortedSet
        SortedSet<Integer> sortedSet = new TreeSet<>();

        sortedSet.add(50);
        sortedSet.add(10);
        sortedSet.add(30);
        sortedSet.add(20);

        System.out.println("\nSortedSet: " + sortedSet);
        System.out.println("First: " + sortedSet.first());
        System.out.println("Last: " + sortedSet.last());

        // 4. NavigableSet
        NavigableSet<Integer> navSet = new TreeSet<>(sortedSet);

        System.out.println("\nNavigableSet: " + navSet);
        System.out.println("Lower than 30: " + navSet.lower(30));
        System.out.println("Floor of 30: " + navSet.floor(30));
        System.out.println("Ceiling of 25: " + navSet.ceiling(25));
        System.out.println("Higher than 30: " + navSet.higher(30));

        // 5. Queue
        Queue<String> queue = new LinkedList<>();

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println("\nQueue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // 6. Deque
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);

        System.out.println("\nDeque: " + deque);
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque after removal: " + deque);

        // 7. Map
        Map<Integer, String> map = new HashMap<>();

        map.put(101, "Neha");
        map.put(102, "Anu");
        map.put(103, "Ravi");

        System.out.println("\nMap: " + map);
        System.out.println("Value of key 101: " + map.get(101));
        System.out.println("Contains key 102: " + map.containsKey(102));
        System.out.println("Contains value Ravi: " + map.containsValue("Ravi"));

        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Entries: " + map.entrySet());

        // 8. SortedMap
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(3, "C");
        sortedMap.put(1, "A");
        sortedMap.put(2, "B");

        System.out.println("\nSortedMap: " + sortedMap);
        System.out.println("First Key: " + sortedMap.firstKey());
        System.out.println("Last Key: " + sortedMap.lastKey());

        // 9. NavigableMap
        NavigableMap<Integer, String> navMap = new TreeMap<>(sortedMap);

        System.out.println("\nNavigableMap: " + navMap);
        System.out.println("Lower Key than 2: " + navMap.lowerKey(2));
        System.out.println("Floor Key of 2: " + navMap.floorKey(2));
        System.out.println("Ceiling Key of 2: " + navMap.ceilingKey(2));
        System.out.println("Higher Key than 2: " + navMap.higherKey(2));

        // 10. Iterator
        System.out.println("\nIterator:");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}