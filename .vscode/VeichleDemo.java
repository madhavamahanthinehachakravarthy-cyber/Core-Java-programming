interface veichle {
    void start();

    default void stop() {
            System.out.println("Veichle is starting");
        }

    }
    class car implements veichle {
        @Override
        public void start() {
            System.out.println("Car is starting");
        }
    }
    public class VeichleDemo {
        public static void main(String[] args) {
            car c = new car();
            c.start();
            c.stop();
        }
}