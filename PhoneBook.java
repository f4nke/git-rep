import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, ArrayList<String>> phones = new HashMap<>();

    public PhoneBook() {
        this.phones = new HashMap<>();
    }

    public void add(String name, String phone) {
        ArrayList<String> book = phones.getOrDefault(name, new ArrayList<>());
        book.add(phone);
        phones.put(name, book);
    }

    public void get(String name) {
        System.out.println(name + ":" + phones.getOrDefault(name, new ArrayList<>()));
        }



    }

