import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if(fruits.size() == 0) {
            return 0.0f;
        }
        float w = 0.0f;
        for(T fruit : fruits) {
            w += fruit.getWeight();
        }
        return w;
    }

    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void transfer (Box<T> another) {
        another.fruits.addAll(this.fruits);
        this.fruits.clear();
    }


}
