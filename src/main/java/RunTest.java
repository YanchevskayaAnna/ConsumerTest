public class RunTest {
    public static void main(String[] args) {
        System.out.println("_________Test1_________");
        ConsumerTest2 test1 = new ConsumerTest2();
        test1.generate("some string").forEach(System.out::println);

        System.out.println("_________Test2_________");
        ConsumerTest2 test2 = new ConsumerTest2();
        test2.generate("some string").forEach(System.out::println);
    }
}
