import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

//
//        // первое задание. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
//        File file3 = new File("Test/test1.txt");
//        try {
//            file3.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (FileInputStream in = new FileInputStream("Test/test1.txt")) {
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            int x;
//
//
//            while ((x = in.read()) != -1) {
//                out.write(x);
//                byte[] b = out.toByteArray();
//                System.out.println(Arrays.toString(b));
//                }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // второе задание Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
//
//        ArrayList<InputStream> ali = new ArrayList<>();
//        ali.add(new FileInputStream("Test/test1.txt"));
//        ali.add(new FileInputStream("Test/test2"));
//        ali.add(new FileInputStream("Test/test3.txt"));
//        ali.add(new FileInputStream("Test/test4.txt"));
//        ali.add(new FileInputStream("Test/test5.txt"));
//
//        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
//
//        Enumeration<InputStream> e = Collections.enumeration(ali);
//
//        int x;
//        while ((x = in.read()) > 0) {
//            System.out.println((char) x);
//        }

        // третье задание аписать консольное приложение, которое умеет постранично читать текстовые файлы
        // (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов),
        // программа выводит ее в консоль. Контролируем время выполнения:
        // программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.

        int page = 1800;
        RandomAccessFile raf = new RandomAccessFile("Test/test10mb.txt", "r");
        Scanner sc = new Scanner(System.in);
        System.out.println("Номер страницы: ");
        raf.seek(sc.nextInt()  * page);
        byte[] arr = new byte[1800];
        raf.read(arr);
        System.out.println(new String(arr, "windows-1251"));

    }



}
