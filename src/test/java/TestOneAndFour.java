import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class TestOneAndFour {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3, 4}, true},
                {new int[]{1, 1, 1, 4}, true},
                {new int[]{10, 0, 0, 3}, false},
        });
    }
    private int[] mass;
    private boolean check;

    public TestOneAndFour(int[] mass, boolean check) {
        this.mass = mass;
        this.check = check;
    }

    @Test
    public void test() {
        Assert.assertEquals(check, Task2.checkOneAndFour(mass));
    }

}
