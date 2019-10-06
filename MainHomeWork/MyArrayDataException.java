package MainHomeWork;

public class MyArrayDataException extends Exception{
    public int i;
    public int j;




    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }
}

