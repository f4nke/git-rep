import java.util.ArrayList;
import java.util.Arrays;

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
    }
}
