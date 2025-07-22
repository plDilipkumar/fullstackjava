package day6;
import java.util.*;

public class Advanced {
    public static void main(String[] args) {
        // ArrayList Example
        ArrayList<String> names = new ArrayList<>();
        names.add("Arun");
        names.add("Priya");
        names.add("Ravi");
        Collections.sort(names); // sorting
        System.out.println("ArrayList (Sorted Names): " + names);

        // LinkedList Example
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.addFirst(5);
        numbers.addLast(20);
        System.out.println("LinkedList (Numbers): " + numbers);

        // HashSet Example
        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Apple"); // duplicate ignored
        System.out.println("HashSet (Unique Fruits): " + fruits);

        // LinkedHashSet Example
        LinkedHashSet<String> animals = new LinkedHashSet<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        animals.add("Cat"); // duplicate ignored
        System.out.println("LinkedHashSet (Insertion Order Animals): " + animals);

        // TreeSet Example
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(50);
        scores.add(20);
        scores.add(40);
        scores.add(20); // duplicate ignored
        System.out.println("TreeSet (Sorted Scores): " + scores);

        // HashMap Example
        HashMap<Integer, String> students = new HashMap<>();
        students.put(101, "Arun");
        students.put(102, "Priya");
        students.put(103, "Ravi");
        System.out.println("HashMap (Roll:Name): " + students);

        // TreeMap Example
        TreeMap<Integer, String> ranks = new TreeMap<>();
        ranks.put(2, "Second");
        ranks.put(1, "First");
        ranks.put(3, "Third");
        System.out.println("TreeMap (Sorted Ranks): " + ranks);

        // Queue Example using PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println("PriorityQueue (Min Heap order): " + pq);

        // Polling elements from PriorityQueue
        System.out.println("Polling from PriorityQueue:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // Queue Example using LinkedList
        Queue<String> queue = new LinkedList<>();
        queue.add("Task1");
        queue.add("Task2");
        queue.add("Task3");
        System.out.println("Queue using LinkedList: " + queue);
        System.out.println("Polling from Queue: " + queue.poll()); // removes first element
        System.out.println("Queue after polling: " + queue);

        // Deque Example using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Front");
        deque.addLast("Rear");
        deque.addFirst("New Front");
        System.out.println("Deque Elements: " + deque);
        System.out.println("Removing from Deque Front: " + deque.removeFirst());
        System.out.println("Deque after removing front: " + deque);

        // Iterating HashMap
        System.out.println("\nIterating HashMap:");
        for(Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Roll: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        // Iterating TreeMap
        System.out.println("\nIterating TreeMap:");
        for(Map.Entry<Integer, String> entry : ranks.entrySet()) {
            System.out.println("Rank: " + entry.getKey() + ", Position: " + entry.getValue());
        }

        // Using Iterator on ArrayList
        System.out.println("\nUsing Iterator on ArrayList:");
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

/**
| **Function**                     | **Applicable To**                | **Definition**                                    |
| -------------------------------- | -------------------------------- | ------------------------------------------------- |
| **add(element)**                 | List, Set, Queue, Deque          | Adds an element                                   |
| **addFirst(element)**            | LinkedList, Deque                | Adds at beginning                                 |
| **addLast(element)**             | LinkedList, Deque                | Adds at end                                       |
| **get(index)**                   | List                             | Returns element at index                          |
| **set(index, element)**          | List                             | Replaces element at index                         |
| **remove(index/object)**         | List                             | Removes by index or value                         |
| **removeFirst() / removeLast()** | LinkedList, Deque                | Removes and returns first/last                    |
| **poll()**                       | Queue, LinkedList, PriorityQueue | Retrieves and removes head; returns null if empty |
| **pollFirst() / pollLast()**     | Deque, TreeSet                   | Retrieves and removes first/last element          |
| **peek()**                       | Queue, LinkedList, PriorityQueue | Retrieves head without removing                   |
| **peekFirst() / peekLast()**     | Deque                            | Retrieves first/last without removing             |
| **contains(element)**            | All Collections                  | Checks if element exists                          |
| **size()**                       | All Collections                  | Returns number of elements                        |
| **clear()**                      | All Collections                  | Removes all elements                              |
| **isEmpty()**                    | All Collections                  | Checks if collection is empty                     |
| **iterator()**                   | All Collections                  | Returns iterator to traverse                      |
| **put(key, value)**              | Map                              | Adds or updates entry                             |
| **get(key)**                     | Map                              | Returns value for key                             |
| **remove(key)**                  | Map                              | Removes entry by key                              |
| **keySet()**                     | Map                              | Returns Set of keys                               |
| **values()**                     | Map                              | Returns Collection of values                      |
| **entrySet()**                   | Map                              | Returns Set of key-value pairs                    |
| **first() / last()**             | TreeSet                          | Returns smallest/largest element                  |
| **pollFirst() / pollLast()**     | TreeSet                          | Retrieves and removes first/last element          |
| **firstEntry() / lastEntry()**   | TreeMap                          | Returns first/last key-value pair                 |
| **Collections.sort(list)**       | Collections utility              | Sorts list ascending                              |
| **Collections.reverse(list)**    | Collections utility              | Reverses list order                               |
**/