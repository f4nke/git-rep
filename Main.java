import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 5, 2, 2, 4, 1, 4, 5, 1, 5, 3, 2, 4, 4, 4, 5, 1, 3};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int o: arr) {
            map.put(o, map.getOrDefault(o, 0) + 1);
        }
        System.out.println(map);
    }
}
