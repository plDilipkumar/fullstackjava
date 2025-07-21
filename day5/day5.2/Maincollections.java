import java.util.*;

public class Maincollections {
    public static void main(String[] args) {
        // List Example (ArrayList)
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // allows duplicates
        System.out.println("List (ArrayList): " + fruits);

        // Set Example (HashSet)
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // duplicate ignored
        System.out.println("Set (HashSet): " + numbers);

        // Map Example (HashMap)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(1, "C++"); // key 1 updated
        System.out.println("Map (HashMap): " + map);

        // Iterating through List
        System.out.println("\nIterating List:");
        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        // Iterating through Set
        System.out.println("\nIterating Set:");
        for(Integer num : numbers) {
            System.out.println(num);
        }

        // Iterating through Map
        System.out.println("\nIterating Map:");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
