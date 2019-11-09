public class TestClass {
    @BeforeSuite
    public static void test1() {
        System.out.println("test1");
    }
    @Test(priority = 1)
    public static void test2() {
        System.out.println("test2");
    }
    @Test(priority = 10)
    public static void test3() {
        System.out.println("test3");
    }
    @AfterSuite
    public static void test4() {
        System.out.println("test4");
    }
}
