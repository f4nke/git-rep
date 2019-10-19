import java.util.*;

public class Main {
// Первое задание
    public static  void swap(Object[] arr, int x, int y) {
        Object obj = arr[x];
        arr[x] = arr[y];
        arr[y] = obj;
    }
// Второе
    public  static <T> ArrayList<T> toList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        Object[] arr = new Object[2];

        arr[0] = 1;
        arr[1] = 2;

        System.out.println(Arrays.toString(arr));
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));

        ArrayList<Object> newArr = toList(arr);
// Четвертое задание
        List<SomeClass> list = Arrays.asList(
                new SomeClass(1, "Test1"),
                new SomeClass(2, "Test1"),
                new SomeClass(3, "Test1"),
                new SomeClass(4, "Test2"),
                new SomeClass(5, "Test2"),
                new SomeClass(6, "Test3"),
                new SomeClass(7, "Test3"),
                new SomeClass(8, "Test4"));

        HashMap<String, List<Integer>> map = new HashMap<>();

        for (SomeClass item : list) {
            if(!map.containsKey(item.name)) {
                map.put(item.name, new ArrayList<>());
            }
            map.get(item.name).add(item.id);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue().toArray()));
        }

    }





}
