import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] mass = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arrays(mass)));
    }

    public static int[] arrays (int[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }

        }
        throw new RuntimeException("В массиве нет 4");
    }

    public static boolean checkOneAndFour(int[] arr) {
        boolean check = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1 || arr[i] == 4) {
                check = true;
            }
            if (!(arr[i] == 1) && !(arr[i] == 4))
                check = false;
        }
        return check;
    }
}
