public class SingleTonPattern {
    private static SingleTonPattern instance;

    private SingleTonPattern() {
        System.out.println("Singleton instance created");
    }

    public static synchronized SingleTonPattern getInstance() {
        if (instance == null) {
            instance = new SingleTonPattern();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        SingleTonPattern obj1 = SingleTonPattern.getInstance();
        SingleTonPattern obj2 = SingleTonPattern.getInstance();

        obj1.showMessage();

        System.out.println("Are both instances same? " + (obj1 == obj2));
    }
}
