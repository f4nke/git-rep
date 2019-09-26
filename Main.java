import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //ПЕРВОЕ ЗАДАНИЕ
        String[] lang = {"JAVA", "C++", "JAVA", "C#", "PYTHON", "DELPHI", "JAVA", "PYTHON"};
        HashMap<String, Integer> words = new HashMap<>();
        for (String o : lang) {
            words.put(o, words.getOrDefault(o, 0) + 1);
        }
        System.out.println(words);

        ////////////////////////////////////////////////////////////
        System.out.println("ВТОРОЕ ЗАДАНИЕ");
        ////////////////////////////////////////////////////////////
        PhoneBook book = new PhoneBook();

        book.add("Ivanov", "123456");
        book.add("Ivanov", "234567");
        book.add("Petrov", "111222");
        book.add("Kovalev", "222233");



        book.get("Sidorov");




    }


}




