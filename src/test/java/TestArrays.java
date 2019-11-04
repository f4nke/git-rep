import org.junit.Assert;
import org.junit.Test;

public class TestArrays {
    @Test
    public void testArrays1() {
        int[] mass = {1, 2, 3, 4, 3, 2 ,1};
        int[] arr = {3, 2, 1};
        Assert.assertArrayEquals(arr, Task2.arrays(mass));
    }

    @Test
    public void testArrays2() {
        int[] mass = {1, 2, 3, 4, 5, 5 ,5};
        int[] arr = {5, 5, 5};
        Assert.assertArrayEquals(arr, Task2.arrays(mass));
    }

    @Test
    public void testArrays3() {
        int[] mass = {1, 2, 3, 4, 6, 6 ,6};
        int[] arr = {6, 6, 6};
        Assert.assertArrayEquals(arr, Task2.arrays(mass));
    }
}


